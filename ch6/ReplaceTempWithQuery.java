package ch6;


/* 
 * You are using a temp variable to hold the result of an expression
 * 
 * Extract the expression into a method. Replace all references to the temp
 * with the new method. The new method can then be used in other methods.
 * 
 * - Temp tend to encourage longer methods
 * - Often is vital step before ExtractMethod. Local variabls make it difficult
 *   to extract, so replace as many variables as you can with querxies
 * - Initally mark the method as private. You may find more use for it later, but
 *   you can easily relax the protection later
 * - Can test the temp only assigned once by declaring them as final
 * 
 */
public class ReplaceTempWithQuery {
  double getPrice() {
    int basePrice = _quantity * _itemPrice;
    double discountFactor;
    if (basePrice > 1000)
      discountFactor = 0.95;
    else
      discountFactor = 0.98;
    return basePrice * discountFactor;
  }

  double getPriceRefactored() {
    return getBasePrice() * getDiscountPrice();
  }

  int getBasePrice() {
    return _quantity * _itemPrice;
  }

  double getDiscountPrice() {
    if (getBasePrice() > 1000)
      return 0.95;
    return 0.98;
  }
}
