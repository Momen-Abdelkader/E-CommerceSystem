import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShippingService {
    private final static double SHIPPING_FEE = 30.0;

    public void ship(List<IShippable> shippableItems) {
        if (shippableItems.isEmpty()) {
            return;
        }

        System.out.println("** shipping notice **");
        Map<String, Integer> itemCounts = new HashMap<>();
        double totalWeight = 0;

        for (IShippable item : shippableItems) {
            String key = item.getName() + "_" + item.getWeight();
            itemCounts.put(key, itemCounts.getOrDefault(key, 0) + 1);
            totalWeight += item.getWeight();
        }

        for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
            String[] parts = entry.getKey().split("_");
            String name = parts[0];
            double weight = Double.parseDouble(parts[1]);
            int count = entry.getValue();

            System.out.println(count + "x " + name + " " + count * weight + "kg");
        }

        System.out.println("Total package weight " + totalWeight + "kg");
    }

    public double getShippingFee() {
        return SHIPPING_FEE;
    }
}
