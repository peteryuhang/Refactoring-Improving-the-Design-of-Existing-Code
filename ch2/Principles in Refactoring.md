## Defining Refactoring

**Refactoring(noun)**: a change made to the internal structure of software to make<br>
it easier to understand and cheaper to modify w/o changing its observable behavior

**Refactor(verb)**: to restructure software by applying a series of refactoring w/o changing
its observable behavior

## Why should you refactor
- Improves the design of software
  - The harder it is to see the design in the code, the harder it is to preserve it, and the more rapidly it decays
  - Reducing the amount of code make a big difference in modification of the code
  - By eliminating the duplicates, ensure that the code says everything once and only once, which is essence of good design

- Refactoring makes software easier to understand
  - Make a point of trying to put everything should remember into the code so don't have to remember it
  - Refactoring can help to understand unfamiliar code

- Refactoring helps you find bugs

- Refactoring helps you program faster

## When should you refactor
- The rule of three
  - The first time just do it
  - The second time wince at the duplication, but just duplicate
  - The third time do sth similar, start refactor

- Refactor when you add function
- Refactor when you need to fix a bug
- Refactor when you do a code review
  >> We want programs that are easy to read, that have all logic specified in one and only <br>
     one place, that do not allow changes to endanger existing behavior, and that allow conditional <br>
     logic to be expressed as simply as possible    -- Kent Beck

## Problems with Refactoring
- Databases (database is difficult to change)
  - With nonobject databases a way to deal with this problem is to place a separate layer <br>
    of software between your object model and you databases model
  - With object databases, should be more cautious about moving fields, need to use accessor to <br>
    give the illusion that the data has moved, even when it hasn't. Only the accessors need to change, <br>
    reducing the risk for problems with bugs
  
- Changing Interfaces
  - If a refactoring changes a published interface, you have to retain both the old interface and the new one, <br>
    at least until your users have had a chance to react to the change
  - Don't publish interfaces prematurely. Modify your code ownership policies to smooth refactoring

- Design changes that are difficult to refactor
  - First consider about the refactoring, if it is difficult then consider to put more effort on design

## Refactoring and Design

- With refactoring the emphasis changes. You still do upfront design, but now you don't try to find the solution. <br>
  Instead all you want is a reasonable solution. Software is much more malleable.
- Refactoring can lead to simpler design without sacrificing flexibility. During design, you can ask that <br>
  "How difficult is it going to be to refactor a simple solution into the flexible solution?" most of the time, <br>
  the answer is "pretty easy"
- Even if know exactly what is going on in your system, measure performance, don't speculate

## Refactoring and performance

- The secret to fast software, in all but hard real-time contexts, is to write tunable software first and then to <br>
  tune it for sufficient speed
- Changes that improve performance usually make the program harder to work with

  

