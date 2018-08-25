package leetcode;

public class Solutionb483 {
	
	public static void main(String args[]){
		Solutionb483 s = new Solutionb483();
		System.out.println(s.smallestGoodBase("15"));
		System.out.println(s.smallestGoodBase("4681"));
		System.out.println(s.smallestGoodBase("1000000000000000000"));
	}
	//枚举1的个数+二分查找答案
	public String smallestGoodBase(String n) {
		long x = Long.parseLong(n);
		for (int i = 2; i <= Math.floor(Math.log(x)/Math.log(2)); i ++){
			int head = 2, tail = (int)Math.floor(Math.sqrt(x));
			while (head <= tail){
				int mid = (head + tail) / 2;
				long t = 1;
				boolean b = false;
				for (int j = 0; j < i; j ++){
					if (x / t < mid){
						b = true;
						break;
					}
					t = t * mid + 1;
				}
				if (t == x) return mid + "";
				if (b || t > x) tail = mid - 1; else head = mid + 1;
			}
		}
		return (x - 1) + "";
	}
/*
 * 假设base是我们最终需要求的good base, k为进制转换后1的个数, 那么, 我们可以得到如下等式:
 * base^(k-1) + base^(k-2) + … + base^1 + base^0 = N             [1]
 * base^k + base^(k-1) + … + base^2 + base^1 = N * base
 * 因此, 我们可以得到:
 * base^k - base^0 = (base - 1) * N
 * N = (base^k - 1) / (base - 1)                                 [2]
 * 由[1], 可以得:
 * base ^ (k-1) < N < (base+1) ^ (k-1) … 多项式展开可证右边的不等号
 * base < (k-1)-th root of N < base + 1                          [3]
 * 根据[2]和[3], 我们可以通过遍历位数的方法得到最终答案
 */
}