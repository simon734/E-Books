public class TestTypeCounter extends HashMap<Class<?>, Integer> {
	private Class<?> baseType;
	public TestTypeCounter(Class<?> baseType) {
		this.baseType = baseType;
	}
	public void count(Object obj) {
		Class<?> type = obj.getClass();
		if (baseType.isAssignableFrom(type)) {
			throw new RuntimeException(obj + " incorrect type: "
				+ type + ", should be type or subtype of " + baseType);
		}
		countClass(type);
	}
	private void countClass(Class<?> type) {
		Integer quanlity = get(type);
		put(type, quanlity==null ? 1 : quanlity+1);
		Class<?> superClass = type.getSupperclass();
		if (superClass != null &&
			baseType.isAssignableFrom(superClass)) {
			countClass(superClass);
		}
	}
}