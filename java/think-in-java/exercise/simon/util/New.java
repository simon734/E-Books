package simon.util;
import typeinfo.pets.*;
import java.util.*;
public class New {
	public static <K,V> Map<K,V> map() {
		return new HashMap<K,V>();
	}
	public static <T> List<T> list() {
		return new ArrayList<T>();
	}
	public static <T> LinkedList<T> lList() {
		return new LinkedList<T>();
	}
	public static <T> Set<T> set() {
		return new HashSet<T>();
	}
	public static <T> Queue<T> queue() {
		return new LinkedList<T>();
	}
	static void f(Map<Integer, List<? extends Pet>> petPeople) {
		System.out.println(petPeople.getClass().getName());
	}

	public static void main(String[] args) {
		Map<String, List<String>> sls =  New.map();
		List<String> ls = New.list();
		LinkedList<String> lls = New.lList();
		Set<String> ss = New.set();
		Queue<String> qs = New.queue();
		f(New.map());
	}
}