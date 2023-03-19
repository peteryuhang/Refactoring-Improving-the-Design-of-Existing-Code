package ch10;

/* 
 * You have a method that returns a value but also changes the state of an object
 * 
 * Create two methods, one for the query and one for the modification
 * 
 * - A good rule to follow is to say that any method that returns a value should not
 *   have observable side effects, which means any sequence of queries will always return
 *   the same results for each query
 * - For multithreaded system, this refactoring still valuable, but you need to create third
 *   method which wrap query and modifier together to make them synchronized. Lower-level methods
 *   then are available for other uses
 */
class SeparateQueryFromModifier {
  public String foundMiscreant(String[] people) {
    for (int i = 0; i < people.length; i++) {
      if (people[i].equals("Don")) {
        sendAlert();
        return "Don";
      }
      if (people[i].equals("John")) {
        sendAlert();
        return "John";
      }
    }
  }

  public void checkSecurity(String[] people) {
    String found = foundMiscreant(people);
    someLaterCode(found);
  }
}

class SeparateQueryFromModifierRefactored {
  public String foundPeople(String[] people) {
    for (int i = 0; i < people.length; i++) {
      if (people[i].equals("Don")) {
        return "Don";
      }
      if (people[i].equals("John")) {
        return "John";
      }
    }
    return "";
  }

  public void sendAlert(String[] people) {
    if (!foundPeople(people).equals("")) {
      sendAlert();
    }
  }

  public void checkSecurity(String[] people) {
    sendAlert(people);
    String found = foundPeople(people);
    someLaterCode(found);
  }
}
