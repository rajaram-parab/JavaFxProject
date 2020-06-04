public class MethodOverloading {

	int sum(int a, int b) {
		System.out.println(a + b);
		return a + b;
	}

	public void sum(double a, double b) {
		System.out.println(a + b);
	}

	double sum(int a, int b, int c) {
		System.out.println(a + b);
		return a + b;
	}

	public static void main(String[] args) {

		MethodOverloading object = new MethodOverloading();
		object.sum(20, 20);
		object.sum(15.1, 15.3);
		object.sum(20, 15, 50);
	}

}
