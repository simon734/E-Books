import java.lang.reflect.*;
import java.util.*;
public class ArrayMaker<T> {
	private Class<T> kind;
	public ArrayMaker(Class<T> kind) { this.kind = kind; }
	@SuppressWarnings("unchecked")
	T[] create(int size) {return (T[])Array.newInstance(kind,size);}
	public static void main(String[] args) {
		ArrayMaker<String> strings = new ArrayMaker<String>(String.class);
		String[] strArray = strings.create(9);
		System.out.println(Arrays.toString(strArray));
	}
}