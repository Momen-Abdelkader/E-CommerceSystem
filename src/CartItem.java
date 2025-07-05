public class CartItem {
    private IProduct product;
    private int requestedQuantity;

    public CartItem(IProduct product, int quantity) {
        this.product = product;
        this.requestedQuantity = quantity; // this is the requested quantity which is different from the actual quantity inside the product variable (stock)
    }

    public IProduct getProduct() {
        return product;
    }

    public int getRequestedQuantity() {
        return requestedQuantity;
    }

    public void setRequestedQuantity(int newQuantity) {
        requestedQuantity = newQuantity;
    }

    public double getItemPrice() {
        return product.getPrice() * requestedQuantity;
    }
}
