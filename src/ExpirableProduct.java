import java.util.Date;

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
}
