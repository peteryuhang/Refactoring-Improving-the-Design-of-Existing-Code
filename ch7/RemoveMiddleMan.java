package ch7;


/* 
 * A class is doing too much simple delegation
 * 
 * Get the client to call the delegate directly
 * 
 * - Reverse verison of HideDelegate
 * - If client use multiple features of the delegate, client need to call multiple delegate methods,
 *   when the number is large and delegate frequently onboard new feature, the middle man is not necessary
 */
class Person {
  Department _department;

  public Person getManager() {
    return _department.getManager();
  }
}

class Department {
  private String _chargeCode;
  private Person _manager;

  public Department (Person manager) {
    _manager = manager;
  }

  public Person getManager() {
    return _manager;
  }
}

class PersonRefactored {
  Department _department;
  
  public Department getDepartment() {
    return _department;
  }
}
