package ch10;

import java.sql.Date;
import java.util.Enumeration;
import java.util.Vector;

/* 
 * You have a group of parameters that naturally go together
 * 
 * Replace them with an object
 * 
 * - Once we have clumped together the parameters, will soon see behavior that we
 *   can move into the new class. Often the bodies of the methods have common manipulations
 *   of the parameter values
 */
class Entry {
  private Date _chargeDate;
  private double _value;

  Entry(double value, Date chargeDate) {
    _value = value;
    _chargeDate = chargeDate;
  }

  public Date getDate() {
    return _chargeDate;
  }

  public double getValue() {
    return _value;
  }
}

class Account {
  private Vector _entries = new Vector();

  public double getFlowBetween(Date start, Date end) {
    double result = 0;
    Enumeration<E> e = _entries.elements();
    while (e.hasMoreElements()) {
      Entry each = (Entry) e.nextElement();
      if (each.getDate().equals(start) || each.getDate().equals(end) ||
          (each.getDate().after(start) && each.getDate().before(end))) {
        result += each.getValue();
      }
    }

    return result;
  }
}

class Client {
  public void client() {
    double result = anAccount.getFlowBetween(start, end);
    // ...
  }
}

class EntryRefactored {
  private Date _chargeDate;
  private double _value;

  Entry(double value, Date chargeDate) {
    _value = value;
    _chargeDate = chargeDate;
  }

  public Date getDate() {
    return _chargeDate;
  }

  public double getValue() {
    return _value;
  }
}

class AccountRefactored {
  private Vector _entries = new Vector();

  public double getFlowBetween(DateRange range) {
    double result = 0;
    Enumeration<E> e = _entries.elements();
    while (e.hasMoreElements()) {
      Entry each = (Entry) e.nextElement();
      if (range.includes(each.getDate())) {
        result += each.getValue();
      }
    }

    return result;
  }
}

class DateRange {
  // making the class immutable mimics the way Java's parameters work
  // so this is the right assumption for this refactoring
  private final Date _start;
  private final Date _end;

  DateRange(Date start, Date end) {
    _start = start;
    _end = end;
  }

  public Date getStartDate() {
    return _start;
  }

  public Date getEndDate() {
    return _end;
  }

  public boolean includes(Date date) {
    return date.equals(_start) || date.equals(_end) || (date.after(_start) && date.before(_end));
  }
}

class ClientRefactored {
  public void client() {
    double result = anAccount.getFlowBetween(new DateRange(start, end));
    // ...
  }
}