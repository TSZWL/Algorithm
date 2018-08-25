package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solutionb128 {
	
	public static void main(String args[]){
		Solutionb128 s = new Solutionb128();
		int[] nums = {100, 4, 4, 200, 1, 3, 2};
		System.out.println(s.longestConsecutive(nums));
	}
	//ʹ��map����ռ�洢����
	//ʹ����������չ�ķ����������ʱ������
	public int longestConsecutive(int[] nums) {
		if (nums.length == 0) return 0;
		int max = Integer.MIN_VALUE;
		Map<Integer, Boolean> f = new HashMap<Integer, Boolean>();
		for (int i = 0; i < nums.length; i ++) f.put(nums[i], true);
		for (int i = 0; i < nums.length; i ++)
			if (f.get(nums[i])){
				f.put(nums[i], false);
				int a = nums[i] - 1, b = nums[i] + 1;
				while (f.containsKey(a)){
					f.put(a, false);
					a --;
				}
				while (f.containsKey(b)){
					f.put(b, false);
					b ++;
				}
				if (b - a - 1 > max) max = b - a - 1;
			}
		return max;
	}
}