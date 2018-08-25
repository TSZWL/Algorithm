package leetcode;

public class Solutionb657 {
	
	public static void main(String args[]){
		Solutionb657 s = new Solutionb657();
		System.out.println(s.judgeCircle("LL"));
	}
	public boolean judgeCircle(String moves) {
		int x = 0, y = 0;
		for (int i = 0; i < moves.length(); i ++)
			if (moves.charAt(i) == 'U') x ++;
			else if (moves.charAt(i) == 'D') x --;
			else if (moves.charAt(i) == 'L') y ++;
			else if (moves.charAt(i) == 'R') y --;
		if (x == 0 && y == 0) return true;
		return false;
	}
}