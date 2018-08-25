package leetcode;

public class Solutionb521 {
	
	public static void main(String args[]){
	}
	public int findLUSlength(String a, String b) {
		if (a.equals(b)) return -1;
		else return Math.max(a.length(), b.length());
	}
}