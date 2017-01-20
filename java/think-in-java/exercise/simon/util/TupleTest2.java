import simon.util.*;
import static simon.util.Tuple.*;
public class TupleTest2 {
	static TwoTuple<String, Integer> f() {
		return tuple("hi", 36);
	}
	static TwoTuple f2() { return tuple("hi", 36); }
	static ThreeTuple<Amphibian, String, Integer> g() {
		return tuple(new Amphibian(), "hi", 36);
	}
	static FourTuple<Vehicle, Amphibian, String, Integer> h() {
		return tuple(new Vehicle(), new Amphibian(), "hi", 36);
	}
	static FiveTuple<Vehicle, Amphibian,String,Integer,Double> k() {
		return tuple(new Vehicle(), new Amphibian(), "hi", 36, 1.1);
	}
	public static void main(String[] args) {
		TwoTuple<String,Integer> ttsi = f();
		System.out.println(ttsi);
		System.out.println(f2());
		System.out.println(g());
		System.out.println(h());
		System.out.println(k());
	}
}