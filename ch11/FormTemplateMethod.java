package ch11;

import java.util.Vector;

/* 
 * You have 2 methods in subclasses that perform similar steps in the same order,
 * yet the steps are different
 * 
 * Get the step into methods with the same signature, so the original method become the same.
 * Then you can pull them up.
 * 
 * - Move the same part into the superclass and allow polymorphism to play its role in ensuring
 * the different part. This kind of method is called a template method
 */
class Customer {
  public String statement() {
    Enumeration rentals = _rentals.elements();
    String result = "Rental Record for " + getName() + "\n";
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();

      // show figures for this rental
      result += "\t" + each.getMovie().getTitle() + "\t" +
          String.valueOf(each.getCharge()) + "\n";
    }

    // add footer lines
    result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
    result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
        " frequent renter points";
    return result;
  }

  public String htmlStatement() {
    Enumeration rentals = _rentals.elements();
    String result = "<H1>Rental for <EM> " + getName() + "</EM></H1><P>\n";
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();

      // show figures for this rental
      result += "\t" + each.getMovie().getTitle() + "\t" +
          String.valueOf(each.getCharge()) + "<BR>\n";
    }

    // add footer lines
    result += "<P>You owed <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
    result += "On this rental, you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) +
        "</EM> frequent renter points<P>";
    return result;
  }

  private double getTotalCharge() {
    double result = 0;
    Enumeration rentals = _rentals.elements();
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      result += each.getCharge();
    }
    return result;
  }

  private int getTotalFrequentRenterPoints() {
    int result = 0;
    Enumeration rentals = _rentals.elements();
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      result += each.getFrequentRenterPoints();
    }
    return result;
  }
}

class CustomerRefactored {
  public double getTotalCharge() {
    double result = 0;
    Enumeration rentals = _rentals.elements();
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      result += each.getCharge();
    }
    return result;
  }

  public int getTotalFrequentRenterPoints() {
    int result = 0;
    Enumeration rentals = _rentals.elements();
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      result += each.getFrequentRenterPoints();
    }
    return result;
  }

  public Vector getRentals() {
    return Collections.unmodifiableSet(_rentals);
  }
}

abstract class Statement {
  public String value(CustomerRefactored customer) {
    Enumeration rentals = customer.getRentals();
    String result = headString(customer);
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();

      // show figures for this rental
      result += rentalString(each);
    }

    // add footer lines
    result += footerString(customer);
    return result;
  }

  abstract String headString(CustomerRefactored customer);
  abstract String rentalString(Rental rental);
  abstract String footerString(CustomerRefactored customer);
}

class TextStatement extends Statement {
  public String headString(CustomerRefactored customer) {
    return "Rental Record for " + getName() + "\n";
  }

  public String rentalString(Rental rental) {
    return "\t" + rental.getMovie().getTitle() + "\t" +
      String.valueOf(rental.getCharge()) + "\n";
  }

  public String footerString(CustomerRefactored customer) {
    String result = "Amount owed is " + String.valueOf(customer.getTotalCharge()) + "\n";
    result += "You earned " + String.valueOf(customer.getTotalFrequentRenterPoints()) +
        " frequent renter points";
    return result;
  }
}

class HtmlStatement extends Statement {
  public String headString(Rental rental) {
    return "\t" + each.getMovie().getTitle() + "\t" +
      String.valueOf(each.getCharge()) + "<BR>\n";
  }

  public String rentalString(Rental rental) {
    return "\t" + rental.getMovie().getTitle() + "\t" +
      String.valueOf(rental.getCharge()) + "<BR>\n";
  }

  public String footerString(CustomerRefactored customer) {
    String result = "<P>You owed <EM>" + String.valueOf(customer.getTotalCharge()) + "</EM><P>\n";
    result += "On this rental, you earned <EM>" + String.valueOf(customer.getTotalFrequentRenterPoints()) +
        "</EM> frequent renter points<P>";
    return result;
  }
}