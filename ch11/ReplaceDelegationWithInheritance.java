package ch11;

/* 
 * You are using delegation and are often writing many simple
 * delegations for the entire interface
 * 
 * Make the delegating class a subclass of the delegate
 * 
 * - If you aren't using all the methods of the class to which you are delegating,
 * you shouldn't use this refactoring, because a subclass should always follow the
 * interface of the superclass
 * 
 * - If the delegate is shared by more than one object and is mutable, you shouldn't
 * use this refactoring, because you'll no longer share the data. Data sharing is a
 * responsibility that cannot be transferred back to inheritance. When the object is
 * immutable, data sharing is not a problem, because you can just copy and nobody can
 * tell
 * 
 * - If the delegating methods are tiresome, the alternative refactoring are
 * RemoveMiddleMan, ExtractSuperclass, or ExtractInterface
 */
class Employee {
  private Person _person = new Person();

  public String getName() {
    return _person.getName();
  }

  public void setName(String arg) {
    _person.setName(arg);
  }

  public String toString() {
    return "Emp: " + _person.getLastName();
  }
}

class Person {
  private String _name;

  public String getName() {
    return _name;
  }

  public void setName(String arg) {
    _name = arg;
  }

  public String getLastName() {
    return _name.substring(_name.lastIndexOf(' ') + 1);
  }
}

class EmployeeRefactored extends Person {
  public String toString() {
    return "Emp: " + getLastName();
  }
}
