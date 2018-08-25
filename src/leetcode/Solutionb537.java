package leetcode;

public class Solutionb537 {
	
	public static void main(String args[]){
		Solutionb537 s = new Solutionb537();
		System.out.println(s.complexNumberMultiply("1+-1i", "0+0i"));
	}
	public String complexNumberMultiply(String a, String b) {
		int i = a.indexOf("+"), j = b.indexOf("+");
		int c = Integer.parseInt(a.substring(0, i));
		int d = Integer.parseInt(a.substring(i + 1, a.length() - 1));
		int e = Integer.parseInt(b.substring(0, j));
		int f = Integer.parseInt(b.substring(j + 1, b.length() - 1));
		int p = c * e - d * f;
		int q = c * f + d * e;
		return p + "+" + q + "i";
	}
}