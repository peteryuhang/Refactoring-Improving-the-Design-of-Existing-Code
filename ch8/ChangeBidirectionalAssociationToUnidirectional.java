package ch8;

import java.util.Iterator;

import org.junit.Assert;

/* 
 * You have a two-way association but one class no longer needs features from the other
 * 
 * Drop the unneeded end of the association
 * 
 * - The most difficult part of this refactoring is checking whether it is feasible or not.
 *   The issue is whether code relies on the fields being there. Normally we can try to pass
 *   the field through parameter
 */
class Order {
  private Customer _customer;

  public Customer getCustomer() {
    return _customer;
  }

  // modifier of the controlling side
  public void setCustomer(Customer arg) {
    if (_customer != null)
      _customer.friendOrders().remove(this);
    _customer = arg;
    if (_customer != null)
      _customer.friendOrders().add(this);
  }

  public getDiscountedPrice() {
    return getGrossPrice() * (1 - _customer.getDiscount());
  }
}

class Customer {
  private Set _orders = new HashSet();

  // helper function for noncontrolling side
  Set friendOrders() {
    /* should only be used by Order when modifying the association */
    return _orders;
  }

  // the association controlling logic on the order side
  void addOrder(Order arg) {
    arg.setCustomer(this);
  }

  public double getPriceFor(Order order) {
    Assert.isTrue(_orders.contains(order));
    return order.getDiscountedPrice();
  }
}

class OrderRefactored {
  public CustomerRefactored getCustomer() {
    Iterator iter = CustomerRefactored.getInstances().iterator();
    while (iter.hasNext()) {
      CustomerRefactored each = (CustomerRefactored) iter.next();
      if (each.containsOrder(this))
        return each;
    }
    return null;
  }

  public getDiscountedPrice(CustomerRefactored customer) {
    return getGrossPrice() * (1 - customer.getDiscount());
  }
}

class CustomerRefactored {
  private Set _orders = new HashSet();

  // helper function for noncontrolling side
  Set friendOrders() {
    /* should only be used by Order when modifying the association */
    return _orders;
  }

  // the association controlling logic on the order side
  void addOrder(OrderRefactored arg) {
    _orders.add(arg);
  }

  public double getPriceFor(OrderRefactored order) {
    Assert.isTrue(_orders.contains(order));
    return order.getDiscountedPrice(this);
  }
}
