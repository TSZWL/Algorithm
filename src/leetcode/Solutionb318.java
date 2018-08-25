package leetcode;

public class Solutionb318 {
	public static void main(String args[]){
		Solutionb318 s = new Solutionb318(); 
		String[] a = {};
		System.out.println(s.maxProduct(a));
	}
	public int maxProduct(String[] words) {
		int[] f = new int[words.length];
		for (int i = 0; i < words.length; i ++){
			boolean[] b = new boolean[26];
			for (char c : words[i].toCharArray()) b[c - 'a'] = true;
			for (int j = 0; j < 26; j ++){
				f[i] = f[i] << 1;
				if (b[j]) f[i] ++;
			}
		}
		int result = 0;
		for (int i = 1; i < words.length; i ++)
			for (int j = 0; j < i; j ++)
				if ((f[i] & f[j]) == 0)
					result = Math.max(result, words[i].length() * words[j].length());
		return result;
	}
}