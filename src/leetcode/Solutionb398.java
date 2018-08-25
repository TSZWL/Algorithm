package leetcode;

import java.util.*;

class Solution_2 {

	private Map<Integer, List<Integer>> map;
	private Random r = new Random();
    public Solution_2(int[] nums) {
        map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.length; i ++) {
        	if (!map.containsKey(nums[i])) map.put(nums[i], new ArrayList<Integer>());
        	map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> x = map.get(target);
        return x.get(r.nextInt(x.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
/*
public int pick(int target) {
	int count = 0;
	int result = 0;
	for(int i = 0; i < nums.length; ++ i) {
		if (nums[i] != target) continue;
		//一共n个，第x个概率为1/x*x/x+1*x+1/x+2*...*n-1/n
		if (random.nextInt(++ count) == 0) result = i;
	}
	return result;
}
*/