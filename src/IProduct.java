public interface IProduct {
    String getName();
    void setName(String newName);
    double getPrice();
    void setPrice(double newPrice);
    int getQuantity();
    void setQuantity(int newQuantity);
    void addQuantity(int quantityToAdd);
    void subtractQuantity(int quantityToSubtract);
    boolean hasSufficientQuantity(int requiredQuantity);
}

