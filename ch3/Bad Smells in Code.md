## Duplicated Code
- If you see the same code structure in more than one place, you can be sure that you program <br>
  will be better if you find a way unify them
- **Related Refactoring**:
  - When you have the same expression in two methods of the same class: [Extract Method](../ch6/ExtractMethod.java)
  - When you have the same expression in two sibling subclass: [Extract Method](../ch6/ExtractMethod.java) + [Pull Up Method](../ch11/PullUpMethod.java) or can consider [Form Template Method](../ch11/FormTemplateMethod.java) and [Substitute Algorithm](../ch6/SubstituteAlgorithm.java)
  - If you have duplicated code in two unrelated classes: [Extract Class](../ch7/ExtractClass.java)

## Long Method
- Smaller method is good naming
- When we need to comment code, better consider to make these code into a new method with naming <br>
  based on the comment
- **Related Refactoring**:
  - First can consider about [Extract Method](../ch6/ExtractMethod.java)
  - If you have the method with lots of parameters and temporary variables, can consider
    - [Replace Temp with Query](../ch6/ReplaceTempWithQuery.java)
    - [Introduce Parameter Object](../ch10/IntroduceParameterObject.java)
    - [Preserve Whole Object](../ch10/PreserveWholeObject.java)
    - [Replace Method with Method Object](../ch6/ReplaceMethodWithMethodObject.java)
  - If you have complex conditional expression in method:
    - [Decompose Conditional](../ch9/DecomposeConditional.java)

## Large Class
- Class is trying to do too much, it often shows up as too many instance variables
- **Related Refactoring**:
  - If class does not use all of its instance variables all of the time, can consider:
    - [Extract Class](../ch7/ExtractClass.java)
    - [Extract Subclass](../ch11/ExtractSubclass.java)
  - [Extract Interface](../ch11/ExtractInterface.java) can give you ideas on how you can further break up the class
  - If the large class is GUI class, then you need to consider [Duplicate Observed Data](../ch8/DuplicateObservedData.java) for keeping data in sync

## Long Parameter List
- Long parameter list are hard to understand, it can be resolved by passing object
- **Related Refactoring**:
  - If you can get the data in one parameter by making a request of an object you already know about, can consider [Replace Parameter with Method](../ch10/ReplaceParameterWithMethod.java)
  - If multiple parameter gleaned from an object, then consider [Preserve Whole Object](../ch10/PreserveWholeObject.java)
  - If you have several data items with no logical object, use [Introduce Parameter Object](../ch10/IntroduceParameterObject.java)

## Divergent Change
- Occurs when one class is commonly changed in different ways for different reasons
- **Related Refactoring**:
  - Each object is changed only as a result of one kind of change, use [Extract Class](../ch7/ExtractClass.java) to separate them

## Shotgun Surgey
- Similar to divergent change but is the opposite. Everytime you make a kind of change, <br>
  you have to make a lot of little changes to a lot of different classes
- **Related Refactoring**:
  - Use [Move Method](../ch7/MoveMethod.java) and [Move Field](../ch7/MoveField.java) to put all the change into a single class. If no current class looks like a good candidate, create one
  - Use [Inline Class](../ch7/InlineClass.java) to bring a whole bunch of bahavior together

## Feature Envy
- A method that seems more interested in a class other than one it actually is in
- Put things together that change together
- **Related Refactoring**:
  - Use [Move Method](../ch7/MoveMethod.java) to put things in the correct place
  - Sometime only part of the method suffers from envy; in that case use [Extract Method](../ch6/ExtractMethod.java) first

## Data Clumps
- Bunches of data that hang around together really ought to be made into their own object
- **Related Refactoring**:
  - The first step is to look for where the clumps appear as fields. Use [Extract Class](../ch7/ExtractClass.java) on the fields to turn the clumps into an object
  - Then turn you attention to method signatures using [Introduce Parameter Object](../ch10/IntroduceParameterObject.java) or [Preserve Whole Object](../ch10/PreserveWholeObject.java) to slim them down

## Primitive Obsession
- One of the valuable things about objects is that they blur or even break the line between <br>
  primitive and larger classes
- **Related Refactoring**:
  - Apply [Replace Data Value with Object](../ch8/ReplaceDataValueWithObject.java) on individual data values
  - If the data value is type code
    - Use [Replace Type Code with Class](../ch8/ReplaceTypeCodeWithClass.java) if the value does not affect behavior
    - Use [Replace Type Code with Subclasses](../ch8/ReplaceTypeCodeWIthSubclasses.java) or [Replace Type Code with State/Strategy](../ch8/ReplaceTypeCodeWithStateOrStrategy.java) if you have conditionals that depend on the type code
  - If you have a group of fields that should go together, use [Extract Class](../ch7/ExtractClass.java)
  - If you see these primitives in parameter lists, try a civilizing dose of [Introduce Parameter Object](../ch10/IntroduceParameterObject.java)
  - If you find youself picking apart an array, use [Replace Array with Object](../ch8/ReplaceArrayWithObject.java)

## Switch Statement
- The problem with switch statement is essentially that of duplication

## Parallel Inheritance Hierarchies
- A special case of shotgun surgery, every time you make a subclass of one class, you also have to<br>
  make a subclass of another
- The general strategy for eliminating the duplication is to make sure that instance of one hierarchy<br>
  refer to instances of the other

## Lazy class
- A class that isn't doing enough to pay for itself should be eliminated

## Speculative Generality
- It can be spotted when the only users of a method or class are test cases

## Temporary Field
- Object with an instance variable is set only in certain circumstances

## Message Chains
- Client is coupled to the structure of the navigation

## Middle Man
- You look at a class's interface and find half the methods are delegating to this other class

## Inappropriate Intimacy
- Sometimes classes become far too intimate and spend too much time delving in each others' private parts

## Alternative Classes with Different Interfaces
- Any methods or classes that do the same thing but have different signatures for what they do

## Incomplete Libaray Class


## Data Class
- Classes that have fields, getting and setting method for the fields, and nothing else <br>
  and are almost certainly being manipulated in far too much detail by other classes

## Refused Bequest
- Subclass sometime just need a few of methods and data of their parents

## Comments
- When you feel the need to write a comment, first try to refactor the code so that any <br>
  comment becomes superfluous
- A good time to use a comment is when you don't know what to do