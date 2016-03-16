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