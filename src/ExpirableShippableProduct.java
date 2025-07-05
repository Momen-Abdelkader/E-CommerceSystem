import java.util.Date;

public class ExpirableShippableProduct extends AbstractProduct implements IShippable, IExpirable {
    private final Date expirationDate;
    private final double weight; // in Kg

    public ExpirableShippableProduct(String name, double price, int quantity, Date expirationDate, double weight) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
        this.weight = weight;
    }

    @Override
    public boolean isExpired() {
        return expirationDate.before(new Date());
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
