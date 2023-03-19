package ch10;

/* 
 * The name of method doesn't reveal its purpose
 * 
 * Change the name of the method
 */
class Person {
  public String getTelephoneNumber() {
    return ("(" + _officeAreaCode + ") " + _officeNumber);
  }
}

class PersonRefactored {
  // @Deprecated  // Mark it as Deprecated if it is part of the interface and cannot remove it
  // public String getTelephoneNumber() {
  //   return ("(" + _officeAreaCode + ") " + _officeNumber);
  // }

  public String getOfficeTelephoneNumber() {
    return ("(" + _officeAreaCode + ") " + _officeNumber);
  }
}
