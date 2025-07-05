import java.util.List;

public class ECommerceSystem {
    public static void main(String[] args) {
        ShippableProduct cheese = new ShippableProduct("Cheese", 5, 1, 0.2);
        ShippableProduct cheese2 = new ShippableProduct("Cheese", 5, 1, 0.2);
        ShippableProduct biscuits = new ShippableProduct("Biscuits", 3, 4, 0.7);
        ShippingService shippingService = new ShippingService();
        shippingService.ship(List.of(cheese, cheese2, biscuits));
    }
}