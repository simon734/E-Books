import java.util.*;
public class SuperTypedWildcards {
	static void writeTo(List<? super Apple> apples) {
		apples.add(new Apple());
		apples.add(new Jonathan());
		// apples.add(new Fruit());
	}
}