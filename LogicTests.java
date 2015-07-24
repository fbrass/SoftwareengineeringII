import org.junit.Test;
import src.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * LogicTests
 * @author Max Hentschel, Felix Brass
 *
 */
public class LogicTests {

	/**
	 * testLogin
	 * Tests the logIn function from LoginChecker.
	 */
	@Test
	public void testLogin() {
		LoginChecker lc = new LoginChecker("testDB");
		
		assertEquals("User: admin with pw: root123 should login.", true, lc.logIn("admin", "root123")); // successful admin login
		assertEquals("User: Uwe with pw: fasel should not login.",false, lc.logIn("Uwe", "fasel")); // user Uwe does not exist and should not login
		
	}
	
	/**
	 * Test for order
	 */
	@Test
	public void testOrder() {
		Order ord = new Order();
		Product prod = new Product("Produkt");
		ord.addProduct(prod);

		assertEquals("Valid order should submit successfully.", true, ord.submitOrder());
		
	}

	/**
	 * Test for price calculation
	 */
	@Test
	public void testPriceCalculation() {
		Product prod1 = new Product("Produkt1");
		prod1.setPrice(11.50);
		Product prod2 = new Product("Produkt2");

		prod2.setPrice(3.99);
		Order ord = new Order();
		List<Product> prodList = new ArrayList<Product>();
		prodList.add(prod2);
		prodList.add(prod1);
		
		assertEquals("11.50 plus 3.99 should be 15.49", 15.49, ord.calcPrice(prodList));
	}
	
	/**
	 * Test for delivery time
	 */
	@Test
	public void testDeliveryTime() {
		Product prod1 = new Product("Produkt1");
		prod1.setLengthOfProduction(10.00);
		Order ord = new Order();
		ord.addProduct(prod1);
		
		// Location is in range and 15 Minutes away
		ord.setLocation(48.155254, 11.555678);
		assertEquals("HM location is in range and should be delivered in 25 Minutes", 25, ord.calcDeliveryTime());
		
		// Location is not in range
		ord.setLocation(41.84201, -89.485937);
		assertEquals("PB location is not in range and cannot be delivered, so 999 is expected.", 999, ord.calcDeliveryTime());
		
	}
	
	/**
	 * Test for a route distance calculation
	 */
	@Test
	public void testRouteDistance() {
		Order ord = new Order();
		
		// Location is in range and 15 Minutes away
		ord.setLocation(48.155254, 11.555678);
		assertEquals("HM location is 12.34 km away", 12.34, ord.getDistance());
		
		// Location is not in range
		ord.setLocation(41.84201, -89.485937);
		assertEquals("PB location is 123456789.01 km", 123456789.01, ord.getDistance());
	}
	
	/**
	 * Test for adding components to pizza
	 */
	@Test
	public void testAddingComponents() {
		Components comps1 = new Components();
		Order ord = new Order();
		Product prod = new Product();
		Category cat = new Category();
		Customer cus = new Customer();
		
		assertEquals("Order added successfully to component", true, comps1.addOrder(ord));
		assertEquals("Product added successfully to component", true, comps1.addProduct(prod));
		assertEquals("Category added successfully to component", true, comps1.addCategory(cat));
		assertEquals("Customer added successfully to component", true, comps1.addCustomer(cus));
	}
	
	/**
	 * Test for deleting comonents from a pizza
	 */
	@Test
	public void testDeletingComponents() {
		Components comps1 = new Components();
		Order ord = new Order();
		Product prod = new Product();
		Category cat = new Category();
		Customer cus = new Customer();
		comps1.addOrder(ord);
		comps1.addProduct(prod);
		comps1.addCategory(cat);
		comps1.addCustomer(cus);
		
		assertEquals("Order deleted successfully from component", true, comps1.deleteOrder(ord));
		assertEquals("Product deleted successfully from component", true, comps1.deleteProduct(prod));
		assertEquals("Category deleted successfully from component", true, comps1.deleteCategory(cat));
		assertEquals("Customer deleted successfully from component", true, comps1.deleteCustomer(cus));
	}
	
	/**
	 * Test for changing components of a pizza
	 */
	@Test
	public void testChangeComponents() {
		Components comps1 = new Components();
		Order ord1 = new Order();
		Product prod1 = new Product();
		Category cat1 = new Category();
		Customer cus1 = new Customer();
		Order ord2 = new Order();
		Product prod2 = new Product();
		Category cat2 = new Category();
		Customer cus2 = new Customer();
		comps1.addOrder(ord1);
		comps1.addProduct(prod1);
		comps1.addCategory(cat1);
		comps1.addCustomer(cus1);
		
		assertEquals("Order deleted successfully deleted component", true, comps1.changeOrder(ord2));
		assertEquals("Product deleted successfully from component", true, comps1.changeProduct(prod2));
		assertEquals("Category deleted successfully from component", true, comps1.changeCategory(cat2));
		assertEquals("Customer deleted successfully from component", true, comps1.changeCustomer(cus2));
	}
	
	/**
	 * Test for revenue calucaltion
	 */
	@Test
	public void testRevenueCalculation() {
		Order ord1 = new Order();
		Product prod1 = new Product("Produkt1");
		prod1.setInternalCost(3.50);
		prod1.setPrice(11.00);
		
		ord1.setProduct(prod1);
		ord1.setLocation(48.155254, 11.555678);
		if (ord1.isInRange())	{
			assertEquals("Revenue should be 5.50", 5.50, ord1.calcRevenue(ord1.calcTravelCost(ord1.getDistance()) - ord1.getPrice()));
		}
		
	}
	
	/**
	 * Test for max Distance
	 */
	@Test
	public void testDistanceMoreThan20KM() {
		Order ord = new Order();
		
		// Location is in range and 15 Minutes away
		ord.setLocation(48.155254, 11.555678);
		assertEquals("HM location is in range", true, ord.isInRange());
		
		// Location is not in range
		ord.setLocation(41.84201, -89.485937);
		assertEquals("PB location is not in range", false, ord.isInRange());
	}

}
