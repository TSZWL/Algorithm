package leetcode;

public class Solutionb443 {
	
	public static void main(String args[]){
		Solutionb443 s = new Solutionb443();
		char[] a = {'a','a','b','b','c','c','c'};
		System.out.println(s.compress(a));
	}
	public int compress(char[] chars) {
		if (chars.length == 0) return 0;
		char now = chars[0];
		int total = 1, r = 0;
		for (int i = 1; i < chars.length; i ++)
			if (chars[i] != now) {
				chars[r ++] = now;
				now = chars[i];
				if (total != 1)
					for (char x : Integer.toString(total).toCharArray()) chars[r ++] = x;
				total = 1;
			} else total ++;
		chars[r ++] = now;
		if (total != 1)
			for (char x : Integer.toString(total).toCharArray()) chars[r ++] = x;
		return r;
	}
}