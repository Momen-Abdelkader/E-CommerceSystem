public abstract class AbstractProduct implements IProduct {
    protected String name;
    protected double price;
    protected int quantity;

    public AbstractProduct(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String newName) {
        name = newName;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double newPrice) {
        price = newPrice;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int newQuantity) {
        quantity = newQuantity;
    }

    @Override
    public void addQuantity(int quantityToAdd) {
        quantity += quantityToAdd;
    }

    @Override
    public void subtractQuantity(int quantityToSubtract) {
        if (quantityToSubtract > quantity) {
            throw new RuntimeException(getName() + " doesn't have sufficient quantity in stock");
        }

        quantity -= quantityToSubtract;
    }

    @Override
    public boolean hasSufficientQuantity(int requiredQuantity) {
        return quantity >= requiredQuantity;
    }
}
