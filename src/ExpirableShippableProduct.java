import java.util.Date;
import java.util.Objects;

public class ExpirableShippableProduct extends AbstractProduct implements IShippable, IExpirable {
    private final Date expirationDate;
    private final double weight; // in Kg

    public ExpirableShippableProduct(String name, double price, int quantity, Date expirationDate, double weight) {
        super(name, price, quantity);
        this.expirationDate = expirationDate; // TODO: validation
        this.weight = weight; // TODO: validation
    }

    @Override
    public boolean isExpired() {
        return expirationDate.before(new Date());
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ExpirableShippableProduct other = (ExpirableShippableProduct) obj;
        return Double.compare(getPrice(), other.getPrice()) == 0 &&
                getQuantity() == other.getQuantity() &&
                Double.compare(weight, other.weight) == 0 &&
                Objects.equals(getName(), other.getName()) &&
                Objects.equals(expirationDate, other.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getQuantity(), expirationDate, weight);
    }
}
