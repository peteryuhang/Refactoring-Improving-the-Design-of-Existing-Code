package ch7;

/* 
 * A client is calling a delegate class of an object
 * 
 * Create methods on the sever to hide the delegate
 * 
 * - Encapsulation means that objects need to know less about other parts of the system.
 *   Then when things change, fewer objects need to be told about the change - which makes
 *   the change easier to make
 */
class Person {
  Department _department;

  public Department getDepartment() {
    return _department;
  }

  public void setDepartment(Department arg) {
    _department = arg;
  }
}

class Department {
  private String _chargeCode;
  private Person _manager;

  public Department(Person manager) {
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

  public void setDepartment(Department arg) {
    _department = arg;
  }

  public Person getManager() {
    return _department.getManager();
  }
}

class Department {
  private String _chargeCode;
  private Person _manager;

  public Department(Person manager) {
    _manager = manager;
  }

  public Person getManager() {
    return _manager;
  }
}