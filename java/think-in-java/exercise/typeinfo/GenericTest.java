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