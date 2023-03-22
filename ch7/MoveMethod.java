package ch7;

/* 
 * A method is, or will be, using or used by more features of
 * another class than the class on which it is defined
 * 
 * Create a new method with a simpler body in the class it uses most
 * Either turn the old method into a simple delegation, or remove it altogether
 * 
 * 
 * - When need to use a feature of the source class, can do one of 4 things:
 *    1. Move this feature to the target class as well
 *    2. Create or use a reference from the target class to the source
 *    3. Pass the source object as a parameter to the method
 *    4. If the feature is a variable, pass it in as a parameter
 * 
 * - If not sure whether to move a method, then go on to look at other methods.
 *   Moving other methods often makes the decision easier
 */
public class MoveMethod {
  private AccountType _type;
  private int _daysOverdrawn;

  double overdraftCharge() {
    if (_type.isPremium()) {
      double result = 10;
      if (_daysOverdrawn > 7)
        result += (_daysOverdrawn - 7) * 0.85;
      return result;
    } else
      return _daysOverdrawn * 1.75;
  }

  double bankCharge() {
    double result = 4.5;
    if (_daysOverdrawn > 0)
      result += overdraftCharge();
    return result;
  }
}

class AccountType {

}

// do this refactor to resolve multiple accountType with different behavior
class MoveMethodRefactored {
  private AccountTypeRefactored _type;
  private int _daysOverdrawn;

  double bankCharge() {
    double result = 4.5;
    if (_daysOverdrawn > 0)
      result += _type.overdraftCharge(_daysOverdrawn);
    return result;
  }
}

class AccountTypeRefactored {
  double overdraftCharge(int daysOverdrawn) {
    if (isPremium()) {
      double result = 10;
      if (daysOverdrawn > 7)
        result += (daysOverdrawn - 7) * 0.85;
      return result;
    } else
      return daysOverdrawn * 1.75;
  }
}
