package testMulticast;

public class Counter {
	public static int comp;
	private static Counter instance;
	
	private Counter() {}
	
	public static Counter getInstance() {
		if(instance == null) {
			comp=0;
			return new Counter();
		}
		comp++;
		return instance;
	}
}
