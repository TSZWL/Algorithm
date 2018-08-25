package leetcode;

public class Solutionb306 {
	
	public static void main(String args[]){
		Solutionb306 s = new Solutionb306();
		System.out.println(s.isAdditiveNumber("121474836472147483648"));
	}
	public boolean isAdditiveNumber(String num) {
		int l = num.length();
		char[] c = num.toCharArray();
		for (int i = 1; i < l - 1; i ++)
			for (int j = i + 1; j < l; j ++)
				if ((c[0] != '0' || i == 1) && (c[i] != '0' || 
				j == i + 1) && ((c[j] != '0') || j == l - 1)) {
					long a = Long.parseLong(num.substring(0, i));
					long b = Long.parseLong(num.substring(i, j));
					String x = num.substring(j);
					while (x.startsWith(a + b + "")){
						long n = a + b;
						x = x.substring((n + "").length());
						a = b;
						b = n;
					}
					if (x.equals("")) return true;
				}
		return false;
	}
}