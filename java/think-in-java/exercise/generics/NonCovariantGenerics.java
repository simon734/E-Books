import java.util.*;
public class NonCovariantGenerics {
	//List<Fruit> flist = new ArrayList<Apple>();
	List<? extends Fruit> flist = new ArrayList<Apple>();
}