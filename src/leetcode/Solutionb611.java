package leetcode;

public class Solutionb611 {
	
	public static void main(String args[]){
		Solutionb611 s = new Solutionb611();
		int[] nums = {2, 2, 3, 4};
		System.out.println(s.triangleNumber(nums));
	}
	//ѡ�����ֵi����0��i-1���м�ѹ�������result
	//O(m ^ 2) -> O(n ^ 2)
	//����ֵ����ĵĽϳ��÷���g
	public int triangleNumber(int[] nums) {
		int[] count = new int[1001];
		int[] total = new int[1001];
		int result = 0;
		for (int i = 0; i < nums.length; i ++) count[nums[i]] ++;
		total[0] = count[0];
		for (int i = 1; i < 1001; i ++) total[i] = total[i - 1] + count[i];
		for (int i = 1; i < 1001; i ++)
			if (count[i] > 2) result += count[i] * (count[i] - 1) * (count[i] - 2) / 6;
		for (int i = 1; i < 1001; i ++)
			if (count[i] > 1)
				result += count[i] * (count[i] - 1) / 2 * (total[i * 2 - 1] - total[i] + total[i - 1] - total[0]);
		for (int i = 1; i < 999; i ++)
			if (count[i] > 0)
				for (int j = i + 1; j < 1000; j ++)
					if (count[j] > 0)
						result += count[i] * count[j] * (total[Math.min(1000, i + j - 1)] - total[j]);
		return result;
	}
}