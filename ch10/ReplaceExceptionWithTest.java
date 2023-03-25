package ch10;

import java.util.Stack;

/* 
 * You are throwing an exception on a condition the caller could have checked first
 * 
 * Change the caller to make the test first
 */
class ResourcePool {
  public Stack _available;
  public Stack _allocated;

  public Resource getResource() {
    Resource result;
    try {
      result = (Resource) _available.pop();
      _allocated.push(result);
    } catch (EmptyStackException e) {
      result = new Resource();
      _allocated.push(result);
      return result;
    }
  }
}

class ResourcePoolRefactored {
  public Stack _available;
  public Stack _allocated;

  public Resource getResource() {
    Resource result;
    if (_available.isEmpty())
      result = new Resource();
    else
      result = (Resource) _available.pop();
    _allocated.push(result);

    return result;
  }
}
