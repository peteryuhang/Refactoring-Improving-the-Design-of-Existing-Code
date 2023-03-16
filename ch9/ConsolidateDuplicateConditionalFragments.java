package ch9;

/* 
 * The same fragment of code is in all branches of a conditional expression
 * 
 * Move it outside of the expression
 * 
 * - If there is more than a single statement, you should extract that code into a method
 * - The same situation can apply to exceptions. If code is repeated after an exception-causing
 *   statement in the try block and all the catch blocks, can move it to the final block
 */
class ConsolidateDuplicateConditionalFragments {
  public void client() {
    if (isSpecialDeal()) {
      total = price * 0.95;
      send();
    } else {
      total = price * 0.98;
      send();
    }
  }
}

class ConsolidateDuplicateConditionalFragmentsRefactored {
  public void client() {
    if (isSpecialDeal()) {
      total = price * 0.95;
    } else {
      total = price * 0.98;
    }
    send();
  }
}
