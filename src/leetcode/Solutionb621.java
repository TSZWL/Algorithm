package leetcode;

public class Solutionb621 {
	
	public static void main(String args[]){
		Solutionb621 s = new Solutionb621();
		char[] a = {'A','A','A','B','B','B'};
		System.out.println(s.leastInterval(a, 2));
	}
	public int leastInterval(char[] tasks, int n) {
		int[] f = new int[26];
		for (int i = 0; i < tasks.length; i ++) f[tasks[i] - 'A'] ++;
		int max = 0, num = 0;
		for (int i = 0; i < 26; i ++) max = Math.max(max, f[i]);
		for (int i = 0; i < 26; i ++)
			if (max == f[i]) num ++;
		int result = (n + 1) * (max - 1) + num;
		return Math.max(result, tasks.length);
	}
}