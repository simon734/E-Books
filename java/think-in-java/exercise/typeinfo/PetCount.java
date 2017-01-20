import typeinfo.pets.*;
import java.util.*;
import static simon.util.Print.*;
public class PetCount {
	private static class Counter extends HashMap<String, Integer> {
		public void count(String type) {
			Integer quanlity = get(type);
			if (quanlity == null) {
				put(type, 1);
			} else {
				put(type, quanlity + 1);
			}
		}
	}
	public static void countPets(PetCreator creator) {
		Counter counter = new Counter();
		for (Pet pet : creator.createArray(20)) {
			printnb(pet.getClass().getSimpleName() + " ");
			if(pet instanceof Pet)
				counter.count("Pet");
			if(pet instanceof Dog)
				counter.count("Dog");
			if(pet instanceof Mutt)
				counter.count("Mutt");
			if(pet instanceof Pug)
				counter.count("Pug");
			if(pet instanceof Cat)
				counter.count("Cat");
			if(pet instanceof EgyptianMau)
				counter.count("EgyptianMau");
			if(pet instanceof Manx)
				counter.count("Manx");
			if(pet instanceof Cymric)
				counter.count("Cymric");
			if(pet instanceof Rodent)
				counter.count("Rodent");
			if(pet instanceof Mouse)
				counter.count("Mouse");
			if(pet instanceof Hamster)
				counter.count("Hamster");
		}
		print();
		print(counter);
	}
	public static void main(String[] args) {
		countPets(new ForNameCreator());
	}
}