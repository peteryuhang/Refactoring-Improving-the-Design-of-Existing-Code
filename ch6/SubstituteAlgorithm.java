package ch6;

import java.util.Arrays;
import java.util.List;

/* 
 * You want to replace an algorithm with one that is clearer
 * 
 * Replace the body of the method with the new algorithm
 */
public class SubstituteAlgorithm {
  String foundPerson(String[] people) {
    for (int i = 0; i < people.length; i++) {
      if (people[i].equals("Don")) {
        return "Don";
      }
      if (people[i].equals("John")) {
        return "John";
      }
      if (people[i].equals("Kent")) {
        return "Kent";
      }
    }
    return "";
  }

  String foundPersonRefactored(String[] people) {
    List candidates = Arrays.asList(new String[] {"Don", "John", "Kent"});
    for (int i = 0; i < people.length; i++) {
      if (candidates.contains(people[i]))
        return people[i];
    }
    return "";
  }
}
