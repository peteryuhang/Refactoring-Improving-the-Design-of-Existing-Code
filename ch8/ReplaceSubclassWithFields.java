package ch8;


/* 
 * You have subclasses that vary only in methods that return constant data
 * 
 * Change the methods to superclass fields and eliminate the subclass
 * 
 * - Although constant methods are useful, a subclass that consists only of 
 *   constant methods is not doing enough to be worth existing.
 */
abstract class Person {
  abstract boolean isMale();
  abstract char getCode();
}

class Male extends Person {
  boolean isMale() {
    return true;
  }

  char getCode() {
    return 'M';
  }
}

class Female extends Person {
  boolean isMale() {
    return false;
  }

  char getCode() {
    return 'F';
  }
}

class PersonRefactored {
  private final boolean _isMale;
  private final char _code;

  static Person createMale() {
    return new Person(true, 'M');
  }

  static Person createFemale() {
    return new Person(false, 'F');
  }

  protected Person(boolean isMale, char code) {
    _isMale = isMale;
    _code = code;
  }

  public boolean getIsMale() {
    return _isMale;
  }

  public void setIsMale(boolean arg) {
    _isMale = arg;
  }

  public char getCode() {
    return _code;
  }

  public void setIsMale(char arg) {
    _code = arg;
  }
}
