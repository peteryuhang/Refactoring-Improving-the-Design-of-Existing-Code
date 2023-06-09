package ch7;

import java.sql.Date;

/* 
 * A server class you are using several additional methods, but you can't modify the class
 * 
 * Create a new class that contains these extra methods. Make this extension class a subclass
 * or a wrapper of the original
 * 
 * - A local extension is a separate class, but it is a subtype of the class it is extending
 *   it means it supports all the things the original can do but also adds the extra features.
 * - Most of time can consider about the subclassing instead of wrapper (use delegation) because
 *   subclassing need less work, but if the parent object could be modified, better use wrapper
 */
class MfDateSub extends Date {
  MfDateSub(String dateString) {
    super(dateString);
  }

  // converting constructor: takes an original as an argument
  MfDateSub(Date arg) {
    super(arg.getTime());
  }

  public Date nextDay() {
    return new Date(
        // re-use father's method
        getYear(),
        getMonth(),
        getDate() + 1);
  }
}

/*
 * A particular problem with using wrappers is how to deal with methods that
 * take an original as an argument, such as
 * 
 * public boolean equals(Date arg)
 * 
 * Normally, java user will assume a.equals(b) then b.equals(a), but wrapper
 * only can do it in one direction because original Date can not be modified.
 * 
 * In this situation, need to expose the fact that this class is wrapping class
 * by rename the method
 * 
 * public boolean equalsDate(Date arg)
 */
class MfDateWrap {
  private Date _original;

  MfDateWrap(String dateString) {
    _original = new Date(dateString);
  }

  // converting constructor: takes an original as an argument
  MfDateWrap(Date arg) {
    _original = arg;
  }

  public int getYear() {
    return _original.getYear();
  }

  // ... delegating all methods of original class

  // mfDateWrap.equals(aDate)           -> can be made to work
  // mfDateWrap.equals(anotherWrap)     -> can be made to work
  // aDate.equals(aWrapper)             -> will not work
  // to make its purpose clearly, can rename to equalsDate
  public boolean equals(Object arg) {
    if (this == arg)
      return true;
    if (!(arg instanceof MfDateWrap))
      return false;
    MfDateWrap other = ((MfDateWrap) arg);
    return (_original.equals(other._original));
  }

  public Date nextDay(Date arg) {
    return new Date(
        // re-use delegated methods
        getYear(),
        getMonth(),
        getDate() + 1);
  }
}
