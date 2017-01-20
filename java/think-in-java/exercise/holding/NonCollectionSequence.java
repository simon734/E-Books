import java.util.*;
class PetSequence {
	protected Integer[] pets = {1, 2, 3, 4};
}
public class NonCollectionSequence extends PetSequence {
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			private int index = 0;
			public boolean hasNext() {
				return index < pets.length;
			}
			public Integer next() { return pets[index++]; }
			public void remove() { // Not implemented
				throw new UnsupportedOperationException();
			}
		};
	}
}