package leetcode;

public class Solutionb504 {
	
	public static void main(String args[]){
		Solutionb504 s = new Solutionb504();
		System.out.println(s.convertToBase7(-7));
	}
	public String convertToBase7(int num) {
		String x = num < 0 ? "-" : "", result = "";
		num = Math.abs(num);
		while (num != 0){
			result = num % 7 + result;
			num /= 7;
		}
		if (result.length() == 0) return "0";
		return x + result;
	}
}