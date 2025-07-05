public abstract class AbstractProduct implements IProduct {
    protected String name;
    protected double price;
    protected int quantity;

    public AbstractProduct(String name, double price, int quantity) {
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String newName) {
        if (newName == null) {
            throw new IllegalArgumentException("Error modifying " + getName() + ": Name cannot be null");
        }

        name = newName;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double newPrice) {
        if (newPrice < 0) {
            throw new IllegalStateException("Error modifying " + getName() + ": Price must be greater than 0");
        }

        price = newPrice;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int newQuantity) {
        if (newQuantity < 0) {
            throw new IllegalStateException("Error modifying " + getName() + ": Quantity must be greater than 0");
        }

        quantity = newQuantity;
    }

    @Override
    public void addQuantity(int quantityToAdd) {
        quantity += quantityToAdd;
    }

    @Override
    public void subtractQuantity(int quantityToSubtract) {
        if (quantityToSubtract > quantity) {
            throw new IllegalStateException(getName() + " doesn't have sufficient quantity in stock");
        }

        quantity -= quantityToSubtract;
    }

    @Override
    public boolean hasSufficientQuantity(int requiredQuantity) {
        return quantity >= requiredQuantity;
    }
}
