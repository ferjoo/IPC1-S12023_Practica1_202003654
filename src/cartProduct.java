public class cartProduct {
    // attributes
    private String id;
    private String name;
    private double price;
    private int quantity;
    // constructor
    public cartProduct(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    // getters and setters
    public String getId() {
        return id;
    }
    public void setId() {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName() {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice() {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int i) {
        this.quantity = quantity;
    }
}
