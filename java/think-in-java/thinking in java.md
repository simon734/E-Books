## Everything is an Object
1. *package access specifier*: classes can access the members of other classes in the same package(library component), but outside of the package those same members appear to be **private**.

2. In Java, dynamic binding is the default behavior and you don't need to add any extra keywords (like **virutal**) in order to get polymorphism.

3. Java has a singly rooted hierarchy:**Object**. Benefits: easier to implement a garbage collector, system-level operations(exception handling).

4. Java uses dynamic memory allocation, exclusively.

5. If you don't write your code to properly handle exceptions, you'll get a compiler-time error message.

## Everything is an Object
1. You manipulate objects with references

2. You must create all the objects

3. There are five different places to store data:
 * Register
 * Stack: object references, primitive variables
 * Heap: Object
 * Constant storage
 * Non-RAM storage

4. **All numeric primitive types are signed**.
 * The size of the **boolean** type is not explicitly specified; it is only defined to be able to take the literal values **true** or **false**.
 * The "wrapper" classes for the primitive data types allow you to make a non-primitive object on the heap to represent that primitive type.
 * Java includes two classes for performing high-precision arithmetic: **BigInteger** and **BigDecimal**.
 * When a primitive data type is a member of a class, it is guaranteed to get a default value if you do not initilize it. This doesn't apply to *local variables* (compiler-time error).

5. Java *autoboxing* will automatically convert from a primitive to a wrapper type or wise versa.

6. The variables in inner scope with the same name as the one in outer scope are not allowed. It leads to confusion.

7. Java eliminates the so-called "forward referencing" problem.

8. **import** tells the compiler to bring in a package, which is a library of classes (All code in Java must be written inside a class).

9. *import java.util.** import a collection of classes.

10. There's a certain library of classes that are automatically brought into every Java file: **java.lang.**

11. main function in HelloDate.java:
```java
public static void main(String[] args) {}
```
`javac HelloDate.java`  
`Java HelloDate`

12. Javadoc commands occur only within /\*\* comments, end with \*/. There are two primary ways to use javadoc:
 * Embed HTML(standalone doc tags):start with an '@' and placed at the beginning of a comment line.(A leading '\*' is ignored.)
 * Inline doc tags:Can appear anywhere within a javadoc comment and also start with an '@' but are surrounded by curly braces.

13. Commands for **private** and package-access members are ignored by javadoc. However, you can use the **-private** flag to include it.


## objects
1. In java, object referencing has a *aliasing* phenomenon.

2. The operators == and != compare object references, the output is actually **true** and **false**. You must use the special method **equals()** that exists for all objects.

3. a **boolean** value is automatically converted to an appropriate text form if it is used where a **String** is expected.

4. Java cannot implement their own overloaded operators.

5. Java has no "sizeof" operator.

## Controlling Execution
1. **foreach** is used with arrays and containers, any object that is **Iterable**.
```java
public class test {
	public static void main(String[] args) {
		Random rand = new Random(47);
		float f[] = new float[10];
		for (int i=0; i < 10; i++) {
			f[i] = rand.nextFloat();
		}
		for (float x : f) {
			System.out.println(x);
		}
    for (char c: "An African Swallow".toCharArray()) {
			System.out.print(c + " ");
		}
	}
}
```
2. The **break** and **continue** keywords when used with a label, they'll interrupt the loops up to where the label exist.
```java
label1:
outer-iteration {
  inner-iteration {
  //...
  continue label1; // (1)
  //...
  break label1; // (2)
  }
}
```
the **continue label1** breaks out of the inner iteration and the outer iteration, all the way back to **label1**. Then it does in fact continue the iteration, but starting at the outer iteration. The **break label1** also breaks all the way out to **label1**, but it does not reenter the iteration. It actually does break out of both iterations.

3. It's important to remember that the only reason to use labels in Java is when you have nested loops and you want to **break** or **continue** through more than one nested level.

4. Calling constructors from constructors:
```java
this(/*arg-list*/);
```
You can call one constructor using **this**, you cannot call two. In addition, the constructor call must be the first thing you do, or you''ll get  a compiler error message. You can't call a constructor from inside any method other than a constructor.

5. Global methods are not permitted in Java.

6. The garbage collector only knows how to release memory allocated with **new**, so it won't know how to release the object's "special" memory. To handle this case, Java provides **finalize()**: *When the garbage collector is ready to release the storage used for your object, it will first call **finalize()**, and only on the next garbage-collection pass will it reclaim the object's memory*.
```java
protected void finalize() {
  super.finalize();
}
```

7. Don't mistake **finalize()** for the *destrctor* in C++(Java has no destructor or similar concept). In C++, *objects always get destoryed*, whereas in Java, objects do not always get garbage collected:
 * **Your objects might not get garbage collected**
 * **Garbage collection is not destruction**
 * **Garbage collection is only about memory**

8. Java doesn't allow you to create local objects, you must always use **new**. There's no "delete" for releasing the object. Java has no destructor.
*Force garbage collection & finalization*:
```java
System.gc();
```

9. Java goes out of its way to guarantee that variables are properly initialized before they are used. In the case of a method's local variables, this guarantee comes in the form of a compile-time error. Each primitives field of a class is guaranteed to get an initial value.

10. When you define an object reference inside a class without initializing it to a new object, that reference is given a special value of **null**.

11. You can give a variable an initial value at the point you define it in the class. Even call a method to provide an value.

12. Java allows you to group other **static** initializations inside a special "**static** clause" (sometimes called a *static block*) in a class:
```java
public class Spoon {
  static int i;
  static {
    i = 47;
  }
}
```
This code is executed only once: the fist time you make an object of that class or the first time you access a **static** member of that class(Even if you never make an object of that class).

13. Java provides a similar syntax, called *instance initialization*, for initializing non-**static** variables for each other.
```java
public class TestClass {
  ObjectA oa;
  {
    la = new ObjectA();
  }
}
```
This syntax is necessary to support the initialization of *anonymous inner classes*. It also allows you to guarantee that certain operations occur regardless of which explicit constructor is called.

14. To define an array reference(no space allocated for the array object itself):
```java
int[] a1;  // more sensible
```
or
```java
int a1[];
```
The compiler doesn't allow you to tell it how big the array is.

15. A special kind of initialization expression that must occur at the point where the array is created:
```java
int[] a1 = {1, 2, 3, 4, 5};
```
The storage allocation(the equivalent of using **new**) is taken care of by the compiler in this case.
```java
Random rand = new Random(47);
int[] a = new int[rand.nextInt(20)];
System.out.println("length = " + a.length);
System.out.println(Arrays.toString(a));  // useful
```

16. All arrays have an intrinsic member **length** that you can query--but not change. If you go out of bounds, Java protects you by causing a runtime error.

17. It's possible to initialize arrays of bojects by using the curly brace-enclosed list. Two forms:
```java
Integer[] a = {
  new Integer(1),
  new Integer(2),
  3,  // Autoboxing
};
Integer[] b =  new Integer[] {
  new Integer(1),
  new Interger(2),
  3,  // Autoboxing
}
MyClass.Method(new String[]{"one", "two", "three"});
```
In both cases, the final comma in the list of initializers is optional.

18. One way to implement *variable argument lists* (pre-Java SE5):
```java
static void printArray(Object[] args) {
  for(Object obj : args)
    System.out.print(obj + " ");
}
```
Now:
```java
public class test {
  static void printArray(Object... args) { /*   ... */}
  public static void main(String[] args) {
    // Individual elements, not array syntax
    printArray(new Interger(47), new Float(3.14), new Double(11.11));
    printArray(47, 3.14F, 11.11);
    printArray("one", "two", "three");

    // array
    printArray((Object[])new Interger[]{1, 2, 3, 4});  // cast to remove warning
    printArray();  // Empty list is OK
  }
}
```
Optional trailing arguments:
```java
public class OptionalTrailingArguments {
  static void fun(int required, String... trailing) {
    System.out.print("required: " + required + " ");
    for(String s : trailing)
      System.out.print(s + " ");
  }
  public static void main(String[] args) {
    fun(1, "one");
    fun(0);
  }
}
```
Note: you can use varargs with a specified type other than **Object**.

