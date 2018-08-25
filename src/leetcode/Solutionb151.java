package leetcode;

public class Solutionb151 {
	public static void main(String args[]){
	}
	public String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		String[] st = s.split(" ");
		for (int i = st.length - 1; i >= 0; i --)
			if (st[i].length() != 0) sb.append(" ").append(st[i]);
		return sb.length() == 0 ? "" : sb.substring(1).toString();
	}
}