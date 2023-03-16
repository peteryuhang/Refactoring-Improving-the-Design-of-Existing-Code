package ch8;

/* 
 * You have a reference object that is small, immutable, and awkward to manage
 * 
 * Turn it into a value object
 * 
 * - Value objects are particularly useful for distributed and concurrent systems
 * - Value objects are immutable so can have multiples value objects point to same thing,
 *   otherwsie if you update one object, you also need to update others. That's so much pain and
 *   better to convert to reference objects
 * - Immutable doesn't means info can not be changed. It means that to change the info of object, you
 *   need to replace existed object with a new one instead of modify existed object's info. Relationship
 *   change but object doesn't
 * 
 * - If object can't become immutable, you should abandon this refactoring
 */
class Currency {
  private String _code;

  public String getCode() {
    return _code;
  }

  private Currency (String code) {
    _code = code;
  }
}


class CurrencyRefactored {
  private String _code;

  public String getCode() {
    return _code;
  }

  public Currency (String code) {
    _code = code;
  }

  public boolean equals(Object arg) {
    if (! (arg instanceof CurrencyRefactored)) return false;
    CurrencyRefactored other = (CurrencyRefactored) arg;
    return (_code.equals(other._code));
  }

  public int hashCode() {
    return _code.hashCode();
  }
}
