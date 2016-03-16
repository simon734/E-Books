import static simon.util.Print.*;
class Candy {
  static {  print("Loading Candy"); }
}
class Gum {
  static { print("Loading Gum"); }
}
class Cookie {
  static { print("Loading Cookie"); }
}
public class SweetShop {
  public static void main(String[] args) {
    print("Inside Main");
    new Candy();
    print("After creating Candy");
    try {
      Class.forName("Gum");
    } catch(ClassNotFoundException e) {
      print("Could't find Gum");
    }
    print("After Class.forName(\"Gum\")");
    new Cookie();
    print("After creating Cookie");
  }
}