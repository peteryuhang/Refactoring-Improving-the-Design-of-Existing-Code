package ch11;

/*
 * Two subclass have the same field
 * 
 * Move the field to the superclass
 * 
 * - The only way to determine what is going on is to look at the fields and see
 * how they are used by other methods. If they are being used in a similar way,
 * you can generalize them
 */
class Employee {
}

class Salesman {
  private String _name;
}

class Engineer {
  private String _name;
}

class EmployeeRefactored {
  protected String _name;

  public String getName() {
    return _name;
  }

  public String setName(String arg) {
    _name = arg;
  }
}

class SalesmanRefactored {
}

class EngineerRefactored {
}