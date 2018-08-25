package leetcode;

public class Solutionb520 {
	
	public static void main(String args[]){
		Solutionb520 s = new Solutionb520();
		System.out.println(s.detectCapitalUse("Sasdas"));
	}
	//toCharArray可能可以提高效率
	public boolean detectCapitalUse(String word) {
		if (word.charAt(0) >= 'a'){
			for (int i = 1; i < word.length(); i ++)
				if (word.charAt(i) < 'a') return false;
			return true;
		} else {
			int n = 0;
			for (int i = 1; i < word.length(); i ++)
				if (word.charAt(i) < 'a') n ++;
			if (n == 0 || n == word.length() - 1) return true;
			return false;
		}
	}
}