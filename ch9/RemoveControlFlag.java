package ch9;

/* 
 * You have a variable that is acting as a control flag for a series of boolean expressions
 * 
 * Use a break or return instead
 * 
 * - Even in languages with a break or continue, usually prefer use of an extraction and of a return
 */
class RemoveControlFlagWithBreak {
  public void checkSecurity(String[] people) {
    boolean found = false;
    for (int i = 0; i < people.length; i++) {
      if (!found) {
        if (people[i].equals("Don")) {
          sendAlert();
          found = true;
        }
        if (people[i].equals("John")) {
          sendAlert();
          found = true;
        }
      }
    }
  }
}

class RemoveControlFlagWithReturn {
  public void checkSecurity(String[] people) {
    String found = "";
    for (int i = 0; i < people.length; i++) {
      if (found.equals("")) {
        if (people[i].equals("Don")) {
          sendAlert();
          found = "Don";
        }
        if (people[i].equals("John")) {
          sendAlert();
          found = "John";
        }
      }
    }
    someLaterCode(found);
  }
}

class RemoveControlFlagWithBreakRefactored {
  public void checkSecurity(String[] people) {
    for (int i = 0; i < people.length; i++) {
      if (people[i].equals("Don")) {
        sendAlert();
        break;
      }
      if (people[i].equals("John")) {
        sendAlert();
        break;
      }
    }
  }
}

class RemoveControlFlagWithReturnRefactored {
  public void checkSecurity(String[] people) {
    String found = foundMiscreant(people);
    someLaterCode(found);
  }

  private String foundMiscreant(String[] people) {
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

    return "";
  }
}