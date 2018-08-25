package leetcode;

public class Solutionb376 {
	
	public static void main(String args[]){
		Solutionb376 s = new Solutionb376();
		int[] a = {1,7,4,9,2,5};
		System.out.println(s.wiggleMaxLength(a));
	}
	//晕死我了，单调队列？？？
	public int wiggleMaxLength(int[] nums) {
		if (nums.length == 0) return 0;
		int tail1 = 0, tail2 = 0, head1 = 0, head2 = 0;
		int[] l1 = new int[nums.length];
		int[] l2 = new int[nums.length];
		int[] h1 = new int[nums.length];
		int[] h2 = new int[nums.length];
		l1[0] = 1;
		l2[0] = 1;
		h1[0] = nums[0];
		h2[0] = nums[0];
		for (int i = 1; i < nums.length; i ++){
			while (head1 < tail1 && nums[i] < h1[head1 + 1]) head1 ++;
			if (nums[i] < h1[head1]){
				int l = l1[head1] + 1;
				while (head2 <= tail2 && nums[i] <= h2[tail2]) tail2 --;
				if (tail2 < head2 || l > l2[tail2]){
					tail2 ++;
					l2[tail2] = l;
					h2[tail2] = nums[i];
				}
			} else if (l1[head1] == 1) h1[head1] = nums[i];
			while (head2 < tail2 && nums[i] > h2[head2 + 1]) head2 ++;
			if (nums[i] > h2[head2]){
				int l = l2[head2] + 1;
				while (head1 <= tail1 && nums[i] >= h1[tail1]) tail1 --;
				if (tail1 < head1 || l > l1[tail1]){
					tail1 ++;
					l1[tail1] = l;
					h1[tail1] = nums[i];				
				}
			} else if (l2[head2] == 1) h2[head2] = nums[i];
		}
		return Math.max(l1[tail1], l2[tail2]);
	}
/*无论怎么上下移动，在一条只上或者只下的路径上一定最多选取2个点
 *后面那个点当然是这条路径的最后一个点，因为越靠下(上)越好
 *合并同上同下的路段，得到的拐弯数一定等于答案
	int m = nums.length;
    if(m == 0) return 0;
    int up = 1, down = 1;
    for(int i = 1; i < nums.length; i++){
        if(nums[i] > nums[i-1]){
            up = down+1;
        } else if(nums[i] < nums[i-1]){
            down = up+1;
        }
    }
    return Math.max(up, down);
*/
}