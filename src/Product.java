package src;

/**
 * Created by Max on 23.07.15.
 */
public class Product {
    private double price;
    private String produkt;
    private double lengthOfProduction;
    private double internalCost;

    public Product(String produkt) {
        this.produkt = produkt;
    }

    public Product() {

    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setLengthOfProduction(double lengthOfProduction) {
        this.lengthOfProduction = lengthOfProduction;
    }

    public void setInternalCost(double internalCost) {
        this.internalCost = internalCost;
    }
}
