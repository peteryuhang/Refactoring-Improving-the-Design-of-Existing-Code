package ch6;

/* 
 * You have a long method that uses local variables in such a way
 * that you cannot apply ExtractMethod
 * 
 * Turn the method into its own object so that all the local variable become
 * fields on that object. You can then decompose that method into other methods
 * on the same object
 */
public class ReplaceMethodWithMethodObject {
  int gamma(int inputVal, int quantity, int yearToDate) {
    int importantValue1 = (inputVal * quantity) + delta();
    int importantValue2 = (inputVal * quantity) + 100;
    if ((yearToDate - importantValue1) > 100)
      importantValue2 -= 20;
    int importantValue3 = importantValue2 * 7;
    // and so on
    return importantValue3 - 2 * importantValue1;
  }

  int gammaRefactored(int inputVal, int quantity, int yearToDate) {
    return new ReplaceMethodWithMethodObjectRefactored(this, inputVal, quantity, yearToDate).compute();
  }
}

class ReplaceMethodWithMethodObjectRefactored {
  private final ReplaceMethodWithMethodObject _account;
  private int inputVal;
  private int quantity;
  private int yearToDate;
  private int importantValue1;
  private int importantValue2;
  private int importantValue3;

  ReplaceMethodWithMethodObjectRefactored(ReplaceMethodWithMethodObject source, int inputValArg, int quantityArg,
      int yearToDateArg) {
    _account = source;
    inputVal = inputValArg;
    quantity = quantityArg;
    yearToDate = yearToDateArg;
  }

  int compute() {
    importantValue1 = (inputVal * quantity) + _account.delta();
    importantValue2 = (inputVal * quantity) + 100;
    importantThing(); // now can do ExtractMethod w/o worry about parameters passing thing
    importantValue3 = importantValue2 * 7;
    // and so on
    return importantValue3 - 2 * importantValue1;
  }

  void importantThing() {
    if ((yearToDate - importantValue1) > 100)
      importantValue2 -= 20;
  }
}
