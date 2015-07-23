package src;

import java.util.List;

/**
 * Order
 * @author Max Hentschel, Felix Brass
 *
 */
public class Order {
    private Product product;
    public boolean isInRange;
    private boolean inRange;
    private int price;
    private double distance;

    public void addProduct(Product prod) {
    }

    public boolean submitOrder() {
        return false;
    }

    public double calcPrice(List<Product> prodList) {
        return 0;
    }

    public void setLocation(double v, double v1) {
    }

    public int calcDeliveryTime() {
        return 0;
    }

    public double getDistance() {
        return distance;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public boolean isInRange() {
        return inRange;
    }

    public int getPrice() {
        return price;
    }

    public int calcTravelCost(double distance) {
        return 0;
    }

    public double calcRevenue(int i) {
        return 0;
    }
}
