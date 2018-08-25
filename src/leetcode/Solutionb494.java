package leetcode;

public class Solutionb494 {
	
	public static void main(String args[]){
		Solutionb494 s = new Solutionb494();
		int[] x = {1, 1, 1, 1, 1};
		System.out.println(s.findTargetSumWays(x, 3));
	}
	//��ֱ���ۼӼ���sum���ټ��㻹��Ҫ�����٣�f[n]��ʾ��n�ķ�������ʱ�併Ϊsum*nums���ռ併Ϊsum
	public int findTargetSumWays(int[] nums, int S) {
		int[][] f = new int[22][2001];
		S += 1000;
		if ((S < 0) || (S > 2000)) return 0;
		f[0][1000] = 1;
		for (int i = 1; i <= nums.length; i ++)
			for (int j = 0; j < 2001; j ++){
				if (j - nums[i - 1] >= 0) f[i][j] += f[i - 1][j - nums[i - 1]];
				if (j + nums[i - 1] < 2001) f[i][j] += f[i - 1][j + nums[i - 1]];
			}
		return f[nums.length][S];
	}
}