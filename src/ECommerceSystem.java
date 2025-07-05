import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ECommerceSystem {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 30);
        Date futureDate = cal.getTime();

        cal.add(Calendar.DAY_OF_MONTH, -60);
        Date pastDate = cal.getTime();

        CheckoutService checkoutService = new CheckoutService(new ShippingService());
        Customer customer = new Customer("John Doe", 1000);

        System.out.println("---- Successful Checkout Example ----");
        try {
            Product scratchCard = new Product("Mobile Scratch Card", 50, 20);
            ShippableProduct tv = new ShippableProduct("TV", 500, 5, 2.5);
            ExpirableShippableProduct cheese = new ExpirableShippableProduct("Cheese", 100, 10, futureDate, 0.2);
            ExpirableShippableProduct biscuits = new ExpirableShippableProduct("Biscuits", 150, 8, futureDate, 0.7);

            Cart cart = new Cart();
            cart.addItem(cheese, 2);
            cart.addItem(tv, 1);
            cart.addItem(scratchCard, 1);
            cart.addItem(biscuits, 1);
            checkoutService.checkout(customer, cart);
        }
        catch (Exception e) {
            System.out.println("Checkout Failed: " + e.getMessage());
        }

        System.out.println("\n---- Expired Product Example ----");
        try {
            ExpirableProduct expiredCheese = new ExpirableProduct("Expired Cheese", 100, 5, pastDate);
            Cart expiredCart = new Cart();
            expiredCart.addItem(expiredCheese, 1);
            checkoutService.checkout(customer, expiredCart);
        }
        catch (Exception e) {
            System.out.println("Checkout Failed: " + e.getMessage());
        }


        System.out.println("\n---- Insufficient Balance Example ----");
        try {
            ShippableProduct expensiveTv = new ShippableProduct("TV", 1000, 5, 2.5);
            Customer poorCustomer = new Customer("Poor Customer", 10);
            Cart expensiveCart = new Cart();
            expensiveCart.addItem(expensiveTv, 1);
            checkoutService.checkout(poorCustomer, expensiveCart);
        }
        catch (Exception e) {
            System.out.println("Checkout Failed: " + e.getMessage());
        }

        System.out.println("\n---- Empty Cart Example ----");
        try {
            Cart emptyCart = new Cart();
            checkoutService.checkout(customer, emptyCart);
        }
        catch (Exception e) {
            System.out.println("Checkout Failed: " + e.getMessage());
        }

        System.out.println("\n---- Out of Stock Example ----");
        try {
            IProduct limitedProduct = new ShippableProduct("Limited Edition", 200, 1, 0.5);
            Cart oversizedCart = new Cart();
            oversizedCart.addItem(limitedProduct, 5);
        }
        catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }

    }
}