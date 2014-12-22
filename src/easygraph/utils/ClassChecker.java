package easygraph.utils;

public class ClassChecker {
	
	private static Class<?>[] wrappers = null;
	
	static {
		wrappers = new Class[]{
			Boolean.class, Integer.class, Character.class, String.class,
			Byte.class, Short.class, Double.class, Long.class, Float.class
		};
	}
	
	public static boolean isDisplayable(Object obj) {
		return obj == null ? false : ClassChecker.isDisplayable(obj.getClass());
	}

	
	public static boolean isDisplayable(Class<?> clazz) {
		if (clazz.isPrimitive()) {
			return true;
		}
		for (Class<?> c : wrappers) {
			if (c.equals(clazz)) {
				return true;
			}
		}
		return false;
	}

}
