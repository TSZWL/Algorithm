package leetcode;

public class Solutionb639 {
	
	public static void main(String args[]){
		Solutionb639 s = new Solutionb639();
		System.out.println(s.numDecodings("*1*2*12*21*1*2**82**1*8**1*2*12*12*238128"));
		System.out.println(s.numDecodings("*************"));
	}
	public int numDecodings(String s) {
		char[] c = s.toCharArray();
		int l = s.length();
		if (l == 0) return 0;
		long[] f = new long[l + 1];
		f[0] = 1;
		for (int i = 1; i <= l; i ++){
			if (c[i - 1] != '0'){
				if (c[i - 1] == '*') f[i] = (f[i - 1] * 9) % 1000000007;
				else f[i] = f[i - 1];
			}
			if (i > 1)
				if (c[i - 2] == '1'){
					if (c[i - 1] == '*') f[i] += (f[i - 2] * 9) % 1000000007;
					else f[i] += f[i - 2];
				} else if (c[i - 2] == '2'){
					if (c[i - 1] == '*') f[i] += (f[i - 2] * 6) % 1000000007;
					else if (c[i - 1] < '7') f[i] += f[i - 2];
				} else if (c[i - 2] == '*'){
					if (c[i - 1] == '*') f[i] += (f[i - 2] * 15) % 1000000007;
					else if (c[i - 1] < '7') f[i] += (f[i - 2] * 2) % 1000000007;
					else f[i] += f[i - 2];
				}
		}
		return (int)(f[l] % 1000000007);
	}
}