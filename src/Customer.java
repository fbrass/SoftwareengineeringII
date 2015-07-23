package src;

import java.util.Collection;

/**
 * Customer
 * @author Max Hentschel, Felix Brass
 *
 */
public class Customer {
    private String adress;
    private Collection<Order> order;
    private Object id;

    public Customer(String vorname, String nachname) {

    }

    public Customer() {

    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setOrder(Collection<Order> order) {
        this.order = order;
    }

    public Object getId() {
        return id;
    }
}
