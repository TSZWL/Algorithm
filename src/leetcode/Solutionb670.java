package leetcode;

public class Solutionb670 {
	
	public static void main(String args[]){
		Solutionb670 s = new Solutionb670();
		System.out.println(s.maximumSwap(2736));
		System.out.println(s.maximumSwap(9973));
	}
	public int maximumSwap(int num) {
		char[] c = (num + "").toCharArray();
		for (int i = 0; i < c.length - 1; i ++)
			for (int j = i + 1; j < c.length; j ++){
				char n = c[i];c[i] = c[j];c[j] = n;
				num = Math.max(num, Integer.parseInt(String.valueOf(c)));
				n = c[i];c[i] = c[j];c[j] = n;
			}
		return num;
	}
}