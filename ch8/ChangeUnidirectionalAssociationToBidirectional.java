package ch8;

import java.util.HashSet;
import java.util.Set;

/* 
 * You have two classes that need to use each other's features, but there is only a one-way link
 * 
 * Add back pointers, and change modifiers to update both sets
 * 
 * - Better just let one class to take charge of the association, it keep all the logic for manipulating
 *   the association in one place, decision process runs as follows:
 * 
 *   1. If both objects are reference objects and the association is one to many, then the object that has
 *      the one reference is the controller
 *   2. If one object is a component of the other, the composite should control the association
 *   3. If both objects are reference objects and the association is many to many, it doesn't matter which
 *      object is the controller
 * 
 * - Basic pattern for modifier: first tell the other object to remove its pointer to you, set your pointer to
 *   the new object, and the tell the new object to add pointer to you
 */
class Order {
  private Customer _customer;

  public Customer getCustomer() {
    return _customer;
  }

  public void setCustomer(Customer arg) {
    _customer = arg;
  }
}

class Customer {
}

class OrderRefactored {
  private CustomerRefactored _customer;

  public CustomerRefactored getCustomer() {
    return _customer;
  }

  // modifier of the controlling side
  public void setCustomer(CustomerRefactored arg) {
    if (_customer != null)
      _customer.friendOrders().remove(this);
    _customer = arg;
    if (_customer != null)
      _customer.friendOrders().add(this);
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
    arg.setCustomer(this);
  }
}

class OrderRefactoredManyToMany {
  private Set _customers = new HashSet();

  public CustomerRefactoredManyToMany getCustomers() {
    return _customers;
  }

  // modifier of the controlling side
  public void addCustomer(CustomerRefactoredManyToMany arg) {
    arg.friendOrders().add(this);
    _customers.add(arg);
  }

  public void removeCustomer(CustomerRefactoredManyToMany arg) {
    arg.friendOrders().remove(this);
    _customers.remove(arg);
  }
}

class CustomerRefactoredManyToMany {
  private Set _orders = new HashSet();

  // helper function for noncontrolling side
  Set friendOrders() {
    /* should only be used by Order when modifying the association */
    return _orders;
  }

  public void addOrder(OrderRefactoredManyToMany arg) {
    arg.addCustomer(this);
  }

  public void removeOrder(OrderRefactoredManyToMany arg) {
    arg.removeCustomer(this);
  }
}
