package ch8;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
 * You have a class with many equal instances that you want to replace with a single object
 * 
 * Turn the object into a reference object
 * 
 * - Value objects: Things like date or money. They are defined entirely through their data values
 *                  You don't mind the copies existed, you do need to tell whether two of the object
 *                  are equal
 * - Reference objects: Like customer or account. Stands for one object in real world, and you use the
 *                      object identity to test whether they are equal
 * 
 * - The decision between value and reference is not always clear. But start with value and can change to
 *   reference later on
 */
class Customer {
  private final String _name;

  public Customer(String name) {
    _name = name;
  }

  public String getName() {
    return _name;
  }
}

class Order {
  private Customer _customer;

  public Order(String customerName) {
    _customer = new Customer(customerName);
  }

  public String getCustomerName() {
    return _customer.getName();
  }

  public void setCustomer(String customerName) {
    _customer = new Customer(customerName);
  }
}

class Client {
  private static int numberOfOrdersFor(Collection orders, String customer) {
    int result = 0;
    Iterator iter = orders.iterator();
    while (iter.hasNext()) {
      Order each = (Order) iter.next();
      if (each.getCustomerName().equals(customer))
        result++;
    }
    return result;
  }
}

class CustomerRefactored {
  private final String _name;
  private static Map _instances = new HashMap<>();

  public static Customer create(String name) {
    return (Customer) _instances.get(name);
  }

  public static void loadCustomers() {
    new CustomerRefactored("Lemon Car Hire").store();
    new CustomerRefactored("Associated Coffee Machines").store();
    new CustomerRefactored("Bilston Gasworks").store();
  }

  private void store() {
    _instances.put(this.getName(), this);
  }

  private CustomerRefactored(String name) {
    _name = name;
  }

  public static CustomerRefactored getNamed(String name) {
    return (CustomerRefactored) _instances.get(name);
  }

  public String getName() {
    return _name;
  }
}

class OrderRefactored {
  private Customer _customer;

  public OrderRefactored(String customerName) {
    _customer = CustomerRefactored.create(customerName);
  }

  public String getCustomerName() {
    return _customer.getName();
  }

  public void setCustomer(String customerName) {
    _customer = new Customer(customerName);
  }
}
