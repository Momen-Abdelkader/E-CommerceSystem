import java.util.Date;
import java.util.Objects;

public class ExpirableProduct extends AbstractProduct implements IExpirable {
    private final Date expirationDate;

    public ExpirableProduct(String name, double price, int quantity, Date expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate; // TODO: add validation for date
    }

    @Override
    public boolean isExpired() {
        return expirationDate.before(new Date());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ExpirableProduct other = (ExpirableProduct) obj;
        return Double.compare(getPrice(), other.getPrice()) == 0 &&
                getQuantity() == other.getQuantity() &&
                Objects.equals(getName(), other.getName()) &&
                Objects.equals(expirationDate, other.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getQuantity(), expirationDate);
    }
}
