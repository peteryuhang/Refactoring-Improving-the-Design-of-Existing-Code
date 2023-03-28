package ch11;

/* 
 * Several clients use the same subset of a class's interface, or
 * two classes have part of their interfaces in common
 * 
 * Extract the subset into an interface
 * 
 * - Interface are good to use whenever a class has distinct roles in different situations
 */

class Client {
  double charge(Employee emp, int days) {
    int base = emp.getRate() * days;
    if (emp.hasSpecialSkill()) {
      return base * 1.05;
    }
    return base;
  }
}

class Employee {
  public int getRate() {
    // ...
  }

  public int hasSpecialSkill() {
    // ...
  }

  public int otherFunc() {
    // ...
  }
}

class ClientRefactored {
  // a modest gain in documentability
  double charge(Billable emp, int days) {
    int base = emp.getRate() * days;
    if (emp.hasSpecialSkill()) {
      return base * 1.05;
    }
    return base;
  }
}

class EmployeeRefactored implements Billable {
  public int getRate() {
    // ...
  }

  public boolean hasSpecialSkill() {
    // ...
  }

  public void otherFunc() {
    // ...
  }
}

interface Billable {
  public int getRate();

  public boolean hasSpecialSkill();
}