The following code won't compile:
```java
public class OverloadingVarargs {
  static void f(float i, Character...args) {}
  static void f(Character... args) {}
}
```
If you give both methods a non-vararg argument, it works:
```java
public class OverloadingArgs {
  static void f(float i, Character... args) {}
  static void f(char c, Character... args) {}
}
```

19. Enumerated type:
```java
public enum Spiciness {
  NOT, MILD, MEDIUM, HOT, FLAMING
}
public class EnumOrder {
  public static void main(String[] args) {
    for(Spiciness s : Spiciness.values())
      System.out.println(S + ", ordinal " + s.ordinal());
  }
}
```
The compiler automatically adds useful features when you create an **enum**:
 * toString: display the name
 * ordinal: order of a particular **enum** Constant
 * values: produce an array of values of the **enum** constants in the order that they were declared


## Access Control
1. The levels of access control from "most access" to "least access" are **public, protected, package access(no keyword), and private**. The access specifiers are affected by whether a class is in the same package or in a separate package.

2. **package**, the library unit, contains a group of classes, organized together under a single *namespace*. “unnamed” or *default package*. **package** statement *must* appear as the first non-comment in the file (package name is conventionally using all lowercase letters):
```java
package pckname;
```

3. When you create a source-code file for Java, it's commonly called a *compilation unit*(sometimes a *translation unit*). Each compilation unit must have a name ending in **.java**, and inside the compilation unit there can be a **public** class that must have the same name as the file (including capitalization). There can be only one **public** class in each compilation unit. If there are additional classes in that compilation unit, they are hidden from the world outside that package.

