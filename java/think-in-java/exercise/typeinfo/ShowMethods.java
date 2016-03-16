import java.lang.reflect.*;
import java.util.regex.*;
 class ShowMethods {
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
			System.exit(0);
		}
		try {
			boolean has_filter = (args.length > 1);
			Class<?> c = Class.forName(args[0]);
			Method[] methods = c.getMethods();
			Constructor[] ctors = c.getConstructors();
			for (Method method : methods) {
				if (has_filter &&
					method.toString().indexOf(args[1]) == -1) {
					continue;
				}
				System.out.println(method.toString());
				System.out.println(
					p.matcher(method.toString()).replaceAll(""));
			}
			for (Constructor ctor : ctors) {
				if (has_filter &&
					ctor.toString().indexOf(args[1]) == -1) {
					continue;
				}
				System.out.println(ctor.toString());
				System.out.println(
					p.matcher(ctor.toString()).replaceAll(""));
			}
		} catch(ClassNotFoundException e) {
			System.out.println("No such class: " + e);
		}
	}
}