// ============================================================
// File:    Meat.java
// Author:  Eric
// Course:  IS 247
// Purpose: Custom data class representing a cut of meat.
//          Reused from a previous assignment.
//          Attributes: name (String), weightLbs (double),
//          pricePerLb (double).
//          Implements Comparable so items can be sorted by
//          price per pound.
// ============================================================

public class Meat implements Comparable<Meat> {

    private String name;          // name of the cut
    private double weightLbs;     // weight in pounds
    private double pricePerLb;    // price per pound in USD

    // Parameterized constructor
    public Meat(String name, double weightLbs, double pricePerLb) {
        this.name       = name;
        this.weightLbs  = weightLbs;
        this.pricePerLb = pricePerLb;
    }

    // Getters
    public String getName()       { return name;       }
    public double getWeightLbs()  { return weightLbs;  }
    public double getPricePerLb() { return pricePerLb; }

    // Setters
    public void setName(String name)           { this.name = name;             }
    public void setWeightLbs(double w)         { this.weightLbs = w;           }
    public void setPricePerLb(double p)        { this.pricePerLb = p;          }

    // Total cost helper
    public double totalCost() {
        return weightLbs * pricePerLb;
    }

    // compareTo – order by price per pound (ascending)
    @Override
    public int compareTo(Meat other) {
        return Double.compare(this.pricePerLb, other.pricePerLb);
    }

    // toString – nicely formatted output
    @Override
    public String toString() {
        return String.format("%-20s | Weight: %5.2f lb  | $%5.2f/lb  | Total: $%6.2f",
                             name, weightLbs, pricePerLb, totalCost());
    }
}
