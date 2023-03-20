package ch10;

/* 
 * Several methods do similar things but with different values contained in the method body
 * 
 * Create one method that uses a parameter for the different values
 */
class Employee {
  public void tenPercentRaise() {
    salary *= 1.1;
  }

  public void fivePercentRaise() {
    salary *= 1.05;
  }

  protected Dollars baseCharge() {
    double result = Math.min(lastUsage(), 100) * 0.03;
    if (lastUsage() > 100) {
      result += (Math.min(lastUsage(), 200) - 100) * 0.05;
    }
    if (lastUsage() > 200) {
      result += (lastUsage() - 200) * 0.07;
    }
    return new Dollars(result);
  }
}

class EmployeeRefactored {
  public void raise(double factor) {
    salary *= (1 + factor);
  }

  // repetitive on the basis of a few values that can be passed in as parameters
  protected Dollars baseCharge() {
    double result = usageInRange(0, 100) * 0.03;
    result += usageInRange(100, 200) * 0.05;
    result += usageInRange(200, Integer.MAX_VALUE) * 0.07;
    return new Dollars(result);
  }

  protected int usageInRange(int start, int end) {
    if (lastUsage() > start)
      return Math.min(lastUsage(), end) - start;

    return 0;
  }
}
