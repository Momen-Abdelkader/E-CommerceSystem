public interface IProduct {
    String getName();
    void setName();
    double getPrice();
    void setPrice();
    int getQuantity();
    void setQuantity(int newQuantity);
    void addQuantity(int addedQuantity);
    void subtractQuantity(int subtractedQuantity);
    boolean isSufficientQuantity(int requiredQuantity);
}

