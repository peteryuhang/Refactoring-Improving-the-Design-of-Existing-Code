package ch6;

/* 
 * You have a complicated expression
 * 
 * Put the result of the expression or parts of the expression, in a
 * temporary variable with a name that explains the purpose
 * 
 * - When local variables make it difficult to use Extract Method, that's when to use this refactoring tick
 */
public class IntroduceExplainingVariable {
  double price() {
    // price is base price - quantity discount + shipping
    return _quantity * _itemPrice -
        Math.max(0, _quantity - 500) * _itemPrice * 0.05 +
        Math.min(_quantity * _itemPrice * 0.1, 100);
  }

  double priceRefactored() {
    final double basePrice = _quantity * _itemPrice;
    final double quantityDiscount = Math.max(0, _quantity - 500) * _itemPrice * 0.05;
    final double shippingPrice = Math.min(_quantity * _itemPrice * 0.1, 100);
    return basePrice - quantityDiscount + shippingPrice;
  }

  double priceRefactoredWithExtractMethod() {
    return getBasePrice() - getQuantityDiscount() + getShippingPrice();
  }

  private double getBasePrice() {
    return _quantity * _itemPrice;
  }

  private double getQuantityDiscount() {
    return Math.max(0, _quantity - 500) * _itemPrice * 0.05;
  }

  private double getShippingPrice() {
    return Math.min(_quantity * _itemPrice * 0.1, 100);
  }
}
