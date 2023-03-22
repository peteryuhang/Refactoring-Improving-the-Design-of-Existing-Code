package ch9;

/* 
 * You have a complicated conditional (if-then-else) statement
 * 
 * Extract methods from the condition, then part, and else part
 * 
 * - Although the condition is often short, there often is a big gap between the
 *   intention of the code and its body
 */
class DecomposeConditional {
  public void client() {
    if (date.before(SUMMER_START) || date.after(SUMMER_END))
      charge = quantity * _winterRate + winterServiceCharge;
    else
      charge = quantity * _summerRate;
  }
}

class DecomposeConditionalRefactored {
  public void client() {
    if (notSummer())
      charge = getWinterCharge(quantity);
    else
      charge = getSummerCharge(quantity);
  }

  private boolean notSummer() {
    return date.before(SUMMER_START) || date.after(SUMMER_END);
  }

  private boolean getWinterCharge(int quantity) {
    return quantity * _winterRate + winterServiceCharge;
  }

  private boolean getSummerCharge(int quantity) {
    return quantity * _summerRate;
  }
}
