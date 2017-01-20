import typeinfo.factory.*;
import java.util.*;
class Part {
	static List<Factory<? extends Part>> partFactories = 
		new ArrayList<Factory<? extends Part>>();
	public String toString() { return getClass().getSimpleName(); }
	static {
		partFactories.add(new FuelFilter.Fact());
		partFactories.add(new AirFilter.Fact());
		partFactories.add(new CabinAirFilter.Fact());
		partFactories.add(new OilFilter.Fact());
		partFactories.add(new FanBelt.Fact());
		partFactories.add(new PowerSteeringBelt.Fact());
		partFactories.add(new GeneratorBelt.Fact());
	}
	private static Random rand = new Random();
	public static Part createRandom() {
		int n = rand.nextInt(partFactories.size());
		return partFactories.get(n).create();
	}
}
class Filter extends Part {}
class FuelFilter extends Filter {
	public static class Fact implements Factory<FuelFilter> {
		public FuelFilter create() { return new FuelFilter(); }
	}
}
class AirFilter extends Filter {
	public static class Fact implements Factory<AirFilter> {
		public AirFilter create() { return new AirFilter(); }
	}
}
class CabinAirFilter extends Filter {
	public static class Fact implements Factory<CabinAirFilter> {
		public CabinAirFilter create() { return new CabinAirFilter(); }
	}
}
class OilFilter extends Filter {
	public static class Fact implements Factory<OilFilter> {
		public OilFilter create() { return new OilFilter(); }
	}
}
class Belt extends Part{}
class FanBelt extends Belt {
	public static class Fact implements Factory<FanBelt> {
		public FanBelt create() { return new FanBelt(); }
	}
}
class GeneratorBelt extends Belt {
	public static class Fact implements Factory<GeneratorBelt> {
		public GeneratorBelt create() { return new GeneratorBelt(); }
	}
}
class PowerSteeringBelt extends Belt {
	public static class Fact implements Factory<PowerSteeringBelt> {
		public PowerSteeringBelt create() { return new PowerSteeringBelt(); }
	}
}
public class RegisteredFactories {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(Part.createRandom());
		}
	}
}