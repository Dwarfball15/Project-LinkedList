
public class Meat {

    private String name;    // name of the meat cut
    private double weight;  // weight in pounds
    private double price;   // price per pound in USD

    // Constructor
    public Meat(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    // Return
    @Override
    public String toString() {
        return String.format("%-10s | Weight: %.1f lbs | Price: $%.2f/lb | Total: $%.2f",
                name, weight, price, weight * price);
    }
}