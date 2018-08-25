package leetcode;

public class Solution60 {
	
	public static void main(String args[]){
		Solution60 s = new Solution60();
		System.out.println(s.getPermutation(3, 4));
	}
	public String getPermutation(int n, int k) {
		boolean[] b = new boolean[n + 1];
		String result = "";
		int[] num = {0, 1, 2, 6, 24, 120, 720, 5040, 40320};
		for (int i = n - 1; i > 0; i --){
			int r = (k - 1) / num[i] + 1;
			k = (k - 1) % num[i] + 1;
			int t = 0;
			for (int j = 1; j <= n; j ++){
				if (!b[j]) t ++;
				if (t == r){
					b[j] = true;
					result += j;
					break;
				}
			}
		}
		for (int j = 1; j <= n; j ++)
			if (!b[j]) result += j;
		return result;
	}
}