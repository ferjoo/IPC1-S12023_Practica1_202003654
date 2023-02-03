public class product {
    // atrbutes autoincrement id, name, price
    private int id;
    private String name;
    private double price;
    private int timesSold;
    // constructor
    public product(String name, double price, int id, int timesSold) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.timesSold = timesSold;
    }

    // getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
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

    public int getTimesSold() {
        return timesSold;
    }
    public void setTimesSold(int i) {
        this.timesSold = timesSold;
    }
}
