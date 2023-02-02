package coupon;

public class coupon {
    // attributes
    private String name;
    private double discount;
    private int id;
    // constructor
    public coupon(String name, double discount, int id) {
        this.name = name;
        this.discount = discount;
        this.id = id;
    }
    // getters and setters
    public String getName() {
        return name;
    }
    public void setName() {
        this.name = name;
    }

    public double getDiscount() {
        return discount;
    }
    public void setDiscount() {
        this.discount = discount;
    }

    public int getId() {
        return id;
    }
    public void setId() {
        this.id = id;
    }
}
