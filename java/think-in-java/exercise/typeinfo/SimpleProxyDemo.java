import static simon.util.Print.*;
interface Interface {
	void dosomething();
	void somethingElse(String arg);
}
class RealObject implements Interface {
	public void dosomething() { print("dosomething"); }
	public void somethingElse(String arg) {print("somethingElse " + arg);}
}
class SimpleProxy implements Interface {
	private Interface proxied;
	public SimpleProxy(Interface proxied) { this.proxied = proxied; }
	public void dosomething() {
		print("SimpleProxy dosomething");
		proxied.dosomething();
	}
	public void somethingElse(String arg) {
		print("SimpleProxy somethingElse" + arg);
		proxied.somethingElse(arg);
	}
}
class SimpleProxyDemo {
	public static void consumer(Interface iface) {
		iface.dosomething();
		iface.somethingElse("bonobo");
	}
	public static void main(String[] args) {
		consumer(new RealObject());
		consumer(new SimpleProxy(new RealObject()));
	}
}
