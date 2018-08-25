package leetcode;

public class Solutionb383 {
	
	public static void main(String args[]){
	}
	public boolean canConstruct(String ransomNote, String magazine) {
		char[] a = ransomNote.toCharArray();
		char[] b = magazine.toCharArray();
		int[] f = new int[200];
		for (int i = 0; i < b.length; i ++) f[b[i]] ++;
		for (int i = 0; i < a.length; i ++) f[a[i]] --;
		for (int i = 'a'; i <= 'z'; i ++)
			if (f[i] < 0) return false;
		return true;
	}
}