public class CartItem {
    private IProduct product;
    private int quantity;

    public CartItem(IProduct product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public IProduct getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int newQuantity) {
        quantity = newQuantity;
    }

    public double getItemPrice() {
        return product.getPrice() * quantity;
    }
}
