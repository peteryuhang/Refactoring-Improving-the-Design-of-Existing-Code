package ch8;

/* 
 * There is a public field
 * 
 * Make it private and provide accessors
 * 
 * - Encapsulation is data hidding, can allow changed code is in one place rather than
 *   scattered all over the program
 */
class EncapsulateField {
  public String _name;
}

class EncapsulateFieldRefactored {
  private String _name;

  public String getName() {
    return _name;
  }

  public void setName(String name) {
    _name = name;
  }
}
