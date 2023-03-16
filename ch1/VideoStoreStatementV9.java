/* 
 *
 * Change for last version:
 *    Refactor the movie type by using state pattern, do the similar thing to getCharge and getFrequentPoints func
 *    (so when add new behavior, the change is much easier to make)
 */


package ch1;

import java.util.Enumeration;
import java.util.Vector;

abstract class Price {
  abstract int getPriceCode();
  abstract double getCharge(int daysRented);
  abstract int getFrequentRenterPoints(int daysRented);
}

class ChildrensPrice extends Price {
  public int getPriceCode() {
    return Movie.CHIDRENS;
  }

  public double getCharge(int daysRented) {
    double result = 2;
    if (daysRented > 2)
      result += (daysRented - 2) * 1.5;
    return result;
  }

  public int getFrequentRenterPoints(int daysRented) {
    return 1;
  }
}

class NewReleasePrice extends Price {
  public int getPriceCode() {
    return Movie.NEW_RELEASE;
  }

  public double getCharge(int daysRented) {
    return daysRented * 3;
  }

  public int getFrequentRenterPoints(int daysRented) {
    return (daysRented > 1) ? 2 : 1;
  }
}

class RegularPrice extends Price {
  public int getPriceCode() {
    return Movie.REGULAR;
  }

  public double getCharge(int daysRented) {
    double result = 1.5;
    if (daysRented > 3)
      result += (daysRented - 3) * 1.5;
    return result;
  }

  public int getFrequentRenterPoints(int daysRented) {
    return 1;
  }
}

class Movie {
  public static final int CHIDRENS = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;

  private String _title;
  private Price _price;

  public Movie(String title, int priceCode) {
    _title = title;
    setPriceCode(priceCode);
  }

  public int getPriceCode() {
    return _price.getPriceCode();
  }

  public void setPriceCode(int arg) {
    switch (arg) {
      case Movie.REGULAR:
        _price = new RegularPrice();
        break;
      case Movie.NEW_RELEASE:
        _price = new ChildrensPrice();
        break;
      case Movie.CHIDRENS:
        _price = new NewReleasePrice();
        break;
      default:
        throw new IllegalArgumentException("Incorrect Price Code");
    }
  }

  public String getTitle() {
    return _title;
  }

  public double getCharge(int daysRented) {
    return _price.getCharge(daysRented);
  }

  public int getFrequentRenterPoints(int daysRented) {
    return _price.getFrequentRenterPoints(daysRented);
  }
}

class Rental {
  private Movie _movie;
  private int _daysRented;

  public Rental(Movie movie, int daysRented) {
    _movie = movie;
    _daysRented = daysRented;
  }

  public int getDaysRented() {
    return _daysRented;
  }

  public Movie getMovie() {
    return _movie;
  }

  public double getCharge() {
    return _movie.getCharge(_daysRented);
  }

  public int getFrequentRenterPoints() {
    return _movie.getFrequentRenterPoints(_daysRented);
  }
}

class Customer {
  private String _name;
  private Vector _rentals = new Vector();

  public Customer(String name) {
    _name = name;
  }

  public void addRental(Rental arg) {
    _rentals.addElement(arg);
  }

  public String getName() {
    return _name;
  }

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