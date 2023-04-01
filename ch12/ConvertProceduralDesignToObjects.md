## Convert Procedural Design to Objects

- **Problem**: You have code written in a procedural style
- **Action**: Turn the data records into objects, break up the bahvaior, and move the behavior to the objects

- **Steps for refactoring**:
  - Take each record type and turn it into a dumb data object with accessor
  - Take all the procedural code and put it into a single class
  - Use ExtractMethod, MoveClass to break down long procedure method and remove to appropriate dumb data class
  - Continue until removed all the behavior away from the original class, and the delete the purely procedural class

- **Example** in ch1:
  - [Before refactoring](../ch1/VideoStoreStatement.java)
  - [After refactoring](../ch1/VideoStoreStatementV9.java)