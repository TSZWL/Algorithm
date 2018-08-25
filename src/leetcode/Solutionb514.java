package leetcode;

public class Solutionb514 {
	
	public static void main(String args[]){
		Solutionb514 s = new Solutionb514();
		System.out.println(s.findRotateSteps("edcba", "abcde"));
	}
	public int findRotateSteps(String ring, String key) {
		char[] c = ring.toCharArray();
		char[] k = key.toCharArray();
		int[][] f = new int[k.length + 1][c.length];
		for (int i = 0; i <= k.length; i ++)
			for (int j = 0; j < c.length; j ++) f[i][j] = Integer.MAX_VALUE;
		f[0][0] = 0;
		int p = c.length, result = Integer.MAX_VALUE;
		for (int i = 1; i <= k.length; i ++)
			for (int j = 0; j < c.length; j ++)
				if (c[j] == k[i - 1])
					for (int l = 0; l < c.length; l ++)
						if (f[i - 1][l] != Integer.MAX_VALUE)
							f[i][j] = Math.min(f[i][j], f[i - 1][l] 
									+ Math.min(Math.abs(j - l), p - Math.abs(j - l)));
		for (int i = 0; i < c.length; i ++)
			result = Math.min(result, f[k.length][i]);
		return result + k.length;
	}
}