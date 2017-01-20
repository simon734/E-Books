interface Service {}

interface ServiceFactory {
	Service getService();
}

class Implementation1 implements Service {
	private Implementation1() {}
	public static ServiceFactory factory = 
		new ServiceFactory {
			public Service getService() {
				return new Implementation1();
			}
		}
}