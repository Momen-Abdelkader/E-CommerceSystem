import java.util.ArrayList;
import java.util.List;

class CheckoutService {
    private ShippingService shippingService;

    public CheckoutService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public void checkout(Customer customer, Cart cart) {
        double subtotal = cart.getTotalCartPrice();
        List<IShippable> shippableItems = collectShippableItems(cart);
        double shippingFee = shippingService.getShippingFee();
        double totalAmount = subtotal + shippingFee;

        validateCheckout(customer, cart, totalAmount);
        shippingService.ship(shippableItems);
        updateInventory(cart);
        customer.deductBalance(totalAmount);
        printReceipt(cart, subtotal, shippingFee, totalAmount, customer.getBalance());
    }

    private List<IShippable> collectShippableItems(Cart cart) {
        List<IShippable> shippableItems = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            if (item.getProduct() instanceof IShippable) {
                /* I think this could be implemented better with the IShippable interface to have a getQuanity() method,
                 but the task said that the interface must be: "containing only String getName() and double getWeight() methods."
                 */

                // Add each unit separately for shipping (to be able to count and calculate total weight when shipping)
                for (int i = 0; i < item.getRequestedQuantity(); i++) {
                    shippableItems.add((IShippable) item.getProduct());
                }
            }
        }

        return shippableItems;
    }

    private void validateCheckout(Customer customer, Cart cart, double totalAmount) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }

        for (CartItem item : cart.getItems()) {
            IProduct product = item.getProduct();

            if (!product.hasSufficientQuantity(item.getRequestedQuantity())) {
                throw new IllegalStateException("Product out of stock: " + product.getName());
            }

            if (product instanceof IExpirable && ((IExpirable) product).isExpired()) {
                throw new IllegalStateException("Product expired: " + product.getName());
            }
        }

        if (!customer.hasSufficientBalance(totalAmount)) {
            throw new IllegalStateException("Insufficient balance. Required: " + totalAmount + ", Available: " + customer.getBalance());
        }
    }

    private void updateInventory(Cart cart) {
        for (CartItem item : cart.getItems()) {
            item.getProduct().subtractQuantity(item.getRequestedQuantity());
        }
    }

    private void printReceipt(Cart cart, double subtotal, double shippingFee,
                              double totalAmount, double remainingBalance) {
        System.out.println("\n** Checkout receipt **");

        for (CartItem item : cart.getItems()) {
            System.out.println(item.getRequestedQuantity() + "x " + item.getProduct().getName() +
                    " $" +  item.getItemPrice());
        }

        System.out.println("----------------------");
        System.out.println("Subtotal $" + subtotal);
        System.out.println("Shipping $" + shippingFee);
        System.out.println("Amount $" + totalAmount);
        System.out.println("Customer balance after payment: $" + remainingBalance);
    }
}