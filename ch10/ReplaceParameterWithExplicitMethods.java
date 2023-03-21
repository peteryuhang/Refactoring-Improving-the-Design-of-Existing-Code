package ch10;

/* 
 * You have a method that runs different code depending on the values of an enumerated parameter
 * 
 * Create a separate method for each value of the parameter
 * 
 * - Reverse of ParameterizeMethod
 * - Shouldn't use this refactoring when the parameter values are likely to change a lot.
 *   Consider give a field to that parameter, or ReplaceConditionalWithPolymorphism refactoring
 */
class Employee {
  static final int ENGINEER = 0;
  static final int SALESMAN = 1;
  static final int MANAGER = 2;

  public static Employee create(int type) {
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

class EmployeeRefactored {
  static Employee createEngineer() {
    return new Engineer();
  }

  static Employee createSalesman() {
    return new Salesman();
  }

  static Employee createManager() {
    return new Manager();
  }
}
