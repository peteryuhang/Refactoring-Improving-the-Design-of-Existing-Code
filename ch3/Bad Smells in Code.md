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
- **Related Refactoring**:
  - Use [Extract Method](../ch6/ExtractMethod.java) to extract the switch statement and then [Move Method](../ch7/MoveMethod.java) to get it into the class where polymorphism is needed
  - Consider to use [Replace Type Code with Subclasses](../ch8/ReplaceTypeCodeWithSubclasses.java) or [Replace Type Code with State/Strategy](../ch8/ReplaceTypeCodeWithStateOrStrategy.java)
  - When you have set up the inheritance structure, you can use [Replace Conditional with Polymorphism](../ch9/ReplaceConditionalWithPolymorphism.java)
  - If you only have a few cases that affect a single method, and you don't expect them to change, then polymorphism is overkill. Can consider use [Replace Parameter with Explicit Methods](../ch10/ReplaceParameterWithExplicitMethods.java)
  - If one of your conditional cases is a null, try [Introduce Null Object](../ch9/IntroduceNullObject.java)

## Parallel Inheritance Hierarchies
- A special case of shotgun surgery, every time you make a subclass of one class, you also have to<br>
  make a subclass of another
- The general strategy for eliminating the duplication is to **make sure that instance of one hierarchy refer to instances of the other**
- **Related Refactoring**:
  - Consider use [Move Method](../ch7/MoveMethod.java) and [Move Field](../ch7/MoveField.java) to make the referring class disappear

## Lazy class
- A class that isn't doing enough to pay for itself should be eliminated
- **Related Refactoring**:
  - For subclasses that aren't doing enough, try to use [Collapse Hierarchy](../ch11/CollapseHierarchy.java)
  - Nearly useless components should be subjected to [Inline Class](../ch7/InlineClass.java)

## Speculative Generality
- It can be spotted when the only users of a method or class are test cases
- **Related Refactoring**:
  - If you have abstract classes that aren't doing much, use [Collapse Hierarchy](../ch11/CollapseHierarchy.java)
  - Unnecessary delegation can be removed with [Inline Class](../ch7/InlineClass.java)
  - Method with unused parameters should be subject to [Remove Parameter](../ch10/RemoveParameter.java)
  - Method named with odd abstract names should be brought down to earth with [Rename Method](../ch10/RenameMethod.java)

## Temporary Field
- Object with an instance variable is set only in certain circumstances
- **Related Refactoring**:
  - Use [Extract Class](../ch7/ExtractClass.java) to create a home for the poor orphan variables.
  - Can consider to eliminate conditional code by using [Introduce Null Object](../ch9/IntroduceNullObject.java)

## Message Chains
- Client is coupled to the structure of the navigation
- **Related Refactoring**:
  - Can consider do [Hide Delegate](../ch7/HideDelegate.java) at various points in the chain
  - [Hide Delegate](../ch7/HideDelegate.java) often turns every intermediate object into a middle man. Better to see what the resulting object is used for. See whether you can use [Extract Method](../ch6/ExtractMethod.java) to take piece of the code that uses it and then [Move Method](../ch7/MoveMethod.java) to push it down the chain

## Middle Man
- You look at a class's interface and find half the methods are delegating to this other class
- **Related Refactoring**:
  - Consider to use [Remove Middle Man](../ch7/RemoveMiddleMan.java) and talk to the object that really knows what's going on
  - If only a few methods aren't doing much, use [Inline Method](../ch6/InlineMethod.java) to inline them into the caller
  - If there is additional behavior, you can use [Replace Delegation with Inheritance](../ch11/ReplaceDelegationWithInheritance.java) to turn the middle man into a subclass of the real object

## Inappropriate Intimacy
- Sometimes classes become far too intimate and spend too much time delving in each others' private parts
- **Related Refactoring**:
  - Use [Move Method](../ch7/MoveMethod.java) and [Move Field](../ch7/MoveField.java) to separate the pieces to reduce the intimacy
  - See whether you can arrange a [Change Bidirectional Association to Unidirectional](../ch8/ChangeBidirectionalAssociationToUnidirectional.java)
  - If the class do have common interests, use [Extract Class](../ch7/ExtractClass.java) to put the commonality in a safe place and make honest classes of them
  - Or use [Hide Delegate](../ch7/HideDelegate.java) to let another act as go-between
  - Inheritance often can lead to overintimacy, can apply [Replace Inheritance with Delegation](../ch11/ReplaceInheritanceWithDelegation.java) for this

## Alternative Classes with Different Interfaces
- Any methods or classes that do the same thing but have different signatures for what they do
- **Related Refactoring**:
  - Use [Rename Method](../ch10/RenameMethod.java) for methods that do the same thing but have different signatures
  - Keep using [Move Method](../ch7/MoveMethod.java) to move behavior to the classes until the protocols are the same
  - Can also consider [Extract Superclass](../ch11/ExtractSuperclass.java) in some situation

## Incomplete Libaray Class
- Builders of library classes are rarely omniscient, and it is impossible to modify a libaray class to do something you'd like it to do
- **Related Refactoring**:
  - Use [Introduce Foreign Method](../ch7/IntroduceForeignMethod.java) if you wanna the libaray class to include couple of methods
  - If there is a whole load of extra behavior, you need [Introduce Local Extension](../ch7/IntroduceLocalExtension.java)

## Data Class
- Classes that have fields, getting and setting method for the fields, and nothing else and are almost certainly being manipulated in far too much detail by other classes
- **Related Refactoring**:
  - If the class has public fields, you should immediately apply [Encapsulate Field](../ch8/EncapsulateField.java) before any notices
  - If you have collection field, apply [Encapsulate Collection](../ch8/EncapsulateCollection.java) if they aren't properly encapsulated
  - Use [Remove Setting Method](../ch10/RemoveSettingMethod.java) for any field that should not be changed
  - Look for where the setter and getter methods are used by other classes. Try [Move Method](../ch7/MoveMethod.java) or [Extract Method](../ch6/ExtractMethod.java) to move the behavior into the data class. Then you can start using [Hide Method](../ch10/HideMethod.java) on the getter and setter

## Refused Bequest
- Subclass sometime just need a few of methods and data of their parents
- No need to do it all the time, unless it causing confusion and problems
- **Related Refactoring**:
  - If the subclass is reusing behavior but does not want to support the interface of the supperclass, can consider [Replace Inheritance with Delegation](../ch11/ReplaceInheritanceWithDelegation.java)

## Comments
- When you feel the need to write a comment, first try to refactor the code so that any comment becomes superfluous
- A good time to use a comment is when you don't know what to do
- A comment is a good place to say why you did something
- **Related Refactoring**:
  - If you need a comment to explain what a block of code does, try [Extract Method](../ch6/ExtractMethod.java)
  - If the method alread extracted but still need a comment to explain what it does, use [Rename Method](../ch10/RenameMethod.java)
  - If you need to state some rules about the required state of the system, use [Introduce Assertion](../ch9/IntroduceAssertion.java)