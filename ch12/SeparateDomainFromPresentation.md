## Separate Domain from Presentation

- **Problem**: You have GUI class that contain domain logic
- **Solution**: Separate the domain logic into separate domain class

- **Steps for refactoring**:
  1. Create a domain class for each window
  2. Examine the data on the window
    - If it been used only by the window, leave it there
    - If it been used only by the domain logic, use MoveMethod to move it to corresponding domain class
    - If it been used by both window and domain logic, use DuplicateObservedData so it can been synced on both place
  3. After we separate the whole thing, the domain class might not be well factored, can do further refactorings for this

- Most of time, we can move all the **SQL calls** to the domain class
- As you do this refactoring you have to pay attention to where your risk is, and address your biggest risk firt before refactoring