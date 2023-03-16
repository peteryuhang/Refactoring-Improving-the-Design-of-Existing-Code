package ch7;


/* 
 * A field is, or will be, used by another class more than the class on 
 * which it is defined
 * 
 * Create a new field in the target class, and change all its users
 * 
 * 
 */
class Account {
  private AccountType _type;
  private double _interestRate;

  double interestForAmount_days(double amount, int days) {
    return _interestRate * amount * days / 365;
  }
}

class AccountRefactored {
  private AccountType _type;

  double interestForAmount_days(double amount, int days) {
    return _type.getInterestRate() * amount * days / 365;
  }
}

// assuming lots of features use _interestRate field
// Start using SelfEncapsulation
class AccountRefactoredV2 {
  private AccountType _type;
  private double _interestRate;

  private void setInterestRate(double arg) {
    _type.setInterestRate(arg);
  }

  private double getInterestRate() {
    return _type.getInterestRate();
  }

  double interestForAmount_days(double amount, int days) {
    return getInterestRate() * amount * days / 365;
  }
}

class AccountType {
  private double _interestRate;

  void setInterestRate(double arg) {
    _interestRate = arg;
  }

  double getInterestRate() {
    return _interestRate;
  }
}
