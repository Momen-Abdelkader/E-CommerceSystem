import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(IProduct product, int quantity) {
        if (!product.hasSufficientQuantity(quantity)) {
            throw new RuntimeException(product.getName() + " doesn't have sufficient quantity in stock");
        }

        CartItem existingItem = findItemByProduct(product);
        if (existingItem != null) {
            int newQuantity = existingItem.getRequestedQuantity() + quantity;
            if (!product.hasSufficientQuantity(newQuantity)) {
                throw new RuntimeException(product.getName() + " doesn't have sufficient quantity in stock");
            }

            existingItem.setRequestedQuantity(newQuantity);
        }
        else {
            items.add(new CartItem(product, quantity));
        }
    }

    public void removeItem(IProduct product) {
        CartItem existingItem = findItemByProduct(product);
        if (existingItem == null) {
            throw new RuntimeException(product.getName() + " is not in the cart");
        }
        items.remove(existingItem);
    }

    public double getTotalCartPrice() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getItemPrice();
        }
        return total;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }

    private CartItem findItemByProduct(IProduct product) {
        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                return item;
            }
        }
        return null;
    }
}
