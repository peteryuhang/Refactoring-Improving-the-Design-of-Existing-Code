package ch6;

/* 
 * If a method's body is just as clear as its name, then put the method's body of 
 * its callers and remove the method
 * 
 * - Another time to use inline method is when you have a group of methods that seems badly factored.
 *   You can inline them all into one big method and then reextract the methods
 * - Don't inline if subclass override the method, they cannot override a method that isn't there
 */
public class InlineMethod {
  int getRating() {
    return (moreThanFiveLateDeliveries()) ? 2 : 1;
  }

  boolean moreThanFiveLateDeliveries() {
    return _numberOfLateDeliveries > 5;
  }

  int getRatingRefactored() {
    return (_numberOfLateDeliveries > 5) ? 2 : 1;
  }
}
