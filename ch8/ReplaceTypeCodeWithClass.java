package ch8;

/* 
 * A class has a numeric type code that does not affect its behavior
 * 
 * Replace the number with a new class
 * 
 * 
 * - Any method that takes the type code as an argument expects a number, and there is nothing
 *   to force a symbolic name to be used. This can reduce readability and be a source of bugs
 * - Consider this refactoring only if the type code is pure data, which does not
 *   cause different behavior inside a switch statement
 */
class Person {
  public static final int O = 0;
  public static final int A = 1;
  public static final int B = 2;
  public static final int AB = 3;

  private int _bloodGroup;

  Person(int bloodGroup) {
    _bloodGroup = bloodGroup;
  }

  public void setBloodGroup(int arg) {
    _bloodGroup = arg;
  }

  public int getBloodGroup() {
    return _bloodGroup;
  }
}

class PersonRefactored {
  private BloodGroup _bloodGroup;

  PersonRefactored(BloodGroup arg) {
    _bloodGroup = arg;
  }

  public void setBloodGroup(BloodGroup arg) {
    _bloodGroup = arg;
  }

  public BloodGroup getBloodGroup() {
    return _bloodGroup;
  }
}

class BloodGroup {
  public static final BloodGroup O = new BloodGroup(0);
  public static final BloodGroup A = new BloodGroup(1);
  public static final BloodGroup B = new BloodGroup(2);
  public static final BloodGroup AB = new BloodGroup(3);

  private static final BloodGroup[] _groups = { O, A, B, AB };
  private final int _code;

  public BloodGroup(int arg) {
    _code = arg;
  }

  public int getCode() {
    return _code;
  }

  public static BloodGroup code(int arg) {
    return _groups[arg];
  }
}
