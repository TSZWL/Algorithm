package help;

class X {
	int val = 0;
	X(int v) {
		val = v;
	}
}

class Test {
	
	String val = null;
	
	private void fc(X x) {
		x = new X(1);
	}
	
	public static void main(String[] args) {
		Test x = new Test();
		X y = new X(2);
		System.out.println(y.val);
		x.fc(y);
		System.out.println(y.val);
	}
}