package ch9;


/* 
 * A method has conditional behavior that does not make clear the normal path of execution
 * 
 * Use guard clauses for all the special cases
 */
class ReplaceNestedConditionalWithGuardClauses {
  public double getPayAmount() {
    double result;
    if (_isDead) result = deadAmount();
    else {
      if (_isSeparated) result = separatedAmount();
      else {
        if (_isRetired) result = retiredAmount();
        else result = normalPayAmount();
      }
    }
    return result;
  }
}

class ReplaceNestedConditionalWithGuardClausesReversing {
  public double getAdjustedCapital() {
    double result = 0.0;
    if (_capital > 0.0) {
      if (_intRate > 0.0 && _duration > 0.0) {
        result = (_income / _duration) * ADJ_FACTOR;
      }
    }
    return result;
  }
}

class ReplaceNestedConditionalWithGuardClausesRefactored {
  public double getPayAmount() {
    if (_isDead) return deadAmount();
    if (_isSeparated) return separatedAmount();
    if (_isRetired) return retiredAmount();
    return normalPayAmount();;
  }
}

class ReplaceNestedConditionalWithGuardClausesReversingRefactored {
  public double getAdjustedCapital() {
    if (_capital <= 0.0) return 0.0;
    if (_intRate <= 0.0 || _duration <= 0.0) return 0.0;
    return (_income / _duration) * ADJ_FACTOR;
  }
}