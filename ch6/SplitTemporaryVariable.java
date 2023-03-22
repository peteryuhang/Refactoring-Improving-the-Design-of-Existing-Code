package ch6;

/* 
 * You have a temporary variable assigned to more than once,
 * but is not a loop variable nor a collecting temporary variable
 * 
 * - Make a separate temporary variable for each assignment
 * - Any variable with more than one responsibility should be replaced with
 *   a temp for each responsibility
 */
public class SplitTemporaryVariable {
  double getDistanceTravelled(int time) {
    double result;
    double acc = _primaryForce / _mass;
    int primaryTime = Math.min(time, _delay);
    result = 0.5 * acc * primaryTime * primaryTime;
    int secondaryTime = time - _delay;
    if (secondaryTime > 0) {
      double primaryVel = acc * _delay;
      acc = (_primaryForce + _secondaryForce) / _mass;
      result += primaryVel * secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
    }

    return result;
  }

  double getDistanceTravelledRefactored(int time) {
    double result;
    final double primaryAcc = _primaryForce / _mass;
    int primaryTime = Math.min(time, _delay);
    result = 0.5 * primaryAcc * primaryTime * primaryTime;
    int secondaryTime = time - _delay;
    if (secondaryTime > 0) {
      double primaryVel = primaryAcc * _delay;
      final double secondaryAcc = (_primaryForce + _secondaryForce) / _mass;
      result += primaryVel * secondaryTime + 0.5 * secondaryAcc * secondaryTime * secondaryTime;
    }

    return result;
  }

  double getDistanceTravelledRefactoredMore(int time) {
    double result = 0.5 * getPrimaryAcc() * getPrimaryTime(time) * getPrimaryTime(time);
    if (getSecondaryTime() > 0) {
      result += getPrimaryVel() * getSecondaryTime(time)
          + 0.5 * getSecondaryAcc() * getSecondaryTime(time) * getSecondaryTime(time);
    }

    return result;
  }

  double getPrimaryTime(int time) {
    return Math.min(time, _delay);
  }

  double getPrimaryAcc() {
    return _primaryForce / _mass;
  }

  double getPrimaryVel() {
    return getPrimaryAcc() * _delay;
  }

  double getSecondaryTime(int time) {
    return time - _delay;
  }

  double getSecondaryAcc() {
    return (_primaryForce + _secondaryForce) / _mass;
  }
}
