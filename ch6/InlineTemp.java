package ch6;


/* 
 * You have a temp that is assigned to once with a simple expression,
 * and the temp is getting in the way of other refactorings
 * 
 * - Most of the time Inline Temp is used as part of ReplaceTempWithQuery
 */
public class InlineTemp {
  boolean example() {
    double basePrice = anOrder.basePrice();
    return (basePrice > 1000);
  }

  boolean exampleRefactored() {
    return (anOrder.basePrice() > 1000);
  }
}
