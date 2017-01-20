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
			System.exit(0)；
		}
		int lines = 0;
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] methods = c.getMethods();
			Constructor[] ctors = c.getConstructors();
			if (args.length == 1) {
				for (Method method : methods) {
					System.out.println(
						p.matcher(method.toString()).replaceAll(""));
				}
				for (Constructor ctor : ctors) {
					System.out.println(
						p.matcher(ctor.toString()).replaceAll(""));
				}
				lines = methods.length + ctors.length;
			}
		} catch(ClassNotFountException e) {
			System.out.println("No such class: " + e);
		}
	}
}