## Duplicated Code
- If you see the same code structure in more than one place, you can be sure that you program <br>
  will be better if you find a way unify them

## Long Method
- Smaller method is good naming
- When we need to comment code, better consider to make these code into a new method with naming <br>
  based on the comment

## Large Class
- Class is trying to do too much, it often shows up as too many instance variables

## Long Parameter List
- Long parameter list are hard to understand, it can be resolved by passing object

## Divergent Change
- Occurs when one class is commonly changed in different ways for different reasons

## Shotgun Surgey
- Similar to divergent change but is the opposite. Everytime you make a kind of change, <br>
  you have to make a lot of little changes to a lot of different classes

## Feature Envy
- A method that seems more interested in a class other than one it actually is in
- Put things together that change together

## Data Clumps
- Bunches of data that hang around together really ought to be made into their own object

## Primitive Obsession
- One of the valuable things about objects is that they blur or even break the line between <br>
  primitive and larger classes

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