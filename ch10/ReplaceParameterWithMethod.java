package ch10;

/* 
 * An object invokes a method, then passes the result as a parameter for a method.
 * The receiver can also invoke this method
 * 
 * Remove the parameter and let the receiver invoke the method
 */
class ReplaceParameterWithMethod {
  public double getPrice() {
    int basePrice = _quantity * _itemPrice;
    int discountLevel;
    if (_quantity > 100)
      discountLevel = 2;
    else
      discountLevel = 1;
    double finalPrice = discountedPrice(basePrice, discountLevel);
    return finalPrice;
  }

  private double discountedPrice(int basePrice, int discountLevel) {
    if (discountLevel == 2)
      return basePrice * 0.1;
    else
      return basePrice * 0.05;
  }
}

class ReplaceParameterWithMethodRefactored {
  public double getPrice() {
    return discountedPrice();
  }

  private double discountedPrice() {
    if (getDiscountLevel() == 2)
      return getBasePrice() * 0.1;
    return getBasePrice() * 0.05;
  }

  private int getDiscountLevel() {
    if (_quantity > 100)
      return 2;
    return 1;
  }

  private double getBasePrice() {
    return _quantity * _itemPrice;
  }
}
