package ch11;

/* 
 * A class has features that are used only in some instances
 * 
 * Create a subclass for that subset of features
 */
class JobItem {
  private int _unitPrice;
  private int _quantity;
  private boolean _isLabor;
  private Employee _employee;

  public JobItem(int unitPrice, int quantity, boolean isLabor, Employee employee) {
    _unitPrice = unitPrice;
    _quantity = quantity;
    _isLabor = isLabor;
    _employee = employee;
  }

  public int getTotalPrice() {
    return getUnitPrice() * _quantity;
  }

  public int getUnitPrice() {
    return (_isLabor) ? _employee.getRate() : _unitPrice;
  }

  public int getQuantity() {
    return _quantity;
  }

  public Employee getEmployee() {
    return _employee;
  }
}

class Employee {
  private int _rate;

  public Employee(int rate) {
    _rate = rate;
  }

  public int getRate() {
    return _rate;
  }
}

abstract class JobItemRefactored {
  private int _quantity;

  public JobItemRefactored(int quantity) {
    _quantity = quantity;
  }

  public int getTotalPrice() {
    return getUnitPrice() * _quantity;
  }

  public int getQuantity() {
    return _quantity;
  }

  abstract public boolean isLabor();

  abstract public int getUnitPrice();
}

class LaborItem extends JobItemRefactored {
  private Employee _employee;

  public LaborItem(int quantity, Employee employee) {
    super(quantity);
    _employee = employee;
  }

  public boolean isLabor() {
    return true;
  }

  public int getUnitPrice() {
    return _employee.getRate();
  }

  public Employee getEmployee() {
    return _employee;
  }
}

class UnitItem extends JobItemRefactored {
  private int _unitPrice;

  public UnitItem(int unitPrice, int quantity) {
    super(quantity);
    _unitPrice = unitPrice;
  }

  public int getUnitPrice() {
    return _unitPrice;
  }

  public boolean isLabor() {
    return false;
  }
}
