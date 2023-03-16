package ch8;


/* 
 * You have a literal number with a particular meaning
 * 
 * Create a constant, name it after the meaning, and replace the number with it
 * 
 * - Before you do this refactoring, you should always look for an alternative.
 *   Look at how the magic number is used. Often you can find a better way to use it.
 */
class ReplaceMagicNumberWithSymbolicConstant {
  double potentialEnergy(double mass, double height) {
    return mass * 9.81 * height;
  }  
}

class ReplaceMagicNumberWithSymbolicConstantRefactored {
  static final double GRAVITATIONAL_CONSTANT = 9.81;
  double potentialEnergy(double mass, double height) {
    return mass * GRAVITATIONAL_CONSTANT * height;
  }  
}
