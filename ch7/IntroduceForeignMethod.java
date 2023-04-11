package ch7;

/* 
 * A server class you are using needs an additional method, but you can't modify the class
 * 
 * Create a method in the client class with an instance of the server class as its first argument
 * 
 * - If you find yourself creating many foreign methods on a server class, or you find many of your
 *   classes need the same foreign method, you should use IntroduceLocalExtension
 * - Foreign methods should not access any of the features of the client class. If it needs a value, send it
 *   in as a parameter
 * - Foreign methods are just work-around. If you can, try to get the methods moved to their proper homes
 */
class IntroduceForeignMethod {
  public Date getDate() {
    Date newStart = new Date(
        previousEnd.getYear(),
        previousEnd.getMonth(),
        previousEnd.getDate() + 1);

    return newStart;
  }

  public Date getDateRefactored() {
    Date newStart = nextDay(previousEnd);

    return newStart;
  }

  // foreign method, should be on Date class
  private static Date nextDay(Date arg) {
    return new Date(
        arg.getYear(),
        arg.getMonth(),
        arg.getDate() + 1);
  }
}
