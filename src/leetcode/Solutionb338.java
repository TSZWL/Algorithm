package leetcode;

public class Solutionb338 {
	
	public static void main(String args[]){
		Solutionb338 s = new Solutionb338();
		int[] x = s.countBits(5);
		for (int i = 0;i < x.length; i ++) System.out.println(x[i]);
	}
	//...由0-2^n-1直接确定2^n-2^(n+1)-1
	public int[] countBits(int num) {
		int[] result = new int[num + 1];
		result[0] = 0;
		int now = 1, count = (int)Math.floor(Math.log10(num) / Math.log10(2));
		for (int i = 0; i < count; i ++){
			for (int j = 0; j < now; j ++) result[now + j] = result[j] + 1;
			now = now << 1;
		}
		for (int j = 0; j <= num - now; j ++) result[now + j] = result[j] + 1;
		return result;
	}
}