4. When you compile a *.java* file, you get an output file *for each class in the _.java_* file. A working program is a bunch of **.class** files, which can be packaged and compressed into a Java ARchive (JAR) file (using Java's **jar** archiver). The Java interpreter is responsible for finding, loading, and interpreting these files.
The Java interpreter uses the environment variable **CLASSPATH** as roots in a search for **.class** files. For JAR files, you must put the actual name of the JAR file in the classpath, not just the path where it's loaded.

5. static import:
```java
import static pkgname.classname.*;
```
User code can directly use static methods inside classname.

6. Java misses C's *conditional compilation*.

7. Java treats files as implicitly part of the "default" package for a directory, and thus they provide package access to all the other files in that directory. In one file:
```java
class Pie {
  void f(){}
}
```
In another file:
```java
class Cake {
  public static void main(String[] args) {
    Pie x = new Pie();
    x.f();
  }
}
```

8. In Java, the access specifiers (public and package access) can also be used to determine which classes *within* a library will be available to the uses of that library. The Singleton pattern:
```java
public class Soup {
  private Soup2() {}
  private static Soup ps = new Soup();
  public static Soup instance() { return ps; }
}
```

## Reusing classes
1. You can initialize references inside a class in four ways:
 * At the point the object are defined. This means that they'll always be initialized before the constructor is called.
 * In the constructor for that class
 * Right before you actually need to use the object. This is often called *lazy initialization*. It can reduce overhead in situations where object creation is expensive and the object doesn't need to be created every time.
 * Using *instance initialization*.

2. You implicitly inherit from Java's standard root class *Object*. **_super_** keyword refers to the "superclass". Java automatically inserts calls to the base-class constructor in the derived-class constructor.
If your class doesn't have default arguments, or if you want to call a base-class constructor that has an argument, you must explicitly write the calls to the base-class constructor using the **super** keyword. In addition, the call to the base-class constructor *must* be the first thing you do in the derived-class constructor.

3. You can create a **main()** for each one of your class. even if a class has package access, a **public main()** is accessible. This technique of putting a **main()** in each class allows easy testing for each class.

4. *delegation* is midway between inheritance and composition. This relationship is not directly supported by Java.

5. **Name hiding**: If a Java base class has a method name that's overloaded several times, redefining that method name in the derived class will *not* hide any of the base-class versions (**unlike C++**).

6. Java SE5 has added the **@Override** annotation, which is not a keyword but can be used as if it were. When you mean to override a method, you can choose to add this annotation and the compiler will produce an error message if you accidentally overload instead of overriding.

7. In Java, **protected** also provides package access.

8. **final** keyword can be used to: *data, methods, classes*.
 * When **final** is used with object references rather than primitives, the *reference* is constant. Once the reference is initialized to an object, it can never be changed to point to another object. However, the object itself can be modified.
 * *black finals*: fields that are declared as **final** but are not given an initialization value. The blank final *must* be initialized before it is used, and the compiler ensures this.
 * **final** arguments means that inside the method you cannot change what the argument reference points to.
 * Make a method **final** to explicitly prevent overriding.

9. Any **private** methods in a class are implicitly **final**. You can add the **final** specifier to a **private** method, but it doesn't give that method any extra meaning.

10. A **final** class indicates that you don't want to inherit from this class or allow anyone else to do so. All methods in a **final** class are implicitly **final**, since there's no way to override them. You can add the **final** specifier to a method in a **final** class, but it doesn't add any meaning.

11. In general, you can say that "class code is loaded at the point of first use".

## Polymorphism
1. All method binding in Java uses late binding unless the method is **static** or **final** (**private** methods are implicitly **final**).

2. Only ordinary method calls can be polymorphic. If you access a field directly, that access will be resolved at compile time. If a method is **static**, it doesn't behave polymorphically.

3. Behavior of polymorphic methods inside constructors: if you call a dynamically-bound method inside a constructor, the overridden definition for that method is used. However, the effect of this call can be rather unexpected because the overridden method will be called before the object is fully constructed.

4. The process of initialization is:
 * The storage allocated for the object is initialized t binary zero before anything else happens.
 * The base-class constructors are called.
 * Member initializers are called in the order of declaration.
 * The body of the derived-class constructor is called.

5. A guideline for constructor:
 Do as little as possible to set the object into a good state, and if you can possibly avoid it, don't call any other methods in this class.
The only safe methods to call are those that are **final** in the base class and **private** methods.

6. *covariant return types*: an overridden method in a derived class can return a type derived from the type returned by the base-class method.
```java
class Grain {}
class Wheat extends Grain {}
class Mill {
  Grain process() { return new Grain(); }
}
class WheatMill extends Mill {
  Wheat process() { return new Wheat(); }
}
```

7. About the composition and inheritance, a general guideline is "Use inheritance to express differences in behavivor, and fields to express variations in state".

8. "*pure substitution*": only methods that have been established in the base class are overridden in the derived class, a pure "is-a" relationship. Otherwise, if the derived class has implemented additional methods, it is termed as "is-like-a" relationship.

9. In Java, every type cast is checked at runtime, this act is called *runtime type identification (RTTI)*. If it isn't the correct type, you get a **ClassCastException**.

## Interface
1. Abstract method has only a declaration and no method body:
```java
Abstract void f();
```
A class containing Abstract methods is called an abstract class. If a class contains one or more abstract methods, the class itself must be qualified as **abstract**. If a derived class doesn't provide method definition for all the abstract methods in the base class, you have to qualify that class with the **abstract** keyword.

2. It's possible to make a class **abstract** without including any **abstract** methods. This is useful when you've got a class in which it doesn't make sense to have any **abstract** methods, and yet you want to prevent any instances of that class.

3. An interface is more than just an abstract class taken to the extreme, since it allows you to perform a variation of "multiple inheritance" .

4. To create an interface, use the **interface** keyword instead of the **class** keyword. An interface can contain fields, but these are implicitly **public**, **static** and **final**. To make a class that conforms to a particular interface (or group of interfaces), use the **implements** keyword.

5. Methods in an interface are implicitly **public**. When you **implement** an interface, the methods from the interface *must* be defined as **public**. Otherwise, they would default to package access, and you'd be reducing the accessibility of a method during interitance, which is not allowed by the Java compiler.
```java
interface Instrument {
  int VALUE = 5;  // static & final
  void play();  // public
}
```

6. You can inherit from only one **abstract** or *concrete* class, but you can have as many interfaces as you want, placing them after the **implements** keyword and separate them with commas. The concrete class must come first, then the interfaces.
```java
interface CanFight() {
  void fight();
}
interface CanSwim {
  void swim();
}
class ActionCharacter {
  public void fight() {}
}
class Hero extends ActionCharacter implements CanFight, CanSwim {
  public void swim() {}
}
```
Even though **Hero** does not explicitly provide a definition for **fight()**, the definition comes along with **ActionCharacter**; thus, it's possible to create **Hero** object.

7. Extending an interface with inheritance by adding new method declarations or combining several interfaces.
```java
interface Monster {void meanace();}
Interface DangerousMonster extends Monster { void destroy(); }
interface Lethal { void kill();}
interface Vampire extends DangerousMonster, Lethal { void drinkBlood();}
```
8. Fields defined in interfaces cannot be "blank **final**", but they can be initialized with non-constant expressions. Since the fields are **static**, they are initialized when the class is first loaded, which happens when anyof the Fields are accessed for the first time. The field values are stored in the static storage area for that interface.

9. Interfaces may be nested within classes and within other interfaces.

## Inner classes
1. Inner classes allows you to group classes that logically belong together and to control the visibility of one within the other.
If you want to make an object of the inner class anywhere except from within a **non-static** method of the outer class, you must specify the type of that object as *OuterClassName.InnerClassName*.

2. An object of inner class has a *link to the enclosing object that made it*, and it can access the members of that enclosing object--without any special qualifications. In addition, **inner classes have access rights to all the elements in the enclosing class**. There is no link to an enclosing object and no implied permissions in C++.
```java
interface Selector {
	boolean end();
	Object current();
	void next();
}
public class Sequence {
	private Object[] items;
	private int next = 0;
	public Sequence(int size) { items = new Object[size]; }
	public void add(Object x) {
		if (next < items.length) {
			items[next++] = x;
		}
	}
	private class SequenceSelector implements Selector {
		private int i = 0;
		public boolean end() { return i == items.length; }
		public Object current() { return items[i]; }
		public void next() { if (i < items.length) i++; }
	}
	public Selector selector() {
		return new SequenceSelector();
	}
	public static void main(String[] args) {
		Sequence sequence = new Sequence(10);
		for (int i = 0; i < 10; i++) {
			sequence.add(Integer.toString(i));
		}
		Selector selector = sequence.selector();
		while(!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
	}
}
```

3. The inner class secretly captures a reference to the particular object of the enclosing class that was responsible for creating it. Then, when you refer to a member of the enclosing class, that reference is used to select that member. Fortunately, the compiler takes care of all these details for you, but now you can see that an object of an inner class can be created only in association with an object of the enclosing class (the inner class is non-static). Construction of the inner-class object requires the reference to the object of the enclosing class, and the compiler will complain if it cannot access that reference.

4. If you need to produce the reference to the outer-class object, use *OuterClass*.this.
```java
public class DotThis {
  void f() {}
  public class Inner {
    public DotThis outer() {
      return DotThis.this;  // A plain "this" would be Inner's "this"
    }
  }
  public Inner inner() { return new Inner(); }
  public static void main(String[] args) {
    DotThis dt = new DotThis.inner();
    DotThis.Inner dti = dt.inner();
    dti.outer().f();
  }
}
```
To create an object of inner classes, you must provide a reference to the outer-class object in the **new** expression (this resovles the name scoping issues for the innerr class), using the **.new** syntax:
```java
public class DotNew {
  public class Inner {}
  public static void main(String[] args) {
    DotNew dn = new DotNew();
    DotNew.Inner dni = dn.new Inner();
  }
}
```
You can't say **dn.new DotNew.Inner()**. It's not possible to create an object of the inner class unless you already have an object of the outer class. This is because the object of the inner class is quietly connected to the object of the outer class that it was made from. However, if you make a *nested class* (a **static** inner class), then it doesn't need a reference to the outer-class object.

5. Inner class is convenient for hiding the implementation:
```java
class Parcel {
  private class PI1 implements Interface1 {}
  protected class PI2 implements Interface2 {}  // protected gives package access

  public Interface1 createInt1() { return new PI1(); }
  public Interface2 createInt2() { return new PI2(); }
}
public class TestParcel {
  public static void main(String[] args) {
    Parcel p = new Parcel;
    Interface1 i1 = p.createInt1();
    Interface2 i2 = p.createInt2();

    // Illegal  --- can't access private class
    // Parcel.PI1 p1 = p.new PI1();
  }
}
```
The **private** inner class provides a way to completely prevent any type-coding dependencies and to completely hide details about implementation.

6. Inner classes can be created within a method or even an arbitrary scope. There are two reasons for doing this:
 * You're implementing an interface of some kind so that you can create and return a reference.
 * You're solving a complicated problem and you want to create a class to aid in your solution, but you don't want it publicly available.

7. Other usages of inner class:
 * A class defined within a method (called a *local inner class*)
 ```java
 interface Destination {}
 public class Sequence {
	public Destination createDest() {
		class PDestination implements Destination {
			private PDestination() {}
		}
		return new PDestination();
	}
	public static void main(String[] args) {
		Sequence s = new Sequence();
		Destination d = s.createDest();
	}
}
 ```
 * A class defined within a scope inside a method
 * An anonymous class implementing an interface
 ```java
 interface Contents { int value(); }
public class Sequence {
	public Contents contents() {
    // It means "Create an object of an anonymous class that's inherited from Contents"
    // The reference returned is automatically upcast to a Contents reference
		return new Contents() {
			private int i = 11;
			public int value() { return i; }
		};
	}
	public static void main(String[] args) {
		Sequence p = new Sequence();
		Contents c = p.contents();
	}
}
 ```
 * An anonymous class extending a class that has a non-default constructor
```java
class Wrapping {
	private int i;
	public Wrapping(int x) { i = x; }
	public int value() { return i; }
}
public class Parcel {
	public Wrapping wrapping(int x) {
		return new Wrapping(x) {  // Pass constructor argument
			public int value() {
				return super.value() * 36;
			}
		};
	}
	public static void main(String[] args) {
		Parcel p = new Parcel();
		Wrapping w = p.wrapping(10);
		System.out.println("value=" + w.value());
	}
}
```
 * An anonymous class that performs field initialization
```java
interface Destination {
	String readLabel();
}
public class Parcel {
	public Destination destination(final String dest) {
    {System.out.println("Inside instance initializer");}
		return new Destination() {
			private String label = dest;
			public String readLabel() { return label; }
		};
	}
	public static void main(String[] args) {
		Parcel p = new Parcel();
		Destination d = p.destination("Tasmania");
		System.out.println("label=" + d.readLabel());
	}
}
```
 * An anonymous class that performs Construction using instance initialization (anonymous inner classes can't have constructors)

8. In effect, an instance initializer is the constructor for an anonymous inner class. Anonymous inner classes are somewhat limited compared to regular inheritance, because they can either extend a class or implement an interface, but not both.

9. Factory method:
```java
interface Service {
	void method();
}
interface ServiceFactory {
	Service getService();
}
class Implementation1 implements Service {
	private Implementation1() {}
	public void method() {}
	public static ServiceFactory factory =
		new ServiceFactory {
			public Service getService() {
				return new Implementation1();
			}
		};
}
```
Note that the constructor for Implementation1 can be **private**.

10. *Prefer classes to interfaces*

11. If you don't need a connection between thie inner-class object and the outer-class object, then you can make the inner class *static** (called a *nested class*). It means:
 * You don't need an outer-class object in order to create an object of a nested class.
 * You can't access a non-static outer-class object from an object of a nested class.

12. Fields and methods in ordinary inner classes can only be at the outer level of a class, so ordinary inner classes can't have static data, static fields, or nested classes. However, nested classes can have all of these.

13. Any class you put inside an interface is automatically **public** and **static**. The nested class is only placed inside the namespace of the interface. You can even implement the surrounding interface in the inner class:
```java
public interface ClassInterface {
  void howdy();
  class Test implements ClassInterface {
    public void howdy() {}
    public static void main(String[] args) {
      new Test().howdy();
    }
  }
}
```
To run this code, use **java ClassInterface$Test** command.
It's convenient to nest a class inside an interface when you want to create some common code to be used with all different implementations of that interface.

14. Put test code in a nested class:
```java
public class TestBed {
  public void f() {}
  public static class Tester {
    public static void main(String[] args) {
      TestBed t = new TestBed();
      t.f();
    }
  }
}
```

15. It doesn't matter how deeply an inner class may be nested -- it can transparently access all of the members of all the classes it is nested within:
```java
class MNA {
	private void f() {}  // private
	class A {
		private void g() {}
		public class B {
			void h() {
				g();
				f();
			}
		}
	}
}
public class MultiNestingAccess {
	public static void main(String[] args) {
		MNA mna = new MNA();
		MNA.A mnaa = mna.new A();
		MNA.A.B mnaab = mnaa.new B();
		mnaab.h();
	}
}
```

16. The most compelling reason for inner classes is: *Each inner class can independently inhert from an implementation. Thus, the inner class is not limited by whether the outer class is already inheriting from an implementation*.

17. Inner classes effectively allow you to inherirt from more than one non-interface.
```java
class D {}
abstract class E {}
class Z extends D {
  E makeE() { return new E() {}; }
}
public class Test {
  static void takesD(D d) {}
  static void takesE(E e) {}
  public static void main(String[] args) {
    Z z = new Z();
    takesD(z);
    takesE(z.makeE());
  }
}
```

18. With inner classes you have these additional features:
 * The inner class can have multiple instances, each with its own state information that is independent of the information in the outer-class object.
 * In a single outer class you can have several inner classes, each of which implements the same interface or inherits from the same class in a different way.
 * The point of creation of the inner-class object is not tied to the creation of the outer-class object.
 * There is no potentially confusing "is-a" relationship with the inner class; it's a separate entiry.

19. A *closure* is callable object that retains information from the scope in which it was created. An inner class is an object-oriented closure.

20. Inheriting from inner classes:
```java
class WithInner {
	class Inner{}
}
public class InheritInner extends WithInner.Inner {
	// InheritInner() {}  // Won't compile
	InheritInner(WithInner wi) {
		wi.super();  // provide the necessary reference
	}
	public static void main(String[] args) {
		WithInner wi = new WithInner();
		InheritInner ii = new InheritInner(wi);
	}
}
```

21. An inner class can't be overridden like a method.
```java
class Egg {
	private Yolk y;
	protected class Yolk {
		public Yolk() { System.out.println("Egg.Yolk"); }
	}
	public Egg() {
		System.out.println("New Egg()");
		y = new Yolk();
	}
}
public class InheritInner extends Egg {
	public class Yolk {
		public Yolk() { System.out.println("BigEgg.Yolk()"); }
	}
	public static void main(String[] args) {
		new InheritInner();
	}
}
```
The two inner classes are completely separate entities, each in its own namespace.

22. A local inner class can't have an access specifier because it isn't part of the outer class, but it does have access to the final variable in the current code block and all the members of the enclosing class.
```java
interface Counter {
	int next();
}
public class LocalInnerClass {
	private int count = 0;
	Counter getCounter(final String name) {
		class LocalCounter implements Counter {
			public LocalCounter() {
				System.out.println("LocalCounter()");
			}
			public int next() {
				System.out.println(name);
				return count++;
			}
		}
		return new LocalCounter();
	}
	Counter getCounter2(String name) {
		return new Counter() {
			{
				System.out.println("Counter()");
			}
			public int next() {
				System.out.println(name);
				return count++;
			}
		};
	}
	public static void main(String[] args) {
		LocalInnerClass lic = new LocalInnerClass();
		Counter
			c1 = lic.getCounter("Local inner"),
			c2 = lic.getCounter2("Anonymous inner");
		for (int i=0; i <5; i++) {
			System.out.println(c1.next());
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(c2.next());
		}
	}
}
```

23. Two reasons to make a local inner class rather than an anonymous inner class:
 * Make more than one object of that class
 * You need a named constructor and/or an overloaded constructor

## Holding Your objects
1. The **java.util** library provides several *container classes*: **List, Set, Queue and Map**.
`@SuppressWarnings("unchecked")` is used to suppress the warning.

2. Adding groups of elements:
 * **Arrays.asList()** takes either an array or a comma-separated list of elements (using varargs) and turns it into a **List** object.
 * **Collections.addAll()** takes a **Collection** object and either an array or a comma-separated list and adds the elements to the **Collection**.
 ```java
 Collection<Integer> collection =
   new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
 Integer[] moreInts = {6, 7, 8, 9, 10};
 collection.addAll(Arrays.asList(moreInts));
 // Runs significantly faster, but you can't
 // construct a Collection this way
 Collections.addAll(collection, 11, 12, 13, 14, 15);
 Collections.addAll(collection, moreInts);
 // Produces a list "backed by" an array
 List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
 list.set(1, 99);  // OK -- modify an element
 // Runtime error because the underlying array cannot be resized
 // list.add(21);
 ```
 **Collections.addAll()** runs much faster, the preferred approach is: construct the **Collection** with no elements and then call **Collections.addAll()**.
 A limitation of **Arrays.asList()** is that it takes a best guess about the resulting type of the **List**, and deesn't pay attention to what you're assigning it to.
 ```java
import java.util.*;
class Snow {}
class Powder extends Snow {}
class Light extends Powder {}
class Heavy extends Powder {}
class Crusty extends Snow {}
class Slush extends Snow {}
public class AsListInference {
	public static void main(String[] args) {
		List<Snow> snow1 = Arrays.asList(new Crusty(), new Slush(), new Powder());
		// Compiler used to says:
		// found : java.util.List<Powder>
		// required: java.util.List<Snow>
		List<Snow> snow2 = Arrays.asList(new Light(), new Heavy()); // Won't compile ??
		// The following is fine
		List<Snow> snow3 = new ArrayList<Snow>();
		Collections.addAll(snow3, new Light(), new Heavy());
		// Give a hint using an explicit type argument specification
		List<Snow> snow4 = Arrays.<Snow>asList(new Light(), new Heavy());
	}
}
 ```

3. **LinkedList** has methods that directly implement stack functionality, so you can also use a **LinkedList** rather than makeing a stack class.

4. The **java.util.AbstractCollection** class provides a default implementation for a **Collection**, so that you can create a new subtype of **AbstractCollection** without unnecessary code duplication.

5. Producing an **Iterator** is the least-coupled way of connecting a sequence to a method that consumes that sequence, and puts far fewer constraints on the sequence class than does implementing **Collection**.
```java
import java.util.*;
class PetSequence {
	protected Integer[] pets = {1, 2, 3, 4};
}
public class NonCollectionSequence extends PetSequence {
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			private int index = 0;
			public boolean hasNext() {
				return index < pets.length;
			}
			public Integer next() { return pets[index++]; }
			public void remove() { // Not implemented
				throw new UnsupportedOperationException();
			}
		};
	}
}
```

6. The **foreach** syntax works with any **Collection** object.
```java
import java.util.*;
public class ForEachCollections {
	public static void main(String[] args) {
		Collection<String> cs = new LinkedList<String>();
		Collections.addAll(cs, "Take the long way home".split(" "));
		for (String s : cs) {
			System.out.print("'" + s + "' ");
		}
	}
}
```
The **Iterable** interface is what **foreach** uses to move through a sequence.

7. Anything **Iterable** works with **foreach**:
```java
import java.util.*;
public class IterableClass implements Iterable<String> {
	protected String[] words = ("And that is how " +
		"we know the Earth to be banana-shaped.").split(" ");
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private int index = 0;
			public boolean hasNext() {
				return index < words.length;
			}
			public String next() { return words[index++]; }
			public void remove() { // Not implemented
				throw new UnsupportedOperationException();
			}
		};
	}
	public static void main(String[] args) {
		for (String s : new IterableClass()) {
			System.out.print(s + " ");
		}
	}
}
```
**Map** are not **Iterable**. A number of classes have been made **Iterable**:
`for(Map.Entry entry: System.getenv().entrySet()) {...}`
**System.getenv()** returns a **Map**, **entrySet** produces a **Set** of **Map.Entry** elements, and a **Set** is **Iterable** so it can be used in a foreach loop.

8. An array is not an **Iterable**:
```java
import java.util.*;
public class IterableClass {
	static <T> void test(Iterable<T> ib) {
		for (T t : ib) {
			System.out.print(t + " ");
		}
	}
	public static void main(String[] args) {
		test(Arrays.asList(1, 2, 3));
		String[] strings = { "A", "B", "C" };
		// An array works in foreach, but it's not Iterable.
		// test(strings);
		// You must explicitly convert it to an Iterable
		test(Arrays.asList(strings));
	}
}
```

9. A container won't hold primitives, but autoboxing takes care of translating primitives back and forth to the wrapper types held in the container.

10. There's no need to use the legacy classes **Vector, Hashtable**, and **Stack** in new code.

## Error Handling with exceptions
1. There are two constructors in all standard exceptions: the first is the default constructor, and the second takes a string argument. You can throw any type of **Throwable** (the exception root class).

2. One of the **Throwable** (from which **Exception** is inherited) method is called: **printStackTrace()**. The information default to the standard error stream, but you can change it like: `e.printStackTrace(System.out)`. You may want to *log* the output using the **java.util.logging** facility. **printStackTrace()** doesn't produce a **String** by default.
```java
import java.util.logging.*;
import java.io.*;
class LoggingException extends Exception {
	private static Logger logger = Logger.getLogger("logger");
	public LoggingException() {
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}
public class LoggingExceptions {
	public static void main(String[] args) {
		try {
			throw new LoggingException();
		} catch(LoggingException e) {
			System.err.println("Caught " + e);
		}
		try {
			throw new LoggingException();
		} catch(LoggingException e) {
			System.err.println("Caught " + e);
		}
	}
}
```

3. The *exception specification* uses an additional keyword **throws**, like this:
```java
void f() throws TooBig, DivZero { ... }
```
If you say `void f() {...}`, it means that no exceptions are thrown from the method (except for the exceptions inherited from **RuntimeException**, which can be thrown anywhere without exception specifications).
If the code within method causes exceptions, you must either handle the exception or indicate with an exception specification.
You can claim to throw an exception that you really don't. This has the beneficial effect of being a placeholder for that exception. It's also important for creating **abstract** base classes and **interfaces** whose derived classes or implementations may need to throw exceptions.

4. Exceptions that are checked and enforced at compile time are called *checked exceptions*.

5. Although there are other types of base exceptions, **Exception** is the base that's pertinent to virtually all programming activities. You can use it to create a handler that catches any type of exception.

6. If you simply rethrow the current exception, the information will pertain to the exception's origin, not the place where you rethrow it. If you want to install new stack trace information, you can do so by calling **fillStackTrace()**, which returns a **Throwable** object that it creates by stuffing the currect stack information into the old exception object.
It's possible to rethrow a different exception from the one you caught.
```java
class OneException extends Exception {
	public OneException(String s) { super(s); }
}
class TwoException extends Exception {
	public TwoException(String s) { super(s); }
}
public class RethrowNew {
	public static void f() throws OneException {
		System.out.println("in f()");
		throw new OneException("Thrown from f()");
	}
	public static void main(String[] args) {
		try {
			try {
				f();
			} catch(OneException e) {
				System.out.println("Caught in inner try, stack:");
				e.printStackTrace(System.out);
				throw new TwoException("from inner try");
			}
		} catch(TwoException e) {
			System.out.println("Caught in outer try, stack:");
			e.printStackTrace(System.out);
		}
	}
}
```

7. All **Throwable** subclasses have the option to take a *cause* object in there constructor. The *cause* is intended to be the originating exception, and by passing it in you maintain the stack trace back to the origin, even though you're creating and throwing a new exception.
The only **Throwable** subclasses that provide the *cause* argument in the constructor are the three fundamental exception classes **Error**, **Exception**, and **RuntimeException**. If you want to chain any other exception types, you do it through the **initCause()** method.
```java
private Object[][] fields;
public DynamicFields(int initialSize) {
    fields = new Object[initialSize][2];
    for(int i = 0; i < initialSize; i++)
      fields[i] = new Object[] { null, null };
}
public String toString() {
    StringBuilder result = new StringBuilder();
    for(Object[] obj : fields) {
      result.append(obj[0]);
      result.append(": ");
      result.append(obj[1]);
      result.append("\n");
    }
    return result.toString();
}
```

8. There are two general types of **Throwable** objects. **Error** represents compile-time and system errors that you usually don't worry about catching. **Exception** is basic type that can be thrown from any of the standard Java library class methods and from your methods and runtime accidents.

9. **RuntimeException** or any type inherited from it are *unchecked exceptions*.

10. Performing cleanup with **finally**:
```java
try {
  // ....
} catch(A a) {
  //
} catch(B b) {
  // ...
} finally {
  // ...
}
```
Even in cases in which the exception is not caught in the current set of **catch** clauses, **finally** will be executed before the exception-handling mechanism continues its search for a handler at the next higher level.

11. Using **finally** during **return** to guarantee that important cleanup will be performed.

12. It's possible for an exception to simply be lost. This happens with a particular configuration using a **finally** clause.
```java
class ExceptionA extends Exception {}
class ExceptionB extends Exception {}
public class LostMessage {
  public static void main(String[] args) {
    try {
      try {
        throw new ExceptionA();
      } finally {
        throw new ExceptionB();
      }
    } catch(Exception e) {
      System.out.println(e);
    }
  }
}
```
An even simpler way to lose an exception is just to **return** from inside a **finally** clause:
```java
public class ExceptionSilencer {
  public static void main(String[] args) {
    try {
      throw new RuntimeException();
    } finally {
      return;
    }
  }
}
```

13. Overridden methods may throw only the exceptions specified in their base-class versions, or exceptions derived from the base-class exceptions. It's ok to add new exceptions for constructors, but you must deal with the base constructor exceptions. A derived-class constructor cannot catch exceptions thrown by its base-class constructor.
Although exception specifications are enforced by the compiler during inheritance, the exception specifications are not part of the type of a method, which comprises only the method name and argument types. Therefore, you cannot overload methods based on exception specifications. In addition, just because an exception specification exists in a base-class version of a method doesn’t mean that it must exist in the derived-class version of the method. Put another way, the "exception specification interface" for a particular method may narrow during inheritance and overriding, but it may not widen—this is precisely the opposite of the rule for the class interface during inheritance.

14. It's possible putting try-block inside **catch** clause:
```java
catch(Exception e) {
  // All other exceptions must close it
  try {
    in.close();
  } catch(IOException e2) {
    //
  }
  throw e;
  }
```

15. A general cleanup idiom: guaranteeing proper cleanup of a resource:
```java
public class Cleanup {
  public static void main(String[] args) {
    try {
      // Some operations may throw exception but need not cleanup
      try {
        // Some operations may throw exception and need cleanup
      } catch(Exception e) {
        e.printStackTrace(System.out);
      } finally {
        // cleaning up
      }
    } catch(Exception e) {
      //
    }
  }
}
```
The basic rule is: Right after you create an object that requires cleanup, begin a **try-finally**.

16. Note that **main()** is also a method that may have an exception specification.
```java
import java.io.*;
public class MainException {
  public static void main(String[] args) throws Exception {
    FileInputStream file = new FileInputStream("MainException.java");
    file.close();
  }
}
```

17. Here is a solution if you want to "turn off the checked exception--you don't swallow it, and you don't have to put it in your method's exception specification, but because of exception chaining you don't lose any information from the original exception":
```java
try {
  //
} catch(IDontKnowWhatToDoWithThisCheckedException e) {
  throw new RuntimeException(e);
}
```

## Strings
1. Objects of the **String** are immutable. Every method in the class that appears to modify a **String** actually creates and returns a brand new **String** object containing the modification.

2. The '+' and '+=' for **String** are the only operators that are overloaded in Java, and Java does not allow overloading any others. Statements like `String s = "abc" + mango + "def" + 47;` would produce a bunch of intermediate **String** objects that need to be garbage collected.
Using `javap -c ClassName` command to produce the JVM bytecodes, you can see that the compiler chooses StringBuilder class to optimize it.

3. The following code causes **StackOverflow** exception:
```java
import java.util.*;
public class InfiniteRecursion {
  public String toString() {
    // The compiler tries to convert 'this' to a String which produces a recursive call
    return " InfiniteRecursion address: " + this + "\n";
  }
  public static void main(String[] args) {
    List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
    for (int i=0; i < 10; i++) {
      v.add(new InfiniteRecursion());
    }
    System.out.println(v);
  }
}
```
To print the address of the object, this solution is: instead of saying **this**, you'd way **super.toString()**.

4. **PrintStream** and **PrintWriter** classes have **format()** method, modeled after C's **printf()**. There is a convenience **printf()** method which just calls **format()**. All of Java's new formatting functionalality is handled by the **Formatter** class.
**String.format()** is a **static** method which takes all the smae arguments as **Formatter's formate() ** but returns a **String**. It can come in handy when you only need to call **format()** once. Under the hood, it uses **Formatter** to do it's job.

5. To display a binary array of bytes in a readable hex format:
```java
import java.io.*;
class BinaryFile {
  public static byte[] read(File bFile) throws IOException {
    BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bFile));
    try {
      byte[] data = new byte[bf.available()];
      bf.read(data);
      return data;
    } finally {
      bf.close();
    }
  }
  public static byte[] read(String bFile) throws IOException {
    return read(new File(bFile).getAbsoluteFile());
  }
}
public class Hex {
  public static String format(byte[] data) {
    StringBuilder result = new StringBuilder();
    int n = 0;
    for (byte b : data) {
      if (n % 16 == 0) {
        result.append(String.format("%05X: ", n));
      }
      result.append(String.format("%02X ", b));
      n++;
      if (n % 16 == 0) {
        result.append("\n");
      }
    }
    result.append("\n");
    return result.toString();
  }
  public static void main(String[] args) throws Exception {
    System.out.println(format(BinaryFile.read("Hex.class")));
  }
}
```

6. **String**, **StringBuffer**, and **StringTokenizer** support *regular expression**. A useful regular expression tool that's built into **String** is **split()**. A complete list of constructs for building regular expressions can be found in the JDK documentation for the **Pattern** class for package **java.util.regex**.

7. Interface **CharSequence** establishes a generalized definition of a character sequence abstracted from the **CharBuffer, String, StringBuffer, or StringBuilder** classes. Many regular expression operations take **CharSequence** arguments.
```java
interface CharSequence {
  charAt(int i);
  length();
  subSequence(int start, int end);
  toString();
}
```

8. **Pattern** and **Matcher**. A program can be useful in testing regular expressions as you construct them to see that they produce your intended matching behavivor:
```java
import java.util.regex.*;
// {Args: abcabcabcdefabc "abc+" "(abc)+" "(abc){2,}" }
public class TestRegularExpression {
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Usage:\njava TestRegularExpression " +
        "characterSequence regularExpression+");
      System.exit(0);
    }
    System.out.println("Input: \"" + args[0] + "\"");
    for (String arg: args ) {
        System.out.println("Regular expression: \"" + arg + "\"");
        Pattern p = Pattern.compile(arg);
        Matcher m = p.matcher(args[0]);
        while(m.find()) {
          System.out.println("Match \"" + m.group() + "\" at positions " +
            m.start() + "-" + (m.end() - 1));
        }
    }
  }
}
```

9. In `A(B(C))D`, there are three groups: group 0 is **ABCD**, group 1 is **BC**, and group 2 is **C**.

10. A very simple version of the "grep" program:
```java
import java.io.*;
import java.util.*;
import java.util.regex.*;
// Static functions for reading and writing text file as
// a single string, and treading a file as an ArrayList
class TextFile extends ArrayList<String> {
  public static String read(String fileName) {
    StringBuilder sb = new StringBuilder();
    try {
      BufferedReader in = new BufferedReader(new FileReader(
        new File(fileName).getAbsoluteFile()));
      try {
        String s;
        while((s = in.readLine()) != null) {
          sb.append(s);
          sb.append("\n");
        }
      } finally {
        in.close();
      }
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
    return sb.toString();
  }
  public static void write(String fileName, String text) {
    try {
      PrintWriter out = new PrintWriter(
        new File(fileName).getAbsoluteFile());
      try {
        out.print(text);
      } finally {
        out.close();
      }
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
  }
  // Read a file, split by any regular expression:
  public TextFile(String fileName, String splitter) {
    super(Arrays.asList(read(fileName).split(splitter)));
    // Regular expression split() often leaves an empty
    // String at the first position
    if(get(0).equals("")) remove(0);
  }
  public TextFile(String fileName) {
    this(fileName, "\n");
  }
  public void write(String fileName) {
    try {
      PrintWriter out = new PrintWriter(
        new File(fileName).getAbsoluteFile());
      try {
        for (String item : this) {
          out.println(item);
        }
      } finally {
          out.close();
      }
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
  }
  public static void main(String[] args) {
    String file = read("JavaGrep.java");
    write("test.txt", file);
    TextFile text = new TextFile("test.txt");
    text.write("test2.txt");
    TreeSet<String> words = new TreeSet<String>(
      new TextFile("JavaGrep.java", "\\W+"));
    // Display the capitalized words
    System.out.println(words.headSet("a"));
  }
}
public class JavaGrep {
  public static void main(String[] args) throws Exception {
    if (args.length < 2) {
      System.out.println("Usage: java JavaGrep file regex");
      System.exit(0);
    }
    Pattern p = Pattern.compile(args[1]);
    // Iterate through the lines of the input file
    int index = 0;
    Matcher m = p.matcher("");
    for (String line : new TextFile(args[0])) {
      m.reset(line);
      while(m.find())
        System.out.println(index++ + ": " + m.group() + ": " + m.start());
    }
  }
}
```

11. The **Scanner** constructor can take any kind of input object, including a **File** object, an **InputStream**, a **String**, or a **Readable**. With **Scanner**, the input, tokenizing, and parsing are all ensconced in various different kinds of "next" methods. It supports regular expression.

12. It's much easier and more succinct to use regular expression or the **Scanner** class, than the **StringTokenizer**, which is sort of obsolete.
```java
import java.util.*;
public class ReplacingStringTokenizer {
  public static void main(String[] args) {
    String input = "But I'm not dead yet! I feel happy!";
    StringTokenizer stoke = new StringTokenizer(input);
    while(stoke.hasMoreElements()) {
      System.out.print(stoke.nextToken() + " ");
    }
    System.out.println();
    System.out.println(Arrays.toString(input.split(" ")));
    Scanner scanner = new Scanner(input);
    while(scanner.hasNext())
      System.out.print(scanner.next() + " ");
  }
}
```

## Type information
1. RTTI takes two forms: *traditional*, and *reflection* mechanism. Java performs its RTTI using the **Class** object. There's one **Class** object for each class that is part of your program. The JVM uses *class loader subsystem* to make an object of your class.

2. When you fetch an element out of `List<Shape>` container--which is actually holding Everything as an **Object**--it automatically casts the result back to a **Shape** object. This is the most basic form of RTTI, because all casts are checked at run time for correctness.

3. All classes are loaded into the JVM dynamically, upon the first use of a class.  This happens when the program makes the first reference to a **static** member of a that class. It turns out that the constructor is also a **static** method of a class. A Java program isn't completely loaded before it begens, but instead pieces of it are loaded when necessary. The class loader first checks to see if the **Class** object for that type is loaded. If not, the default class loader finds the **.class** file with that name. As the bytes for the class are loaded, they are *verified* to ensure that they have not been corrupted and that they do not comprise bad Java code (this is one of the lines of defense for security in Java).
```java
package typeinfo.toys;
interface HasBatteries {}
interface Waterproof {}
interface Shoots {}
class Toy {
  Toy() {}
  Toy(int i) {}
}
class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
  FancyToy() { super(1); }
}
public class ToyTest {
  public static void main(String[] args) {
    Class c = null;
    try {
      // full qualified name
      c = Class.forName("typeinfo.toys.FancyToy");
    } catch(ClassNotFoundException e) {
      System.exit(1);
    }
    for (Class face : c.getInterfaces()) { }
    Class up = c.getSuperclass();
    Object obj = null;
    try {
      obj = up.newInstance();
    } catch(InstantiationException e) {
      System.exit(1);
    } catch(IllegalAccessException e) {
      System.exit(1);
    }
  }
}
```
**IllegalAccessException** relates to a violation of the Java security mechanism, in this case if the default constructor is **private**.

4. Beside **Object.getClass()**, you can use *class literal* to produce the reference to the **Class** object, like `MyClass.class`. Class literals work with regular classes as well as interfaces, arrays, and primitive types. In addition, there's a standard field called **TYPE**  for primitive wrapper classes, for example, **boolean.class** is equivalent to **Boolean.TYPE**.

5. Note that creating a reference to a **Class** object using **.class** doesn't automatically initialize the **Class** object. There are three steps in preparing a class for use:
 * *Loading*, performed by the class loader. This finds the bytecodes and creates a **Class** object from it.
 * *Linking*. Verify the bytecodes in the class, allocates storage for **static** field, and if necessary, resovles all references to other classes made by this class.
 * *Initialization*. If there is a superclass, initialize that. Execute **static** initializers and **static** Initialization blocks.
Initialization is delayed until the first reference to a **static** method or to a non-constant **static** field (compile-time constant)． However, **Class.forName()** initializes the class immediately in order to produce the **Class** reference. Field like:
`static final int field = rand.nextInt(1000);` requires Initialization.

6. Using the generic syntax allows the compiler to enforce extra type checking:
```java
Class intClass = int.class;
intClass = double.class;
Class<Integer> genIntClass = int.class;
genIntClass = Integer.class;  // same thing
// genIntClass = double.class;   // Illegal
```
But `Class<Number> numClass = int.class;` doesn't work, because the **Integer Class** object is ot a subclass of the **Number Class** object. We can use this:
```java
Class<?> intClass = int.class;
intClass = double.class;
```
**Class<?>** is preferred over plain **Class**. The benefit of **Class<?>** is that it indicates that you aren't just using a non-specific class reference by accident. You *chose* it.
In order to create a **Class** reference that is constrained to a type or *any subtype*, use the following to create a *bound* (to provide compile-time type checking):
```java
Class<? extends Number> bounded = int.class;
bounded = double.class;
bounded = Number.class;
```
In the following example, **newInstance()** will return the exact type of the object:
```java
import java.util.*;
class CountedInteger {
  private static long counter;
  private final long id = counter++;
  public String toString() { return Long.toString(id); }
}
public class FilledList<T> {
  private Class<T> type;
  public FilledList(Class<T> type) { this.type = type; }
  public List<T> create(int nElements) {
    List<T> result = new ArrayList<T>();
    try {
      for (int i = 0; i < nElements; i++) {
        result.add(type.newInstance());
      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
    return result;
  }
  public static void main(String[] args) {
    FilledList<CountedInteger> fl =
      new FilledList<CountedInteger>(CountedInteger.class);
    System.out.println(fl.create(15));
  }
}
```
Also, see this:
```java
class Toy {}
class FancyToy extends Toy {}
public class GenericTest {
  public static void main(String[] args) throws Exception {
    Class<FancyToy> ftClass = FancyToy.class;
    // Produces exact type:
    FancyToy fancyToy = ftClass.newInstance();
    // This won't compile:
    // Class<Toy> upErr = ftClass.getSuperclass();
    Class<? super FancyToy> up = ftClass.getSuperclass();
    // Only produces Object
    Object obj = up.newInstance();
  }
}
```

7. A new cast syntax:
```java
class Building {}
class House extends Building {}
public class ClassCasts {
  public static void main(String[] args) {
    Building b = new House();
    House h = House.class.cast(b); // as (House)b
  }
}
```

8. Another form of RTTI in Java, like `if (x instanceof Dog)`. The **Class.isInstance()** method provides a way to dynamically test the type of an object. **instanceof** and **isInstance()** produces exactly the same results. If you compare the actual **Class** objects using ==, there is no concern with inheritance.
**Class.isAssignableFrom()** performs a runtime check to verify that the object belongs to the hierarchy of interest.
Counts instances of a type family:
```java
import java.util.*;
public class TypeCounter extends HashMap<Class<?>, Integer> {
  private Class<?> baseType;
  public TypeCounter(Class<?> baseType) {
    this.baseType = baseType;
  }
  public void count(Object obj) {
    Class<?> type = obj.getClass();
    if (!baseType.isAssignableFrom(type)) {
      throw new RuntimeException(obj + " incorrct type: " + type +
        ", should be type or subtype of " + subtype);
    }
    countClass(type);
  }
  private void countClass(Class<?> type) {
    Integer quanlity = get(type);
    put(type, quanlity == null ? 1 : quanlity + 1);
    Class<?> superClass = type.getSuperclass();
    if (superClass != null && baseType.isAssignableFrom(superClass)) {
      countClass(superClass);
    }
  }
  public String toString() {
    StringBuilder result = new StringBuilder("{");
    for (Map.Entry<Class<?>,Integer> pair : entrySet()) {
      result.append(pair.getKey().getSimpleName());
      result.append("=");
      result.append(pair.getValue());
      result.append(", ");
    }
    result.delete(result.length()-2, result.length());
    result.append("}");
    return result.toString();
  }
}
```

9. The **@SuppressWarnings** annotation cannot be placed directly onto the static initialization clause. You can create a separate function like this:
```java
@SuppressWarnings("unchecked")
private static void loader() { /*...*/ }
static { loader(); }
```

10. The true difference between RTTI and reflection is that with RTTI, the compiler opens and examines the **.class** files at compile time. Put another way, you can call all the methods of an object in the "normal" way. With reflection, the **.class** file unavailable at compile time; it's opened and examined by the runtime environment.

11. The class **Class** supports the concept of *reflection*, along with the **java.lang.reflect** library which contains the classes **Field, Method, and Constructor (each of which implements the **Member** interface).

12. A class method extractor: using reflection to show all the methods of a class, even if the methods are defined in the base class.
```java
import java.lang.reflect.*;
import java.util.regex.*;
public class ShowMethods {
	private static final String usage =
		"usage:\n" +
		"ShowMethods qualified.class.name\n" +
		"To show all methods in class or:\n" +
		"ShowMethods qualified.class.name word\n" +
		"to search for methods involving 'word'";
	private static Pattern p = Pattern.compile("\\w+\\.");
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println(usage);
			System.exit(0);
		}
		try {
			boolean has_filter = (args.length > 1);
			Class<?> c = Class.forName(args[0]);
			Method[] methods = c.getMethods();
			Constructor[] ctors = c.getConstructors();
			for (Method method : methods) {
				if (has_filter &&
					method.toString().indexOf(args[1]) == -1) {
					continue;
				}
				System.out.println(
					p.matcher(method.toString()).replaceAll(""));
			}
			for (Constructor ctor : ctors) {
				if (has_filter &&
					ctor.toString().indexOf(args[1]) == -1) {
					continue;
				}
				System.out.println(
					p.matcher(ctor.toString()).replaceAll(""));
			}
		} catch(ClassNotFoundException e) {
			System.out.println("No such class: " + e);
		}
	}
}
```
The compiler-synthesized default constructor is automatically given the same access as the class.

13. You create a dynamic proxy by calling the **static** method **Proxy.newProxyInstance()**.

14. `javap -private ClassName` shows all members, even private ones. Using reflection, it's possible to show, chage and execute class members. package-access, private inner class, anonymous class, could not hide anything from reflection.

## Generic
1. The recipient of the *tuple* is allowed to read the elments but not change it (This concept is called a *Data Transfer Object* or *Messager*). A tuple implicitly keeps its elements in order.
```java
class TwoTuple<A,B> {
	public final A first;
	public final B second;
	public TwoTuple(A a, B b) { first = a; second = b; }
	public String toString() {
		return "(" + first + ", " + second + ")";
	}
}
class ThreeTuple<A,B,C> extends TwoTuple<A,B> {
	public final C third;
	public public ThreeTuple(A a, B b, C c) {
		super(a, b);
		third = c;
	}
	public String toString() {
		return "(" + first + ", " + second + ", " + third + ")";
	}
}
```

2. A stack implemented with an internal linked structure:
```java
public class LinkedStack<T> {
	private static class Node<U> {
		U item;
		Node<U> next;
		Node() { item = null; next = null; }
		Node(U item, Node<U> next) {this.item=item; this.next=next;}
		boolean end() {return item==null && next==null;}
	}
	private Node<T> top = new Node<T>();  // end sentinel
	public void push(T item) {top = new Node<T>(item, top);}
	public T pop() {
		T result = top.item;
		if (!top.end()) {
			top = top.next;
		}
		return result;
	}
	public static void main(String[] args) {
		LinkedStack<String> lss = new LinkedStack<String>();
		for (String s: "Phasers on stun!".split(" ")) {
			lss.push(s);
		}
		String s;
		while((s=lss.pop()) != null) {
			System.out.println(s);
		}
	}
}
```

3. Generics also work with interfaces, e.g., `interface Generator<T> { T next(); }`.

4. You can parameterize methods within a class. The class itself may or may not be generic--this is independent of whether you hava a generic method. As a guideline, you should use generic methods "whenever you can".
```java
public class GenericMethods {
	public <T> void f(T x) {
		System.out.println(x.getClass().getName());
	}
	public static void main(String[] args) {
		GenericMethods gm = new GenericMethods();
		gm.f("");
		gm.f(1);
		gm.f(1.0);
		gm.f(1.0F);
		gm.f('c');
		gm.f(gm);
	}
}
```
With a generic method, you don't usually have to specify the parameter types. This is called *type argument inference*. Sometimes, it can simplify you life:
```java
public class New {
	public static <K,V> Map<K,V> map() {
		return new HashMap<K,V>();
	}
	public static <T> List<T> list() {
		return new ArrayList<T>();
	}
}
```
*Type inference doesn't work for anything other than assignment. If you pass the result of a method call such as **New.map()** as an argument to another method, the compiler will ot try to perform type inference. Instead it will treat the method call as though the return value is assigned to a variable of type **Object**.*?? ----- simon: The lastest SDK supports this.
To explicitly specify the type in a generic method, you place the type in angle brackets after the dot and immediately preceding the method name. When calling a method from within the same class, you must use **this** before the dot, and when working with **static** methods, you must use the class name before the dot.
```java
f(New.<Integer, List<Double>>map());
```

5. Generic methods and variable argument lists coexist nicely.
```java
public class GenericVarargs {
	public static <T> List<T> makeList(T... args) {
		List<T> result = new ArrayList<T>();
		for (T item : args) {
			result.add(item);
		}
		result result;
	}
}
```

6. *There's no information about generic parameter types available inside generic code.* Although you can say **ArrayList.class**, you cannot say **ArrayList<Integer>.class**. And,
```java
Class c1 = new ArrayList<String>().getClass();
Class c2 = new ArrayList<Integer>().getClass();
System.out.println(c1 == c2);  // true
```
```java
class Particle<P,M> {}
Particle<Long, Double> p = new Particle<Long, Double>();
System.out.println(Arrays.toString(p.getClass().getTypeParameters()));
```

7. Java generics are implemented using *erasure*. This means that any specific type information is erased when you use a generic. So **List<String>** and **List<Integer>** are the same type at run time. Both forms are "erased" to their raw type, **List**.
```java
class HasF {
	public void f() {}
}
class Manipulator<T> {
	private T obj;
	public Manipulator(T x) { obj = x; }
	// Error: cannot find symbol method f()
	public void call_f() { obj.f(); }
}
public class Manipulation {
	public static void main(String[] args) {
		HasF hf = new HasF();
		Manipulator<HasF> manipulator = new Manipulator<HasF>(hf);
		manipulator.call_f();
	}
}
```
In order to call f(), we must assist the generic class by giving it a *bound* that tells the compiler to only accept types that conform to that bound, as `class Manipulator2<T extends Hasf>`. A generic type parameter *erases to its first bound**. The compiler actually replaces the type parameter with its erasure, in this example, T erases to **HasF**. If a generic class has a method that returns T, it will return the exact type.

8. The generic types are present only during static type checking, after which every generic type in the program is erased by replacing it with a non-generic upper bound. For example, type annotations such as **List<T>** are erased to **List**, and ordinary type variables are erased to **Object** unless a bound is specified. Generic types cannot be used in operators that explicitly refer to runtime types, such as **casts**, **instanceof** operations, and **new** expressions.
```java
class GenericBase<T> {
  private T element;
  public void set(T arg) { arg = element; }
  public T get() { return element; }
}
class Derived1<T> extends GenericBase<T> {}
class Derived2 extends GenericBase {}
// unpected type found:
// class Derived3 extends GenericBase<?> {}
public class ErasureAndInheritance {
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    Derived2 d2 = new Derived2();
    Object obj = d2.get();
    d2.set(obj);  // warning
  }
}
```

9. Using **Array.newInstance()** is the recommended approach for creating arrays in generics.

10. Compensate for erasure:
```java
public class Erased<T> {
  private final int SIZE = 100;
  public static void f(Object arg) {
    if(arg instanceof T) {}  // Error
    T var = new T();         // Error
    T[] array = new T[SIZE]; // Error
    T[] array = (T)new Object[SIZE]; // Error
  }
}
```
If you introduce a type tag (**Class** object), a dynamic **isInstance()** can be used. The compiler ensures that the type tag matches the generic argument.

11. Because of erasure, the runtime type of the array can only be **Object[]**. If we immediately cast it to **T[]**, then at compile time the actual type of the array is lost, and the compiler may miss out on some potential error checks. It's better to use an **Object[]** inside the collection, and add a cast to T when you use an array element.
For new code, you should pass in a type token, such as:
```java
import java.lang.reflect.*;
public class GenericArrayWithTypeToken<T> {
  private T[] array;
  @SuppressWarnings("unchecked")
  public GenericArrayWithTypeToken(Class<T> type, int size) {
    array = (T[])Array.newInstance(type, size);
  }
  public void put(int index, T item) {array[index] = item;}
  public T get(int index) {return array[index];}
  public T[] rep() {return array;}
  public static void main(String[] args) {
    GenericArrayWithTypeToken<Integer> gai =
     new GenericArrayWithTypeToken<Integer>(Integer.class, 10);
     Integer[] ia = gai.rep();
  }
}
```

12. **extends** keyword has a significantly different meaning in the context of generic bounds than it does ordinarily.
```java
interface HasColor { java.awt.Color getColor(); }
class Dimension { public int x;}
// class must be first, then intefaces
class ColoredDemension<T extends Dimension & HasColor> { //...// }
interface Weight { int weight(); }
// As with inheritance, you can have only one concrete class but multiple interfaces
class Solid<T extends Dimension & HasColor & Weight> {
```
Note that wildcards are limited to a single bound:
```java
// Compiler error:
List<? extends SuperHearing & SuperSmell> dogboys;
```

13. You can assign an array of a derived type to an array reference of the base type.
```java
class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}
public class CovariantArrays {
  public static void main(String[] args) {
    Fruit[] fruit = new Apple[10];
    fruit[0] = new Apple();
    fruit[1] = new Jonathan();
    // ArrayStoreException
    // fruit[0] = new Fruit();
    // fruit[0] = new Orange();
    // Unlike array, generics don't have built-in covariance
    // Compiler Error: incompatible types
    // List<Fruit> flist = new ArrayList<Apple>();
    // It is OK
    List<? extends Fruit> flist2 = new ArrayList<Apple>();
  }
}
```

14. For generic class, use **Object** type as arguments for "safe" methods. To disallow a call when the type is used with wildcards, use the type parameter in the argument list.

15. *supertype wildcards*: you say that the wildcard is bounded by any base class of a particular class, by specifying **<? super MyClass>** or even using a type parameter: **<? super T>**. But you cannot give a generic parameter a supertype bound, that is, you cannot say **<T super MyClass**>. 

16. 