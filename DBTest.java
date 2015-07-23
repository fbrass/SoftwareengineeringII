/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import junit.framework.TestCase;
import src.Customer;
import src.Order;
import src.Room;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.ws.Service;
import java.util.*;

/**
 *
 * @author said
 */
public class DBTest extends TestCase {

    private EntityManager em;
    private static final String PERSISTENCE_UNIT_NAME = "com.mycompany_Pizzaservice_jar_1.0-SNAPSHOTPU";
    private Customer c;

    public DBTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        EntityManagerFactory factory
                = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();

        this.c = new Customer("max", "mustermann");
        persistObject(c);


    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();

        em.close();

    }


    public void testAddAndRemoveCustomer() throws Exception {
        em.getTransaction().begin();

        Customer c3 = new Customer();
        c3.setAdress("TestStreet");
        Collection<Order> orders= new ArrayList<Order>();
        c3.setOrder(orders);
        em.persist(c3);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Customer c2 = em.find(Customer.class, c3.getId());
        if (!c2.equals(c3)) {
            throw new Exception();
        }
        em.remove(c3);
        em.getTransaction().commit();

    }

    public void testTransaction() {
        em.getTransaction().begin();
        em.getTransaction().commit();
    }

    private void persistObject(Object o) {
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
    }

}
