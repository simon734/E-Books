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
