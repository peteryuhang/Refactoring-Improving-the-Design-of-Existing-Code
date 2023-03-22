# refactoring
Note and code sample for reading Refactoring - Improving the design of existing code

The code might not be executed, the main purpose is to interpret the theory of refactoring

### [Principles in Refactoring](./ch2/Principles%20in%20Refactoring.md)

### [Bad Smells in Code](./ch3/Bad%20Smells%20in%20Code.md)

### [Building Tests](./ch4/Building%20Tests.md)

### [Toward a Catalog of Refactorings](./ch5/Toward%20a%20Catalog%20of%20Refactorings.md)

### Composing Methods

- [Extract Method](./ch6/ExtractMethod.java)
- [Inline Method](./ch6/InlineMethod.java)
- [Inline Temp](./ch6/InlineTemp.java)
- [Replace Temp with Query](./ch6/ReplaceTempWithQuery.java)
- [Introducing Explaining Variable](./ch6/IntroduceExplainingVariable.java)
- [Split Temporary Variable](./ch6/SplitTemporaryVariable.java)
- [Remove Assignments to Parameters](./ch6/RemoveAssignmentsToParameters.java)
- [Replace Method with Method objects](./ch6/ReplaceMethodWithMethodObject.java)
- [Substitute Algorithm](./ch6/SubstituteAlgorithm.java)

### Moving Features Between Objects

- [Move Method](./ch7/MoveMethod.java)
- [Move Field](./ch7/MoveField.java)
- [Extract Class](./ch7/ExtractClass.java)
- [Inline Class](./ch7/InlineClass.java)
- [Hide Delegate](./ch7/HideDelegate.java)
- [Remove Middle Man](./ch7/RemoveMiddleMan.java)
- [Introduce Foreign Method](./ch7/IntroduceForeignMethod.java)
- [Introduce Local Extension](./ch7/IntroduceLocalExtension.java)

### Organizing Data

- [Self Encapsulate Field](./ch8/SelfEncapsulateField.java)
- [Replace Data Value with Object](./ch8/ReplaceDataValueWithObject.java)
- [Change Value to Reference](./ch8/ChangeValueToReference.java)
- [Change Reference to Value](./ch8/ChangeReferenceToValue.java)
- [Replace Array with Object](./ch8/ReplaceArrayWithObject.java)
- [Duplicate Observed Data](./ch8/DuplicateObservedData.java)
- [Change Unidirectional Association to Bidirectional](./ch8/ChangeUnidirectionalAssociationToBidirectional.java)
- [Change Bidirectional Association to Unidirectional](./ch8/ChangeBidirectionalAssociationToUnidirectional.java)
- [Replace Magic Number with Symbolic Constant](./ch8/ReplaceMagicNumberWithSymbolicConstant.java)
- [Encapsulate Field](./ch8/EncapsulateField.java)
- [Encapsulate Collection](./ch8/EncapsulateCollection.java)
- [Replace Record with Data Class](./ch8/ReplaceRecordWithDataClass.java)
- [Replace Type Code with Class](./ch8/ReplaceTypeCodeWithClass.java)
- [Replace Type Code with subclass](./ch8/ReplaceTypeCodeWIthSubclasses.java)
- [Replace Type Code with State/Strategy](./ch8/ReplaceTypeCodeWithStateOrStrategy.java)
- [Replace Subclass with Fields](./ch8/ReplaceSubclassWithFields.java)

### Simplifying Conditional Expressions

- [Decompose Conditional](./ch9/DecomposeConditional.java)
- [Consolidate Conditional Expression](./ch9/ConsolidateConditionalExpression.java)
- [Consolidate Duplicate Conditional Fragments](./ch9/ConsolidateDuplicateConditionalFragments.java)
- [Remove Control Flag](./ch9/RemoveControlFlag.java)
- [Replace Nested Conditional with Guard Clauses](./ch9/ReplaceNestedConditionalWithGuardClauses.java)
- [Replace Conditional with Polymorphism](./ch9/ReplaceConditionalWithPolymorphism.java)
- [Introduce Null Object](./ch9/IntroduceNullObject.java)
- [Introduce Assertion](./ch9/IntroduceAssertion.java)

### Making Method Calls Simpler

- [Rename Method](./ch10/RenameMethod.java)
- [Add Parameter](./ch10/AddParameter.java)
- [Remove Parameter](./ch10/RemoveParameter.java)
- [Separate Query from Modifier](./ch10/SeparateQueryFromModifier.java)
- [ParameterizeMethod](./ch10/ParameterizeMethod.java)
- [ReplaceParameterWithExplicitMethods](./ch10/ReplaceParameterWithExplicitMethods.java)
- [Preserve Whole Object](./ch10/PreserveWholeObject.java)
- [Replace Parameter with Method](./ch10/ReplaceParameterWithMethod.java)