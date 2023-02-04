public class reportProduct {
    // use only name and timesSold
    private String name;
    private int timesSold;
    // constructor
    public reportProduct(String name, int timesSold) {
        this.name = name;
        this.timesSold = timesSold;
    }
    // getters and setters
    public String getName() {
        return name;
    }
    public void setName() {
        this.name = name;
    }
    public int getTimesSold() {
        return timesSold;
    }
    public void setTimesSold(int i) {
        this.timesSold = i;
    }

}
