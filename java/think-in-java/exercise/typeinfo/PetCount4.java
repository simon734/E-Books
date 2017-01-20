import simon.util.*;
import static simon.util.Print.*;
import typeinfo.pets.*;
public class PetCount4 {
	public static void main(String[] args) {
		TypeCounter counter = new TypeCounter(Pet.class);
		for (Pet pet : Pets.createArray(20)) {
			printnb(pet.getClass().getSimpleName() + " ");
			counter.count(pet);
		}
		print();
		print(counter);
	}
}