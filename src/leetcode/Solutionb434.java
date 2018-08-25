package leetcode;

public class Solutionb434 {
	
	public static void main(String args[]){
		Solutionb434 s = new Solutionb434();
		System.out.println(s.countSegments("Hello,  my name is John"));
	}
	public int countSegments(String s) {
		int result = 0;
		String[] st = s.split(" ");
		for (int i = 0; i < st.length; i ++)
			if (st[i].length() != 0) result ++;
		return result;
	}
}