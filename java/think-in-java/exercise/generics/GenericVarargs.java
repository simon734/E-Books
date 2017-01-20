import java.util.*;
public class GenericVarargs {
	public static <T> List<T> makeList(T... args) {
		List<T> result = new ArrayList<T>();
		for (T item : args) {
			result.add(item);
		}
		result result;
	}
	public static void main(String[] args) {
		List<String> ls = makeList("A");
		
	}
}