package ch10;

/* 
 * You want to do more than simple construction when you create an object
 * 
 * Replace the constructor with a factory method
 * 
 * - The most obvious motivation for this refactoring comes with replacing
 *   a type code with subclassing
 */
class Employee {
  static final int ENGINEER = 0;
  static final int SALESMAN = 1;
  static final int MANAGER = 2;

  public int getType() {
    return _type;
  }

  public Employee(int type) {
    _type = type;
  }
}

class EmployeeRefactored {
  private int _type;
  static final int ENGINEER = 0;
  static final int SALESMAN = 1;
  static final int MANAGER = 2;

  public int getType() {
    return _type;
  }

  private EmployeeRefactored(int type) {
    _type = type;
  }

  public static EmployeeRefactored create(int type) {
    return new EmployeeRefactored(type);
  }
}

// ========== Creating Subclasses with a String ==========
class Employee2 {
  private int _type;
  static final int ENGINEER = 0;
  static final int SALESMAN = 1;
  static final int MANAGER = 2;

  public int getType() {
    return _type;
  }

  private Employee(int type) {
    _type = type;
  }

  // when adding new subclass, still need to change the switch logic
  // it is easy to forget and miss
  static EmployeeRefactored create(int type) {
    switch (type) {
      case ENGINEER:
        return new Engineer();
      case SALESMAN:
        return new Salesman();
      case MANAGER:
        return new Manager();
      default:
        throw new IllegalArgumentException("Incorrect type code value");
    }
  }
}

class Employee2Refactored {
  private int _type;
  static final int ENGINEER = 0;
  static final int SALESMAN = 1;
  static final int MANAGER = 2;

  public int getType() {
    return _type;
  }

  private Employee(int type) {
    _type = type;
  }

  // The approach lack compile time checking: a spelling mistake leads to a runtime error
  // It is trade-off between flexibility and type safety
  static EmployeeRefactored create(String name) {
    try {
      return (Employee2Refactored) Class.forName(name).newInstance();
    } catch (Exception e) {
      throw new IllegalArgumentException("Unable to instantiate " + name);
    }
  }
}