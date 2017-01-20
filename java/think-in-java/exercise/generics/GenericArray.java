public class GenericArray<T> {
	private T[] array;
	@SuppressWarnings("unchecked")
	public GenericArray(int size) {array = (T[])new Object[size];}
	public T get(int index) {return array[index];}
	public void set(T item, int index) {array[index] = item;}
	public T[] rep() {return array;}
	public static void main(String[] args) {
		GenericArray<Integer> gai = new GenericArray<Integer>(10);
		// Integer[] ia = gai.rep();
		Object[] oa = gai.rep();
	}

}