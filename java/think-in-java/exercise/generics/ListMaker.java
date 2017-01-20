import java.util.*;
public class ListMaker<T> {
	List<T> create() { return new ArrayList<T>(); }
	public static void main(String[] args) {
		ListMaker<String> strMaker = new ListMaker<String>();
		List<String> strList = strMaker.create();
	}
}