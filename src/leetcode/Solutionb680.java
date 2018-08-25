package leetcode;

public class Solutionb680 {
	
	public static void main(String args[]){
		Solutionb680 s = new Solutionb680();
		System.out.println(s.validPalindrome("amanaplana,canal:panama"));
	}
	public boolean validPalindrome(String s) {
		return dfs(0, s.length() - 1, true, s);
	}
	private boolean dfs(int i, int j, boolean b, String s) {
		while (i < j){
			if (s.charAt(i) != s.charAt(j))
				if (!b) return false;
				else return dfs(i + 1, j, false, s) || dfs(i, j - 1, false, s);
			i ++;j --;
		}
		return true;
	}
}