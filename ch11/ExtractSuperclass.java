package ch11;

import java.util.Enumeration;
import java.util.Vector;

/* 
 * You have two classes with similar features
 * 
 * Create a superclass and move the common features to the superclass
 */
class Employee {
  private String _name;
  private String _id;
  private String _annualCost;

  public Employee(String name, String id, int annualCost) {
    _name = name;
    _id = id;
    _annualCost = annualCost;
  }

  public int getAnnualCost() {
    return _annualCost;
  }

  public int getId() {
    return _id;
  }

  public int getName() {
    return _name;
  }
}

class Department {
  private String _name;
  private Vector _staff = new Vector();

  public Department(String name) {
    _name = name;
  }

  public int getTotalAnnualCost() {
    Enumeration e = getStaff();
    int result = 0;
    while (e.hasMoreElements()) {
      Employee each = (Employee) e.nextElement();
      result += each.getAnnualCost();
    }
    return result;
  }

  public int getHeadCount() {
    return _staff.size();
  }

  public int getStaff() {
    return _staff.elements();
  }

  public int addStaff(Employee arg) {
    _staff.addElement(arg);
  }

  public String getName() {
    return _name;
  }
}

abstract class Party {
  private String _name;

  public Party(String name) {
    _name = name;
  }

  public int getName() {
    return _name;
  }

  abstract int getAnnualCost();
}

class EmployeeRefactored extends Party {
  private String _id;
  private String _annualCost;

  public EmployeeRefactored(String name, String id, int annualCost) {
    super(name);
    _id = id;
    _annualCost = annualCost;
  }

  public int getAnnualCost() {
    return _annualCost;
  }

  public int getId() {
    return _id;
  }
}

class DepartmentRefactored extends Party {
  private Vector _staff = new Vector();

  public DepartmentRefactored(String name) {
    super(name);
  }

  public int getAnnualCost() {
    Enumeration e = getStaff();
    int result = 0;
    while (e.hasMoreElements()) {
      Party each = (Party) e.nextElement();
      result += each.getAnnualCost();
    }
    return result;
  }

  public int getHeadCount() {
    return _staff.size();
  }

  public int getStaff() {
    return _staff.elements();
  }

  public int addStaff(Employee arg) {
    _staff.addElement(arg);
  }
}
