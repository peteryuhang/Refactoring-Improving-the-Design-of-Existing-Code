package ch9;

/* 
 * You have repeated checks for a null value
 * 
 * Replace the null value with a null object
 * 
 * - The essence of polymorphism is that instead of asking an object what type it is
 *   and then invoking some behavior based on the answer, you just invoke the behavior.
 *   The object, depending on its type, does the right thing.
 */
class client {
  public void clientLogic(Site site) {
    Customer customer = site.getCustomer();
    BillingPlan plan;

    if (customer == null)
      plan = BillingPlan.basic();
    else
      plan = customer.getPlan();

    String customerName;
    if (customer == null)
      plan = "occupant";
    else
      plan = customer.getName();

    int weeksDelinquent;
    if (customer == null)
      weeksDelinquent = 0;
    else
      weeksDelinquent = customer.getHistory().getWeeksDelinquentInLastYear();
  }
}

class Site {
  private Customer _customer;

  public Customer getCustomer() {
    return _customer;
  }
}

class Customer {
  public String getName() {
    // ...
  }

  public BillingPlan getPlan() {
    // ...
  }

  public PaymentHistory getHistory() {
    // ...
  }
}

class PaymentHistory {
  public int getWeeksDelinquentInLastYear() {
    // ...
  }
}

// refactored part
class clientRefactored {
  public void clientLogic(Site site) {
    CustomerRefactored customer = site.getCustomer();

    BillingPlan plan = customer.getPlan();

    String customerName = customer.getName();

    int weeksDelinquent = customer.getHistory().getWeeksDelinquentInLastYear();
  }
}

class SiteRefactored {
  private CustomerRefactored _customer;

  public CustomerRefactored getCustomer() {
    return (_customer == null) ? CustomerRefactored.newNull() : _customer;
  }
}

class CustomerRefactored {

  protected Customer() {}

  public String getName() {
    // ...
  }

  public BillingPlan getPlan() {
    // ...
  }

  public PaymentHistoryRefactored getHistory() {
    // ...
  }

  public boolean isNull() {
    return false;
  }

  static CustomerRefactored newNull() {
    return new NullCustomer();
  }
}

class PaymentHistoryRefactored {
  public int getWeeksDelinquentInLastYear() {
    // ...
  }

  static PaymentHistoryRefactored newNull() {
    return new NullPaymentHistory();
  }
}

class NullCustomer extends CustomerRefactored {
  public String getName() {
    return "occupant";
  }

  public BillingPlan getPlan() {
    return BillingPlan.basic();
  }

  public PaymentHistoryRefactored getHistory() {
    return PaymentHistoryRefactored.newNull();
  }

  public boolean isNull() {
    return true;
  }
}

class NullPaymentHistory extends PaymentHistoryRefactored {
  public int getWeeksDelinquentInLastYear() {
    return 0;
  }
}

// Testing Interface (Make the null object possible when no access to the source
// code)

// interface Null {}

// class NullCustomer extends Customer implements Null ...

// test for nullness with the instanceof operator, after this check, can safely
// use method defined in Null interface
// aCustomer instanceof Null