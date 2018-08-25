package leetcode;

public class Solutionb115 {
	
	public static void main(String args[]){
		Solutionb115 s = new Solutionb115();
		System.out.println(s.numDistinct("rabbbit", "rabbit"));
	}
	public int numDistinct(String s, String t) {
		char[] a = s.toCharArray(), b = t.toCharArray();
		int result[] = new int[b.length + 1];
		result[0] = 1;
		for (int i = 0; i < a.length; i ++)
			for (int j = b.length - 1; j >= 0; j --)
				if (a[i] == b[j]) result[j + 1] += result[j];
		return result[b.length];
	}
}