public class ShippableProduct extends AbstractProduct implements IShippable {
    private final double weight; // in Kg
    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight; // TODO: add validation for weight
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
