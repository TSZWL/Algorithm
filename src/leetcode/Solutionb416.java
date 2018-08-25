package leetcode;

public class Solutionb416 {
	public static void main(String args[]){
		Solutionb416 s = new Solutionb416();
		int[] a = {1,5,11,5};
		System.out.println(s.canPartition(a));
	}
	//DP����b[1-now][j]=b[now][j+nums[i]]||b[now][j-nums[i]]
	//ֱ���ۼӿ��ܲ��ܴﵽtot��һ�������
	public boolean canPartition(int[] nums) {
		if (nums.length == 0) return true;
		boolean[][] b = new boolean[2][10000];
		int now = 0, tot = 0;
		for (int i = 0; i < nums.length; i ++) tot += nums[i];
		if ((tot & 1) == 1) return false;
		tot = tot >> 1;
		for (int i = 0; i < nums.length; i ++){
			if (nums[i] > tot) return false;
			b[1 - now][0] = true;
			if (b[now][tot - nums[i]]) return true;
			for (int j = 1; j < nums[i]; j ++) b[1 - now][j] = b[now][j];
			for (int j = nums[i]; j < tot; j ++) b[1 - now][j] = b[now][j] || b[now][j - nums[i]];
			now = 1 - now;
		}
		return false;
	}
}
/*��������״̬���ܶ�ĸо�������DFS���찡
 *������DFS���پͲ����ù��������ʡ�ռ��ˡ���
public boolean dfs(int[] nums, int target, int sum, int index) {
	if (sum == target) {
	    return true;
	}
	for (int i = index; i < nums.length; i++) {
	    if (sum + nums[i] > target) {
	        break;
	    }
	    if (dfs(nums, target, sum + nums[i], i + 1)) {
	        return true;
	    }
	}
	return false;
}
*/