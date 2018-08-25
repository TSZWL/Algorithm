package leetcode;

public class Solutionb165 {
	
	public static void main(String args[]){
		Solutionb165 s = new Solutionb165();
		System.out.println(s.compareVersion("1.0", "1"));
	}
	public int compareVersion(String version1, String version2) {
		String[] s1 = version1.split("\\.");
		String[] s2 = version2.split("\\.");
		int h1 = 0, h2 = 0;
		while (h1 < s1.length && h2 < s2.length){
			if (Integer.parseInt(s1[h1]) > Integer.parseInt(s2[h2])) return 1;
			if (Integer.parseInt(s1[h1]) < Integer.parseInt(s2[h2])) return -1;
			h1 ++;
			h2 ++;
		}
		while (h1 < s1.length && Integer.parseInt(s1[h1]) == 0) h1 ++;
		while (h2 < s2.length && Integer.parseInt(s2[h2]) == 0) h2 ++;
		if (h1 == s1.length && h2 == s2.length) return 0;
		if (h2 == s2.length) return 1;
		return -1;
	}
}