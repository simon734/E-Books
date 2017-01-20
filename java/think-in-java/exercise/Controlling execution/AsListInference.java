package simon.util;

public class Print {
	public static void print(Object obj) {
		System.out.println(obj);
	}
	public static void print() {
		System.out.println();
	}
	public static void printnb(Object obj) {
		System.out.print(obj);
	}
	public static PrintStream print(String format, Object... args) {
		System.out.printf(format, args);
	}
}