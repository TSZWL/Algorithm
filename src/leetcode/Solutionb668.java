package leetcode;

public class Solutionb668 {
	
	public static void main(String args[]){
		Solutionb668 s = new Solutionb668();
		System.out.println(s.findKthNumber(2, 3, 6));
	}
	public int findKthNumber(int m, int n, int k) {
		if (m > n){
			int p = m;
			m = n;
			n = p;
		}
		int head = 1, tail = m * n;
		while (head < tail){
			int mid = (head + tail) / 2;
			int[] num = sum(m, n, mid);
			if (num[0] >= k) tail = mid - 1;
			else if (num[1] > m * n - k) head = mid + 1;
			else return mid;
		}
		return head;
	}
	private int[] sum(int m, int n, int k) {
		int[] result = new int[]{0, 0};
		for (int i = 1; i <= m; i ++){
			int x = k / i;
			int y = k % i == 0 ? 1 : 0;
			if (x > n){
				result[0] += n;
			} else {
				result[0] += x - y;
				result[1] += n - x;
			}
		}
		return result;
	}
/* 完全可以不用每一行都做除法和取余运算
 * 如果倒三角一样一路往下逆推即可
    public int helper(int mid,int m,int n){
        int count=0,i=1;
        while(i<=n){
            if(i*m<=mid){ count+=m;i++;}
            else m--;
        }
        return count;
    }
*/

}