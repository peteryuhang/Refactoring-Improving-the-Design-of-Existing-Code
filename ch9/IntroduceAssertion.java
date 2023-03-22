package ch9;

/* 
 * A section of code assumes something about the state of program
 * 
 * Make the assumption explicit with an assertion
 * 
 * - Assertion act as communication and debuggin aids
 * - Always ask whether the code still works if an assertion fails. If the code
 *   does work, remove the assertion
 */
class Employee {
  private static final double NULL_EXPENSE = -1.0;
  private double _expenseLimit = NULL_EXPENSE;
  private Project _primaryProject;

  public double getExpenseLimit() {
    return (_expenseLimit != NULL_EXPENSE) ? _expenseLimit : _primaryProject.getMemberExpenseLimit();
  }

  public boolean withinLimit(double expenseAmount) {
    return (expenseAmount <= getExpenseLimit());
  }
}

class EmployeeRefactored {
  private static final double NULL_EXPENSE = -1.0;
  private double _expenseLimit = NULL_EXPENSE;
  private Project _primaryProject;

  public double getExpenseLimit() {
    Assert.isTrue(_expenseLimit != NULL_EXPENSE || _primaryProject != null);
    return (_expenseLimit != NULL_EXPENSE) ? _expenseLimit : _primaryProject.getMemberExpenseLimit();
  }

  public boolean withinLimit(double expenseAmount) {
    return (expenseAmount <= getExpenseLimit());
  }
}
