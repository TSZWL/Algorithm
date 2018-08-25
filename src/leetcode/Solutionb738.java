package leetcode;

public class Solutionb738 {
	
	public static void main(String args[]){
		Solutionb738 s = new Solutionb738();
		System.out.println(s.monotoneIncreasingDigits(332));
	}
	public int monotoneIncreasingDigits(int N) {
		char[] c = ("" + N).toCharArray();
		int flag = 0;
		for (int i = 0; i < c.length - 1; i ++)
			if (c[i] > c[i + 1]){
				c[flag] --;
				for (int j = flag + 1; j < c.length; j ++) c[j] = '9';
			} else if (c[i] < c[i + 1]) flag = i + 1;
		return Integer.parseInt(new String(c));
	}
}