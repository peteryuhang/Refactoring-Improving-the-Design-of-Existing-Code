package ch10;

/* 
 * You are getting several values from an object and passing these values as parameters in a method call
 * 
 * Send the whole object instead
 * 
 * - Passing in the required object causes a dependency between the required object and the called object.
 *   If this is going to mess up your dependency structure, don't use this refactoring
 * - When you are considering this refactoring, please consider MoveMethod as an alternative
 */
class Room {
  public boolean withinPlan(HeatingPlan plan) {
    int low = daysTempRange().getLow();
    int high = daysTempRange().getHigh();
    return plan.withinRange(low, high);
  }
}

class HeatingPlan {
  private TempRange _range;

  public boolean withinRange(int low, int high) {
    return (low >= _range.getLow() && high <= _range.getHigh());
  }
}

class TempRange {
  int getLow() {
    // ...
  }

  int getHigh() {
    // ...
  }
}

class RoomRefactored {
  public boolean withinPlan(HeatingPlanRefactored plan) {
    return plan.withinRange(daysTempRange());
  }
}

class HeatingPlanRefactored {
  private TempRangeRefactored _range;

  public boolean withinRange(TempRangeRefactored roomRange) {
    return _range.includes(roomRange);
  }
}

class TempRangeRefactored {
  int getLow() {
    // ...
  }

  int getHigh() {
    // ...
  }

  int includes(TempRangeRefactored arg) {
    return arg.getLow() >= this.getLow() && arg.getHigh() <= this.getHigh();
  }
}
