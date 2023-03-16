package ch8;

/* 
 * You have a type code that affects the behavior of a class, but you cannot using subclass
 * 
 * Replace the type code with a state object
 * 
 * - If you are trying to simplify a single algorithm with ReplaceConditionalWithPolymorphism,
 *   strategy is the better term
 * - If you are going to move state-specific data and you think of the object as changing state,
 *   use the state pattern
 */
class Employee {
  static final int ENGINEER = 0;
  static final int SALESMAN = 1;
  static final int MANAGER = 2;

  private int _type;

  Employee(int type) {
    _type = type;
  }

  public int payAmount() {
    switch (_type) {
      case ENGINEER:
        return _monthlySalary;
      case SALESMAN:
        return _monthlySalary + _commission;
      case MANAGER:
        return _monthlySalary + _bonus;
      default:
        throw new RuntimeException("Incorrect Employee");
    }
  }
}

class EmployeeRefactored {
  private EmployeeType _type;

  Employee(int type) {
    _type = type;
  }

  public int getType() {
    return _type;
  }

  public void setType(int arg) {
    _type = EmployeeType.newType(arg);
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

  static EmployeeType newType(int code) {
    switch (getType()) {
      case ENGINEER:
        return new Engineer();
      case SALESMAN:
        return new Salesman();
      case MANAGER:
        return new Manager();
      default:
        throw new IllegalArgumentException("Incorrect Employee Code");
    }
  }
}

class Engineer extends EmployeeType {
  public int getTypeCode() {
    return EmployeeRefactored.ENGINEER;
  }
}

class Salesman extends EmployeeType {
  public int getTypeCode() {
    return EmployeeRefactored.SALESMAN;
  }
}

class Manager extends EmployeeType {
  public int getTypeCode() {
    return EmployeeRefactored.MANAGER;
  }
}
