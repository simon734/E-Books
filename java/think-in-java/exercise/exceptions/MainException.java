import java.io.*;
public class MainException {
  public static void main(String[] args) throws Exception {
    FileInputStream file = new FileInputStream("MainException.java");
    file.close();
  }
}