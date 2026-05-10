public class Meat {
    private String name;
    private double weight;
    private double price;

    public Meat(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " | " + weight + " lbs | $" + price;
    }
}
