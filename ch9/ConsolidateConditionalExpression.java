package ch9;

/* 
 * You have a sequence of conditional tests with the same result
 * 
 * Combine them into a single conditional expression and extract it
 * 
 * - Extracting a condition is one of the most useful things you can do to clarify
 *   your code. It replaces a statement of what you are doing with why you are doing it
 * 
 * - If you think the check are really independent and shouldn't be thought of as a single
 *   check, don't do the refactoring
 */
class ConsolidateConditionalExpressionOrs {
  public double client() {
    if (_seniority < 2)
      return 0;
    if (_monthsDisabled > 12)
      return 0;
    if (_isPartTime)
      return 0;
    // ...
  }
}

class ConsolidateConditionalExpressionAnds {
  public double client() {
    if (onVacation())
      if (lenghtOfService() > 10)
        return 1;
    return 0.5;
  }
}

class ConsolidateConditionalExpressionOrsRefactored {
  public double client() {
    if (isNotEligibleForDisability())
      return 0;
    // ...
  }

  private boolean isNotEligibleForDisability() {
    return _seniority < 2 || _monthsDisabled > 12 || _isPartTime;
  }
}

class ConsolidateConditionalExpressionAndsRefactored {
  public double client() {
    return (onVacation() && lenghtOfService() > 10) ? 1 : 0.5;
  }
}
