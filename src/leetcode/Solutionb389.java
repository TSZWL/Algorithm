package leetcode;

public class Solutionb389 {
	
	public static void main(String args[]){
		Solutionb389 s = new Solutionb389();
		System.out.println(s.findTheDifference("asdasdzxc", "asdasdzxca"));
	}
	public char findTheDifference(String s, String t) {
		int x = 0;
		//char c : s.toCharArray()
		for (int i = 0; i < s.length(); i ++) x ^= s.charAt(i);
		for (int i = 0; i < t.length(); i ++) x ^= t.charAt(i);
		return (char)x;
	}
}