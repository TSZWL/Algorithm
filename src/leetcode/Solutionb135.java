package leetcode;

public class Solutionb135 {
	
	public static void main(String args[]){
		Solutionb135 s = new Solutionb135();
		int[] a = {5,4,4,3,2,2,1};
		System.out.println(s.candy(a));
	}
	public int candy(int[] ratings) {
		int now = 1, result = 0;
		int[] r = new int[ratings.length];
		r[0] = 1;
		for (int i = 1; i < ratings.length; ){
			if (ratings[i] > ratings[i - 1]){
				while (i < ratings.length && ratings[i] > ratings[i - 1]){
					now ++;
					r[i] = now;
					i ++;
				}
			} else if (ratings[i] < ratings[i - 1]){
				int k = i - 1;
				while (i < ratings.length && ratings[i] < ratings[i - 1]){
					now ++;
					i ++;
				}
				for (int j = i - 1; j > k; j --) r[j] = i - j;
				r[k] = Math.max(r[k], now);
			} else {
				r[i] = 1;
				i ++;
			}
			now = 1;
		}
		for (int i = 0; i < ratings.length; i ++) result += r[i];
		return result;
	}
}