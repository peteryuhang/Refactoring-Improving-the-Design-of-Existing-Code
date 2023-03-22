package ch8;

import java.util.Observer;

import javafx.beans.Observable;

/* 
 * You have domain data available only in a GUI control, and domain methods need access
 * 
 * Copy the data to a domain object. Set up an observer to synchronize the two pieces of data
 * 
 * - Well-layered system separates code that handles the user interface from code that handles
 *   the business logic
 * - For the behaviors(methods), much of this is about decomposing and moving methods. But for the data,
 *   however, you cannot just move the data, you have to duplicate it and provide the synchronization mechanism
 * - This refatoring use observer pattern (an object, named the subject, maintains a list of its dependents, called observers, 
 *   and notifies them automatically of any state changes, usually by calling one of their methods)
 */
class InteravalWindow extends Frame {
  java.awt.TextField _startField;
  java.awt.TextField _endField;
  java.awt.TextField _lengthField;

  void StartField_FocusLost(java.awt.event.FocusEvent event) {
    if (isNotInteger(_startField.getText()))
      _startField.setText("0");
    calculateLength();
  }

  void EndField_FocusLost(java.awt.event.FocusEvent event) {
    if (isNotInteger(_endField.getText()))
      _endField.setText("0");
    calculateLength();
  }

  void LengthField_FocusLost(java.awt.event.FocusEvent event) {
    if (isNotInteger(_lengthField.getText()))
      _lengthField.setText("0");
    calculateEnd();
  }

  void calculateLength() {
    try {
      int start = Integer.parseInt(_startField.getText());
      int end = Integer.parseInt(getEndField());
      int length = end - start;
      _lengthField.setText(String.valueOf(length));
    } catch (NumberFormatException e) {
      throw new RuntimeException("Unexpected Number Format Error");
    }
  }

  void calculateEnd() {
    try {
      int start = Integer.parseInt(_startField.getText());
      int length = Integer.parseInt(_lengthField.getText());
      int end = start + length;
      _endField.setText(String.valueOf(end));
    } catch (NumberFormatException e) {
      throw new RuntimeException("Unexpected Number Format Error");
    }
  }

  class SymFocus extends java.awt.event.FocusAdapter {
    public void focusLost(java.awt.event.FocusEvent event) {
      Object object = event.getSource();
      if (object == _startField)
        StartField_FocusLost(event);
      else if (object == _endField)
        EndField_FocusLost(event);
      else if (object == _lengthField)
        LengthField_FocusLost(event);
    }
  }
}

class InteravalWindowRefactored extends Frame implements Observer {
  java.awt.TextField _startField;
  java.awt.TextField _endField;
  java.awt.TextField _lengthField;
  private Interval _subject;

  public InteravalWindowRefactored() {
    _subject = new Interval();
    _subject.addObserver(this);

    // the call to update ensure that duplicate data in the domain class
    update(_subject, null);
  }

  public void update(Observable observed, Object arg) {
    // need to directly access, call setter will get into infinite recursion
    _startField.setText(_subject.getStart());
    _endField.setText(_subject.getEnd());
    _lengthField.setText(_subject.getLength());
  }

  public java.awt.TextField getStartField() {
    return _subject.getStart();
  }

  public void setStartField(java.awt.TextField startField) {
    _subject.setStart(startField);
  }

  public java.awt.TextField getEndField() {
    return _subject.getEnd();
  }

  public void setEndField(java.awt.TextField endField) {
    _subject.setEnd(endField);
  }

  public java.awt.TextField getLengthField() {
    return _subject.getLength();
  }

  public void setLengthField(java.awt.TextField lengthField) {
    _subject.setLength(lengthField);
  }

  void StartField_FocusLost(java.awt.event.FocusEvent event) {
    // Ensure that user input goes through the setting method
    // access the field directly because later in the refactoring getEndField
    // gets a value from the domain object, not from the field
    setStartField(_startField.getText());
    if (isNotInteger(getStartField()))
      setStartField("0");
    _subject.calculateLength();
  }

  void EndField_FocusLost(java.awt.event.FocusEvent event) {
    setEndField(_endField.getText());
    if (isNotInteger(getEndField()))
      setEndField("0");
    _subject.calculateLength();
  }

  void LengthField_FocusLost(java.awt.event.FocusEvent event) {
    setLengthField(_lengthField.getText());
    if (isNotInteger(getLengthField()))
      setLengthField("0");
    _subject.calculateEnd();
  }

  class SymFocus extends java.awt.event.FocusAdapter {
    public void focusLost(java.awt.event.FocusEvent event) {
      Object object = event.getSource();
      if (object == _startField)
        StartField_FocusLost(event);
      else if (object == _endField)
        EndField_FocusLost(event);
      else if (object == _lengthField)
        LengthField_FocusLost(event);
    }
  }
}

// domain class which use to store data logic of UI
class Interval extends java.util.Observable {
  private String _end = "0";
  private String _start = "0";
  private String _length = "0";

  public String getLength() {
    return _length;
  }

  public void setLength(String length) {
    _length = length;
    setChanged();
    notifyObservers();
  }

  public String getStart() {
    return _start;
  }

  public void setStart(String start) {
    _start = start;
    setChanged();
    notifyObservers();
  }

  public String getEnd() {
    return _end;
  }

  public void setEnd(String end) {
    _end = end;
    setChanged();
    notifyObservers();
  }

  void calculateLength() {
    try {
      int start = Integer.parseInt(getStart());
      int end = Integer.parseInt(getEnd());
      int length = end - start;
      setLength(String.valueOf(length));
    } catch (NumberFormatException e) {
      throw new RuntimeException("Unexpected Number Format Error");
    }
  }

  void calculateEnd() {
    try {
      int start = Integer.parseInt(getStart());
      int length = Integer.parseInt(getLength());
      int end = start + length;
      setEnd(String.valueOf(end));
    } catch (NumberFormatException e) {
      throw new RuntimeException("Unexpected Number Format Error");
    }
  }
}