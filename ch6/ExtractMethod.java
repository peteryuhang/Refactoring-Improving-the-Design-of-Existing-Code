package ch6;

import java.util.Enumeration;

/*
 * You have a code fragment that can be grouped together
 * 
 * Turn the fragment into a method whose name explains the purpose of the method
 * 
 * - New method name is important, name it by what it does, not by how it does it.
 *   If you can't come up with a more meaningful name, don't extract the code
 * 
 * - One method better return zero or one variable, if one method need to return multiple variable,
 *   best option usually is to pick different code to extract
 */
public class ExtractMethod {
  void printOwing() {
    Enumeration<E> e = _orders.elements();
    double outstanding = 0.0;

    // print banner
    System.out.println("***************************");
    System.out.println("***** Customer Owes *******");
    System.out.println("***************************");

    // calculate outstanding
    while (e.hasMoreElements()) {
      Order each = (Order) e.nextElement();
      outstanding += each.getAmount();
    }

    // print details
    System.out.println("name:" + _name);
    System.out.println("amount" + outstanding);
  }

  void printOwingRefactored() {
    // No Local Variables
    printBanner();
    // Reassigning a Local Variable - variable not been used after the code is extracted then just return
    //                                variable been used afterward, need to return
    double outstanding = getOutstanding();
    // Using Local Variables
    printDetails(outstanding);
  }

  void printBanner() {
    // print banner
    System.out.println("***************************");
    System.out.println("***** Customer Owes *******");
    System.out.println("***************************");
  }

  void printDetails(double outstanding) {
    // print details
    System.out.println("name:" + _name);
    System.out.println("amount" + outstanding);
  }

  double getOutstanding() {
    Enumeration<E> e = _orders.elements();
    double result = 0.0;

    // Calculate outstanding
    while (e.hasMoreElements()) {
      Order each = (Order) e.nextElement();
      result += each.getAmount();
    }

    return result;
  }
}
