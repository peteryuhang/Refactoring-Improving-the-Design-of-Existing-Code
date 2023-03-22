package ch8;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;

/* 
 * A method returns a collection
 * 
 * Make it return a read-only view and provide add/remove methods
 * 
 * - The getter should not return the collection object itself, because that allows clients
 *   to manipulate the contents of the collection w/o the owning class's knowing what is going on
 * - There should not be a setter for collection: rather there should be operations to add and
 *   remove elements. Or you can change the name of setter to initialize or replace
 */
class Course {
  public Course(String name, boolean isAdvanced) {
    // ...
  }

  public boolean isAdvanced() {
    // ...
  }
}

class Person {
  private Set _courses = new HashSet();

  public Set getCourses() {
    return _courses;
  }

  public void setCourses(Set arg) {
    _courses = arg;
  }
}

class Client {
  public static void client() {
    Person kent = new Person();
    Set s = new HashSet();
    s.add(new Course("Smalltalk Programming", false));
    s.add(new Course("Appreciating Single Malts", true));
    kent.setCourses(s);
    Assert.equals(2, kent.getCourses().size());
    Course refact = new Course("Refactoring", true);
    kent.getCourses().add(refact);
    kent.getCourses().add(new Course("Brutal Sarcasm", false));
    Assert.equals(4, kent.getCourses().size());
    kent.getCourses().remove(refact);
    Assert.equals(3, kent.getCourses().size());
  }

  public static int getAdvancedCourse(Person p) {
    Iterator<E> iter = p.getCourses().iterator();
    int count = 0;
    while (iter.hasNext()) {
      Course each = (Course) iter.next();
      if (each.isAdvanced())
        count++;
    }
    return count;
  }
}

class CourseRefactored {
  public Course(String name, boolean isAdvanced) {
    // ...
  }

  public boolean isAdvanced() {
    // ...
  }
}

class PersonRefactored {
  private Set _courses = new HashSet();

  public Set getCourses() {
    // return (Vector) _courses.clone(); for java 1.1
    return Collections.unmodifiableSet(_courses);
  }

  public void addCourse(CourseRefactored course) {
    _courses.add(course);
  }

  public void removeCourse(CourseRefactored course) {
    _courses.remove(course);
  }

  public void initializeCourses(Set arg) {
    Assert.assertEquals(_courses.size(), 0);
    _courses.addAll(arg);
  }

  public int numberOfCourses() {
    return _courses.size();
  }

  public int numberOfAdvancedCOurses() {
    Iterator<E> iter = getCourses().iterator();
    int count = 0;
    while (iter.hasNext()) {
      CourseRefactored each = (CourseRefactored) iter.next();
      if (each.isAdvanced())
        count++;
    }
    return count;
  }
}

class ClientRefactored {
  public static void client() {
    PersonRefactored kent = new Person();
    kent.addCourse(new Course("Smalltalk Programming", false));
    kent.addCourse(new Course("Appreciating Single Malts", true));
    Assert.equals(2, kent.numberOfCourses());
    CourseRefactored refact = new Course("Refactoring", true);
    kent.addCourse(refact);
    kent.addCourse(new Course("Brutal Sarcasm", false));
    Assert.equals(4, kent.numberOfCourses());
    kent.removeCourse(refact);
    Assert.equals(3, kent.numberOfCourses());
  }

  // public static int getAdvancedCourse(PersonRefactored p) {
  // Iterator<E> iter = p.getCourses().iterator();
  // int count = 0;
  // while (iter.hasNext()) {
  // CourseRefactored each = (CourseRefactored) iter.next();
  // if (each.isAdvanced()) count++;
  // }
  // return count;
  // }
}
