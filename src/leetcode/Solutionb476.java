package leetcode;

public class Solutionb476 {
	
	public static void main(String args[]){
		Solutionb476 s = new Solutionb476();
		System.out.println(s.findComplement(2));
	}
	public int findComplement(int num) {
		int result = 0, c = 0;
		int[] b = new int[40];
		while (num != 0){
			b[c] = num & 1;
			num = num >> 1;
			c ++;
		}
		for (int i = c - 1; i >= 0; i --) result = result * 2 + 1 - b[i]; 
		return result;
	}
}