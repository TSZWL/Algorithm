package leetcode;

public class Solutionb152 {
	
	public static void main(String args[]){
		Solutionb152 s = new Solutionb152();
		int[] x = {-2, 0, -1};
		System.out.println(s.maxProduct(x));
	}
	public int maxProduct(int[] nums) {
		if (nums.length == 1) return nums[0];
		int head = 0, result = 0;
		while ((head < nums.length) && (nums[head] == 0)) head ++;
		while (head != nums.length){
			int now = 1, maxp = -1, minp = 1, maxn = Integer.MIN_VALUE, minn = 1;
			int pnum = 1, nnum = 0;
			while ((head != nums.length) && (nums[head] != 0)){
				now *= nums[head];
				if (now > 0){
					pnum ++;
					if (now > maxp) maxp = now;
					if (now < minp) minp = now;
				} else {
					nnum ++;
					if (now > maxn) maxn = now;
					if (now < minn) minn = now;	
				}
				head ++;
			}
			while ((head < nums.length) && (nums[head] == 0)) head ++;
			if (nnum > 1) result = Math.max(result, minn / maxn);
			if (pnum > 1) result = Math.max(result, maxp / minp);
		}
		return result;
	}
}