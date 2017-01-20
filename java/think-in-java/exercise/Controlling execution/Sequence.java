class Wrapping {
	private int i;
	public Wrapping(int x) { i = x; }
	public int value() { return i; }
}

public class Parcel {
	public Wrapping wrapping(int x) {
		return new Wrapping(x) {  // Pass constructor argument
			public int value() {
				return super.value() * 36;
			}
		};
	}

	public static void main(String[] args) {
		Parcel p = new Parcel();
		Wrapping w = p.wrapping(10);
	}
}