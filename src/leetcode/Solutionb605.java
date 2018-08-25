package leetcode;

public class Solutionb605 {
	
	public static void main(String args[]){
		Solutionb605 s = new Solutionb605();
		int[] a = {1, 0, 0, 0, 1};
		System.out.println(s.canPlaceFlowers(a, 2));
	}
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (n == 0) return true;
		int result = 0;
		for (int i = 0; i < flowerbed.length; i ++)
			if (check(flowerbed, i)){
				flowerbed[i] = 1;
				result ++;
				if (result == n) return true;
			}
		return false;
	}
	private boolean check(int[] flowerbed, int i) {
		if (flowerbed[i] == 1) return false;
		if (i != 0 && flowerbed[i - 1] == 1) return false;
		if (i != flowerbed.length - 1 && flowerbed[i + 1] == 1) return false;
		return true;
	}
}