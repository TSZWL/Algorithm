package leetcode;

public class Solutionb357 {
	public static void main(String args[]){
		Solutionb357 s = new Solutionb357();
		System.out.println(s.checkPerfectNumber(1));
	}
	public boolean checkPerfectNumber(int num) {
		if (num == 1) return false;
		int sum = 1;
		for (int i = 2; i < Math.floor(Math.sqrt(num)) + 1; i ++)
			if (num % i == 0){
				sum += i;
				int j = num / i;
				if (i != j) sum += j;
				if (sum > num) return false;
			}
		if (sum == num) return true;
		return false;
	}
}