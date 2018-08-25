package leetcode;

public class Solutionb552 {
	
	public static void main(String args[]){
		Solutionb552 s = new Solutionb552();
		System.out.println(s.checkRecord(12345));
	}
	public int checkRecord(int n) {
		long[][] f = new long[n + 1][6];
		f[0][0] = 1;
		for (int i = 1; i <= n; i ++){
			f[i][0] = (f[i - 1][0] + f[i - 1][1] + f[i - 1][2]) % 1000000007;
			f[i][1] = f[i - 1][0];
			f[i][2] = f[i - 1][1];
			f[i][3] = (f[i][0] + f[i - 1][3] + f[i - 1][4] + f[i - 1][5]) % 1000000007;
			f[i][4] = f[i - 1][3];
			f[i][5] = f[i - 1][4];
		}
		return (int)((f[n][0] + f[n][1] + f[n][2] + f[n][3] + f[n][4] + f[n][5]) % 1000000007);
	}
}