package ch10;

/* 
 * A field should be set at creation time and never altered
 * 
 * Remove any setting method for that field
 * 
 * - If you don't want the field to change once the object is created, 
 *   then don't provide a setting method (and make the field final)
 */
class Account1 {
  private String _id;

  Account(String id) {
    setId(id);
  }

  public void setId(String id) {
    _id = id;
  }
}

class Account2 {
  private String _id;

  Account(String id) {
    setId(id);
  }

  public void setId(String id) {
    _id = "ZZ" + id;
  }
}

class InterestAccount extends Account1 {
  private double _interestRate;

  InterestAccount(String id, double rate) {
    setId(id);
    _interestRate = rate;
  }
}

class Account1Refactored {
  private final String _id;

  Account(String id) {
    _id = id;
  }
}

class Account2Refactored {
  private final String _id;

  Account(String id) {
    initializeId(id);
  }

  protected void initializeId(String id) {
    _id = "ZZ" + id;
  }
}

class InterestAccountRefactored extends Account1Refactored {
  private double _interestRate;

  InterestAccount(String id, double rate) {
    // super(id);  // best solution if it is possible
    initializeId(id); // if call supercalss not possible, well-named method is the best thing to use
    _interestRate = rate;
  }
}
