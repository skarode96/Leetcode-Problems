
## Item1 : Consider static factory methods instead of constructors

A class can provide its clients with static factory methods instead of, or inaddition to, public constructors. Providing a static factory method instead of apublic constructor has both advantages and disadvantages

Simple example, which translates boolean primitive value into Boolean object reference

```java
public static Boolean valueOf(boolean b) {
	return b ? Boolean.TRUE : Boolean.FALSE;
}
```

In this example, programmer can avoid using constructor to instantiate the object of the class.

### **Advantages**

1. **One advantage of static factory methods is that, unlike constructors, they have names.**
    - static factory method is easier to use and the resulting code is easier to read
    If the parameters to a constructor do not, in and of themselves, describe the object being returned, a static factory with a well-chosen name is easier to use and the resulting client code easier to read

    Consider a method, 

    ```java
    BigInteger(int, int, Random) // returns a BigInteger that is probable prime

    BigInteger.probablePrime() //better name could have been this with static 
    			   // factory method implmentation which is easier
    			   // to read
    ```

    - In cases where a class seems to requiremultiple constructors with the same signature, replace the constructors with staticfactory methods and carefully chosen names to highlight their differences.

2.  **The second advantage of static factory methods is that, unlike constructors, they are not required to create a new object each time they’re invoked**
    - This allows immutable classes to use preconstructed instances, or to cacheinstances as they’re constructed, and dispense them repeatedly to avoid creatingunnecessary duplicate objects.
    - The Boolean.valueOf(boolean) method illustrates this technique: it never creates an object. This technique is similar to the Flyweight pattern
    - This technique is similar to the flyweight pattern. It can greatly improve performance if equivalent objects are requested often, especially if they are expensive to create
    - The ability of static factory methods to return the same object from repeatedinvocations allows classes to maintain strict control over what instances exist at any time
    - Instance control allows a class to guarantee that it is a singleton or non-instantiable. Also, it allows an immutable value class to make the guarantee that no two equal instances exist: a.equals(b) if and only if a==b. This is the basis of the Flyweight pattern.

    3. **The third advantage of static factory methods is that, unlike constructors, they can return an object of any subtype of their return type**

    - This gives you great flexibility in choosing the class of the returned object.
    - This technique lends itself to interface-based frameworks, where interfaces provide natural return types for static factory methods
    - Prior to Java 8, interfaces couldn’t have static methods. By convention, static factory methods for an interface named Type were put in a non instantiable companion class (Item 4) named Types. For example, the Java Collections Framework has forty-five utility implementations of its interfaces, providing unmodifiable collections, synchronized collections, and the like. Nearly all of these implementations are exported via static factory methods in one non instantiable class(java.util.Collections). The classes of the returned objects are all non public
    - As of Java 8, the restriction that interfaces cannot contain static methods it was eliminated, so there is typically little reason to provide a non instantiable companion class for an interface. Many public static members that would have been at home in such a class should instead be put in the interface itself
    - Note, however, that it may still be necessary to put the bulk of the implementation code behind these static methods in a separate package-private class. This is because Java 8 requires all static members of an interface to be public. Java 9 allows private static methods, but static fields and static member classes are still required to be public

    4. **The fourth advantage of static factories is that the class of the returned object can vary from call to call as a function of the input parameters**

    - The EnumSet class has no public constructors, only static factories.
    - Depending on the size of the underlying enum type: if it has sixty-four or fewer elements, as most enum types do, the static factories return a RegularEnumSet instance, which is backed by a single long; if the enum type has sixty-five or more elements, the factories return a JumboEnumSet instance, backed by a long array.
    - If RegularEnumSet ceased to offer performance advantages for small enum types, it could be eliminated from a future release with no ill effects. Similarly, a future release could add a third or fourth implementation of EnumSet if it proved beneficial for performance. Clients neither know nor care about the class of the object they get back from the factory; they care only that it is some subclass of EnumSet

    5. **A fifth advantage of static factories is that the class of the returned object need not exist when the class containing the method is written**

    - Such flexiblestatic factory methods form the basis of service provider frameworks, like the JavaDatabase Connectivity API (JDBC)
    - There are three essential components in a service provider framework: a service interface, which represents an implementation; a provider registration API, which providers use to register implementations; and a service access API, which clients use to obtain instances of the service. The service access API may allow clients to specify criteria for choosing an implementation. In the absence of such criteria, the API returns an instance of a default implementation or allows the client to cycle through all available implementations. The service access API is the flexible static factory that forms the basis of the service provider framework

### Disadvantages

1. **The main limitation of providing only static factory methods is that classes without public or protected constructors cannot be subclassed.**
- For example, it is impossible to subclass any of the convenience implementation classes in the Collections Framework. Arguably this can be a blessing in disguise because it encourages programmers to use composition instead of inheritance

2. **The second shortcoming of static factory methods is that they are hard for programmers to find**

- They do not stand out in API documentation in the way that constructors do, so it can be difficult to figure out how to instantiate a class that provides static factory methods instead of constructor
- you can reduce this problem by drawing attention to static factories in class or interfacedocumentation and by adhering to common naming conventions

 

```java
• **from—A** type-conversion method that takes a single parameter and returns a corresponding instance of this type, for example:

Date d = Date.from(instant);

• **of—An** aggregation method that takes multiple parameters and returns an instance of this type that incorporates them, for example:

Set<Rank> faceCards = EnumSet.of(JACK, QUEEN, KING);

• **valueOf**—A more verbose alternative to from and of, for example:

BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);
```
