package ch8;

/* 
 * You are accessing a field directly, but the coupling to the field is become awkward
 * 
 * Create getting and setting methods for the field and use only those to access the field
 * 
 * - Advantage of indirect variable access: allow subclass to override and support more flexibility
 *   in managing the data
 * - Advantage of direct variable access: code is easier to read
 * - Becareful for using setter on the constructor, because setter may have different behavior than you
 *   have when initializing
 */
class IntRange {
  private int _low, _high;

  IntRange(int low, int high) {
    _low = low;
    _high = high;
  }

  boolean includes(int arg) {
    return arg >= _low && arg <= _high;
  }

  boolean grow(int factor) {
    _high = _high * factor;
  }
}

class IntRangeRefactored {
  private int _low, _high;

  public int getLow() {
    return _low;
  }

  public void setLow(int low) {
    _low = low;
  }

  public int getHigh() {
    return _low;
  }

  public void setHigh(int high) {
    _high = high;
  }

  IntRange(int low, int high) {
    _low = low;
    _high = high;
  }

  boolean includes(int arg) {
    return arg >= getLow() && arg <= getHigh();
  }

  boolean grow(int factor) {
    _high = getHigh() * factor;
  }
}

class CappedRange extends IntRangeRefactored {
  private int _cap;

  CappedRange(int low, int high, int cap) {
    super(low, high);
    _cap = cap;
  }

  int getCap() {
    return _cap;
  }

  public int getHigh() {
    return Math.min(super.getHigh(), getCap());
  }
}
