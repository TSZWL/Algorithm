package leetcode;

public class Solutionb500 {
	
	public static void main(String args[]){
		Solutionb500 s = new Solutionb500();
		String[] st = {"Hello", "Alaska", "Dad", "Peace"};
		String[] r = s.findWords(st);
		for (int i = 0; i < r.length; i ++) System.out.println(r[i]);
	}
	public String[] findWords(String[] words) {
		String[] t = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
		boolean[] b = new boolean[words.length];
		int num = 0;
		for (int i = 0; i < words.length; i ++)
			if (check(words[i], t)){
				b[i] = true;
				num ++;
			}
		String[] result = new String[num];
		num = 0;
		for (int i = 0; i < words.length; i ++)
			if (b[i]){
				result[num] = words[i];
				num ++;
			}
		return result;
	}
	private boolean check(String st, String[] t) {
		boolean x = false;
		st = st.toLowerCase();
		for (int j = 0; j < 3; j ++)
			for (int l = 0; l < t[j].length(); l ++)
				if (st.contains(t[j].charAt(l) + ""))
					if (x) return false;
					else {
						x = true;
						break;
					}
		return true;
	}
}