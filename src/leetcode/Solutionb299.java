package leetcode;

public class Solutionb299 {
	
	public static void main(String args[]){
		Solutionb299 s = new Solutionb299();
		System.out.println(s.getHint("1807", "7810"));
	}
	public String getHint(String secret, String guess) {
		char[] a = secret.toCharArray();
		char[] b = guess.toCharArray();
		int r1 = 0, r2 = 0;
		int[] c = new int[10], d = new int[10];
		for (int i = 0; i < a.length; i ++)
			if (a[i] == b[i]){
				r1 ++;
				a[i] = '#';
			}
		for (int i = 0; i < a.length; i ++)
			if (a[i] != '#'){
				c[a[i] - '0'] ++;
				d[b[i] - '0'] ++;
			}
		for (int i = 0; i < 10; i ++)
			r2 += Math.min(c[i], d[i]);
		return r1 + "A" + r2 + "B";
	}
}