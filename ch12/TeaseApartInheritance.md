
## Tease Apart Inheritance

- **Problem**: You have an inheritance hierarchy that is doing 2 jobs at onece
- **Action**: Create 2 hierarchies and use delegation to invoke one from the other

- **Motivation**:
  - Tangled inheritance is a problem because it leads to code duplication, the bane
  of the programmer's existence
  - If every class at a certain level in the hierarchy has subclasses that begin with
  the same adjective, you probably are doing 2 jobs with one hierarchy

- **Steps for the refactoring**:
  - Identify the jobs being done by the hierarchy, and draw 2, 3, .. dimensional grid
  - Decide which job is more important (generally speaking, leave alone the job that have most code associated with it)
  - Use ExtractClass to create a common superclass for the subsidiary job and add an instance variable to hold this object
  - Create subclasses of the extracted class
  - Use MoveMethod and MoveField to move related methods and fields from original class to created subclass
  - Remove original subclass if there is no code left
  - Look at the new hierarchy for possible further refactorings such as PullUpMethod or PullUpField
