package ch6;

/* 
 * The code assigns to a parameter
 * Need to use as temporary variable instead
 * 
 * - For the pass in object field, assigning to the parameter means to change
 *   to ref to different object instead of modify the object itself
 */
public class RemoveAssignmentsToParameters {
  int discount(int inputVal, int quantity, int yearToDate) {
    if (inputVal > 50) inputVal -= 2;
    if (quantity > 100) inputVal -= 1;
    if (yearToDate > 10000) inputVal -= 4;
    return inputVal;
  }

  int discountRefactored(final int inputVal, final int quantity, final int yearToDate) {
    int result = inputVal;
    if (inputVal > 50) result -= 2;
    if (quantity > 100) result -= 1;
    if (yearToDate > 10000) result -= 4;
    return result;
  }
}
