package leetcode;

public class Solutionb744 {
	
	public static void main(String args[]){
	}
	public char nextGreatestLetter(char[] letters, char target) {
		for (int i = 0; i < letters.length; i ++)
			if (letters[i] > target) return letters[i];
		return letters[0];
	}
}