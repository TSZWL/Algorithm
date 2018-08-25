package leetcode;

public class Solutionb507 {
	public static void main(String args[]){
		Solutionb507 s = new Solutionb507();
		System.out.println(s.countNumbersWithUniqueDigits(10) - 8877691);
	}
	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0) return 1;
		int result = 10, now = 9;
		for (int i = 1; i < n; i ++){
			now *= 10 - i;
			result += now;
		}
		return result;
	}
}