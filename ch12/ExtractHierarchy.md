## Extract Hierarchy

- **Problem**: You have a class that is doing too much work, at least in part through many conditional statement
- **Solution**: Create a hierarchy of classes in which each subclass represents a special case

- The strategy here works only if your conditional logic remains static during the life of the object.
  If not, you may have to use ExtractClass before you can begin separating the cases from each other
- For the variation, we want to identify cases in which we can have methods that have the same intention
  but carry it out differently in two separate cases