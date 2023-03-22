package ch7;

/* 
 * You have one class doing work that should be done by two
 * 
 * Create a new class and move the relevant fields and methods from
 * the old class into the new class
 * 
 * - Most problems related with this refactoring are accessibility of thing related new class
 *   Also need to consider about lock and transaction in certain situations
 */
class Person {
  private String _name;
  private String _officeAreaCode;
  private String _officeNumber;

  public String getName() {
    return _name;
  }

  public String getTelephoneNumber() {
    return ("(" + _officeAreaCode + ") " + _officeNumber);
  }

  public getOfficeAreaCode() {
    return _officeAreaCode;
  }

  public void setOfficeAreaCode(String arg) {
    _officeAreaCode = arg;
  }

  public String getOfficeNumber() {
    return _officeNumber;
  }

  public void setOfficeNumber(String arg) {
    _officeNumber = arg;
  }
}

class PersonRefactored {
  private String _name;
  private TelephoneNumber _officeTelephone = new TelephoneNumber();

  public String getName() {
    return _name;
  }

  public String getTelephoneNumber() {
    return _officeTelephone.getTelephoneNumber();
  }

  public TelephoneNumber getOfficeTelephone() {
    return _officeTelephone;
  }
}

class TelephoneNumber {
  private String _areaCode;
  private String _number;

  public String getTelephoneNumber() {
    return ("(" + _areaCode + ") " + _number);
  }

  public getAreaCode() {
    return _areaCode;
  }

  public void setAreaCode(String arg) {
    _areaCode = arg;
  }

  public String getNumber() {
    return _number;
  }

  public void setNumber(String arg) {
    _number = arg;
  }
}
