class Building {}
class House extends Building {}
public class ClassCasts {
  public static void main(String[] args) {
    Building b = new House();
    House h = House.class.cast(b);
  }
}