package leetcode;

public class Solutionb628 {
	
	public static void main(String args[]){
		Solutionb628 s = new Solutionb628();
		int[] a = {-1, -2, -3};
		System.out.println(s.maximumProduct(a));
	}
	//不需要考虑正负，只需要记录3个max和2个min
	//再比较max^3和max*min^2即可
	public int maximumProduct(int[] nums) {
		int[] a = new int[3];
		int[] b = new int[2];
		int[] c = new int[3];
		int an = 0, bn = 0, cn = 0;
		boolean d = false;
		for (int i = 0; i < nums.length; i ++)
			if (nums[i] > 0){
				for (int j = 0; j < an; j ++)
					if (a[j] < nums[i]){
						int n = a[j];
						a[j] = nums[i];
						nums[i] = n;
					}
				if (an < 3){
					a[an] = nums[i];
					an ++;
				}
			} else if (nums[i] < 0){
				int m = nums[i];
				for (int j = 0; j < bn; j ++)
					if (b[j] > nums[i]){
						int n = b[j];
						b[j] = nums[i];
						nums[i] = n;
					}
				if (bn < 2){
					b[bn] = nums[i];
					bn ++;
				}
				nums[i] = m;
				for (int j = 0; j < cn; j ++)
					if (c[j] < nums[i]){
						int n = c[j];
						c[j] = nums[i];
						nums[i] = n;
					}
				if (cn < 3){
					c[cn] = nums[i];
					cn ++;
				}
			} else d = true;
		if (an + cn < 3) return 0;
		if (an < 3 && bn < 2)
			if (d) return 0;
			else return a[0] * a[1] * b[0];
		if (an == 0)
			if (d) return 0;
			else return c[0] * c[1] * c[2];
		int result = Integer.MIN_VALUE;
		if (an == 3) result = Math.max(result, a[0] * a[1] * a[2]);
		if (bn == 2) result = Math.max(result, a[0] * b[0] * b[1]);
		return result;
	}
}