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