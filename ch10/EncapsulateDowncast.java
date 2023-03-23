package ch10;

/* 
 * A method returns an object that needs to be downcasted by its callers
 * 
 * Move the downcast to within the method
 * 
 * - Rather than force client to do the downcasting, you should always provide
 *   them with the most specific type you can
 * 
 * - The downcasting case often appear with methods that return a collection or iterator
 * 
 * - Altering a method to return a subclass alters the signature of the method but does
 *   not break existing code because the compiler knows it can substitue a subclass for
 *   the superclass
 */
class EncapsulateDowncast {
  Object lastReading() {
    return readings.lastElement();
  }

  public void client() {
    Reading lastReading = (Reading) theSite.readings().lastElement();
  }
}

class Site {}

class EncapsulateDowncastRefactored {
  Reading lastReading() {
    return (Reading) readings.lastElement();
  }

  public void client() {
    Reading lastReading = theSite.getLastReading();
  }
}

class SiteRefactored {
  public Reading getLastReading() {
    return (Reading) readings.lastElement();
  }
}
