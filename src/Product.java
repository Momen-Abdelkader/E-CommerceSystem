import java.util.Objects;

// Not shippable and not expirable
public class Product extends AbstractProduct {
    public Product(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Product other = (Product) obj;
        return Double.compare(getPrice(), other.getPrice()) == 0 &&
                getQuantity() == other.getQuantity() &&
                Objects.equals(getName(), other.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getQuantity());
    }
}
