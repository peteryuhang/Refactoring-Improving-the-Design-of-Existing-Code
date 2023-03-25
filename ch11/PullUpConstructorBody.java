package ch11;

/* 
 * You have constructors on subclass with mostly identical bodies
 * 
 * Create a superclass constructor; call this from the subclass methods
 * 
 * - Similar as PullUpMethod, but can't use it here because you can't inherit constructors
 * 
 * - If refactoring becomes complex, you might want to consider ReplaceConstructorWithFactoryMethod instead
 */
class Employee {
  protected String _name;
  protected String _id;

  protected boolean isPriviliged() {
    // ...
  }

  protected void assignCar() {
    // ...
  }
}

class Manager extends Employee {
  private int _grade;

  public Manager(String name, String id, int grade) {
    _name = name;
    _id = id;
    _grade = grade;
    if (isPriviliged()) // every subclass does this
      assignCar();
  }

  public boolean isPriviliged() {
    return _grade > 4;
  }
}

class EmployeeRefactored {
  protected String _name;
  protected String _id;

  // declare it as protected to signal subclass need to use it
  protected EmployeeRefactored(String name, String id) {
    _name = name;
    _id = id;
  }

  protected boolean isPriviliged() {
    return _grade > 4;
  }

  protected void assignCar() {
    // ...
  }

  protected void initialize() {
    if (isPriviliged())
      assignCar();
  }
}

class Manager extends Employee {
  private int _grade;

  public Manager(String name, String id, int grade) {
    super(name, id);
    _grade = grade;
    initialize();
  }
}
