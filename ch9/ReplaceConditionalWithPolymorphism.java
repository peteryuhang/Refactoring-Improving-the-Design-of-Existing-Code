package ch9;

/* 
 * You have a conditional that chooses different behavior depending on the type of an object
 * 
 * Move each leg of the conditional to an overriding method in a subclass. Make the original method abstract
 */
class Employee {
  private EmployeeType _type;

  Employee(int type) {
    _type = type;
  }

  public int getType() {
    return _type;
  }

  public int payAmount() {
    switch (getType()) {
      case EmployeeType.ENGINEER:
        return _monthlySalary;
      case EmployeeType.SALESMAN:
        return _monthlySalary + _commission;
      case EmployeeType.MANAGER:
        return _monthlySalary + _bonus;
      default:
        throw new RuntimeException("Incorrect Employee");
    }
  }
}

abstract class EmployeeType {
  static final int ENGINEER = 0;
  static final int SALESMAN = 1;
  static final int MANAGER = 2;

  abstract int getTypeCode();
}

class EmployeeRefactored {
  private EmployeeTypeRefactored _type;

  EmployeeRefactored(int type) {
    _type = type;
  }

  public int getType() {
    return _type;
  }

  public int payAmount() {
    return _type.payAmount(this);
  }
}

abstract class EmployeeTypeRefactored {
  static final int ENGINEER = 0;
  static final int SALESMAN = 1;
  static final int MANAGER = 2;

  abstract int getTypeCode();

  abstract int payAmount(EmployeeRefactored emp);
}

class Engineer extends EmployeeTypeRefactored {
  public int getTypeCode() {
    return EmployeeTypeRefactored.ENGINEER;
  }

  public int payAmount(EmployeeRefactored emp) {
    return emp.getMonthlySalary();
  }
}

class Salesman extends EmployeeTypeRefactored {
  public int getTypeCode() {
    return EmployeeType.SALESMAN;
  }

  public int payAmount(EmployeeRefactored emp) {
    return emp.getMonthlySalary() + emp.getCommission();
  }
}

class Manager extends EmployeeTypeRefactored {
  public int getTypeCode() {
    return EmployeeTypeRefactored.MANAGER;
  }

  public int payAmount(EmployeeRefactored emp) {
    return emp.getMonthlySalary() + emp.getBonus();
  }
}
