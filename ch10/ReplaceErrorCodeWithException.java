package ch10;

/* 
 * A method returns a special code to indicate an error
 * 
 * Throw an exception instead
 * 
 * - Exceptions are better because they clearly separate normal processing
 *   from error processing. This makes programs easier to understand
 * 
 * - First thing need to decide whether to use a checked or unchecked exception.
 *   The decision hinges on whether it is the responsibity of the caller to test
 *   the feature, or the feature's routine. If it is caller's responsibility, then
 *   should use unchecked exception because it is a programming error, it is a bug.
 *   Otherwise, should declare the exception in the interface, so the caller can have
 *   right expectation and to take appropriate measures
 */
class Account {
  private int _balance;

  public int withdraw(int amount) {
    if (amount > _balance)
      return -1;
    _balance -= amount;
    return 0;
  }
}

class Client {
  public void client() {
    if (account.withdraw(amount) == -1) {
      handleOverdrawn();
    } else {
      doTheUsualThing();
    }
  }
}

// uncheck exception
class AccountRefactored1 {
  private int _balance;

  public void withdraw(int amount) {
    // if (amount > _balance)
    // throw new IllegalArgumentException();

    // Because it is programming error, can signal more clearly by using assertion
    Assert.isTrue("sufficient funds", amount <= _balance);
    _balance -= amount;
  }
}

class ClientRefactored1 {
  public void client() {
    // caller do the check
    if (!account.canWithdraw(amount)) {
      handleOverdrawn();
    } else {
      account.withdraw(amount);
      doTheUsualThing();
    }
  }
}

// checked exception
class AccountRefactored2 {
  private int _balance;

  public void withdraw(int amount) throws BalanceException {
    if (amount > _balance)
      throw new BalanceException();
    _balance -= amount;
  }
}

class ClientRefactored2 {
  public void client() {
    try {
      account.withdraw(amount);
      doTheUsualThing();
    } catch (BalanceException e) {
      handleOverdrawn();
    }
  }
}

class BalanceException extends Exception {
}
