package ch11;

import java.util.Vector;

/* 
 * A subclass uses only part of a superclass interface or does not want to inherit data
 * 
 * Create a field for the superclass, adjust the method to delegate to the superclass,
 * and remove the subclassing
 * 
 * - In this case you have an interface that's not a true reflection of what the class does
 * - By using delegation instead, you make it cleaer that you are making only partial use
 * of the delegated class
 */
class MyStack extends Vector {
  public void push(Object element) {
    insertElementAt(element, 0);
  }

  public Object pop() {
    Object result = firstElement();
    removeElementAt(0);
    return result;
  }
}

// assuming client only do push, pop, size, isEmpty for MyStack
class MyStackRefactored {
  private Vector _vector = new Vector();

  public void push(Object element) {
    _vector.insertElementAt(element, 0);
  }

  public Object pop() {
    Object result = _vector.firstElement();
    _vector.removeElementAt(0);
    return result;
  }

  public int size() {
    return _vector.size();
  }

  public int isEmpty() {
    return _vector.isEmpty();
  }
}
