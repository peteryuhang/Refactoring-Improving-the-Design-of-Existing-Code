package ch7;


/* 
 * A class isn't doing very much
 * 
 * Move all its features into another class and delete it
 * 
 * - The reverse of ExtractClass
 */
class Person {
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

class PersonRefactored {
  private String _name;
  private String _areaCode;
  private String _number;

  public String getName() {
    return _name;
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

  public String getTelephoneNumber() {
    return ("(" + _areaCode + ") " + _number);
  }
}

