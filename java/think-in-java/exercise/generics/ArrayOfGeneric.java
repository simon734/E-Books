class Generic<T> {}
public class ArrayOfGeneric {
	static final int SIZE = 100;
	static Generic<Integer>[] gia;
	// @SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// gia = (Generic<Integer>[])new Object[SIZE];
		gia = (Generic<Integer>[])new Generic<Integer>[SIZE];
		System.out.println(gia.getClass().getSimpleName());
		gia[0] = new Generic<Integer>();
		// gia[1] = (Generic<Integer>)new Object();
	}
}