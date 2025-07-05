import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ShippableProduct other = (ShippableProduct) obj;
        return Double.compare(getPrice(), other.getPrice()) == 0 &&
                getQuantity() == other.getQuantity() &&
                Double.compare(weight, other.weight) == 0 &&
                Objects.equals(getName(), other.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getQuantity(), weight);
    }
}
