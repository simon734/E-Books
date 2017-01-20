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