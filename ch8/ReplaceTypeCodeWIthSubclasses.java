package ch8;

/* 
 * You have an immutable type code that affects the behavior of a class
 * 
 * Replace the type code with subclasses
 * 
 * - The trigger to use this refactoring is the presence of conditional statement.
 *   If there is no conditional statement, ReplaceTypeCodeWithClass is the better and
 *   less critical move
 * 
 * - Cases in which you can't do this (better to use ReplaceTypeCodeWithStateOrStrategy):
 *   1. The value of type code changes after the object is created
 *   2. The class with the type code is already subclassed for another reason
 * 
 * - The advantage of this refactoring is that it moves knowledge of the variant behavior from
 *   the clients of the class to class itself. If I add new variants, all I need to do is add
 *   a subclass w/o any client side or existed code change. So it is particularly valuable when
 *   variants keep changing
 */
class Employee {
  static final int ENGINEER = 0;
  static final int SALESMAN = 1;
  static final int MANAGER = 2;

  private int _type;

  Employee(int type) {
    _type = type;
  }

  public int getType() {
    return _type;
  }
}

class EmployeeRefactored {
  static final int ENGINEER = 0;
  static final int SALESMAN = 1;
  static final int MANAGER = 2;

  public int getType() {
    return _type;
  }

  public EmployeeRefactored() {}

  private EmployeeRefactored(int type) {
    _type = type;
  }

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

class Engineer extends EmployeeRefactored {
  public int getType() {
    return EmployeeRefactored.ENGINEER;
  }
}

class Salesman extends EmployeeRefactored {
  public int getType() {
    return EmployeeRefactored.SALESMAN;
  }
}

class Manager extends EmployeeRefactored {
  public int getType() {
    return EmployeeRefactored.MANAGER;
  }
}
