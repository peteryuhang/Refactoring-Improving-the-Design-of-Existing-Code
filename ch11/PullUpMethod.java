package ch11;

/* 
 * You have methods with identical results on subclasses
 * 
 * Move them to the superclass
 */
class Customer {
  protected Date lastBillDate;

  public void addBill(Date d, double amount) {
  }
}

class RegularCustomer extends Customer {
  public void createBill(Date date) {
    double chargeAmount = chargeFor(lastBillDate, date);
    addBill(date, chargeAmount);
  }

  public double chargeFor(Date start, Date end) {
    // charging logic for regular customer
  }
}

class PreferredCustomer extends Customer {
  public void createBill(Date date) {
    double chargeAmount = chargeFor(lastBillDate, date);
    addBill(date, chargeAmount);
  }

  public double chargeFor(Date start, Date end) {
    // charging logic for preferred customer
  }
}

abstract class CustomerRefactored {
  protected Date lastBillDate;

  public void addBill(Date d, double amount) {
  }

  public void createBill(Date date) {
    double chargeAmount = chargeFor(lastBillDate, date);
    addBill(date, chargeAmount);
  }

  abstract double chargeFor(Date start, Date end);
}

class RegularCustomerRefactored extends CustomerRefactored {
  public double chargeFor(Date start, Date end) {
    // charging logic for regular customer
  }
}

class PreferredCustomerRefactored extends CustomerRefactored {
  public double chargeFor(Date start, Date end) {
    // charging logic for preferred customer
  }
}
