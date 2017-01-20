import java.io.*;
public class InputFile {
  private BufferedReader in;
  public InputFile(String fname) throws Exception {
    try {
      in = new BufferedReader(new FileReaader(fname));
    } catch(FileNotFoundException e) {
      throw e;
    } catch(Exception e) {
      // All other exceptions must close it
      try {
        in.close();
      } catch(IOException e2) {
        //
      }
      throw e;
    } finally {
      // Don't close the file here.
    }
  }
  public String getLine() {
      String s;
      try {
        s = in.readLine();
      }
  }
  public void dispose() {}
}