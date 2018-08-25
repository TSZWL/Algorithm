package leetcode;

public class Solutionb458 {
	
	public static void main(String args[]){
	}
	//因为会死，2为底的指数函数->n+1为底的幂函数
	public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
		if (buckets < 2) return 0;
		int time = minutesToTest / minutesToDie + 1;
		int r = 1, tot = time;
		while (tot < buckets) {
			tot *= time;
			r ++;
		}
		return r;
	}
}