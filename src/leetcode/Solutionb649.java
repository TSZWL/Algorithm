package leetcode;

public class Solutionb649 {
	
	public static void main(String args[]){
		Solutionb649 s = new Solutionb649();
		System.out.println(s.predictPartyVictory("RRDDD"));
	}
	//直接模拟就行了。。
	public String predictPartyVictory(String senate) {
		char[] c = (" " + senate).toCharArray();
		int l = 1, now = c.length;
		int[] f = new int[now];
		int[] r = new int[now];
		while (true){
			f[0] = r[l - 1];
			r[0] = f[0];
			l = now;
			now = 1;
			for (int i = 1; i < l; i ++)
				if (c[i] == 'R') f[i] = f[i - 1] + 1; else f[i] = f[i - 1] - 1;
			for (int i = 1; i < l; i ++){
				if (c[i] == 'R'){
					r[i] = r[i - 1] + 1;
					if (f[i] > 0){
						c[now] = 'R';
						now ++;
					}
				} else {
					r[i] = r[i - 1] - 1;
					if (f[i] < 0){
						c[now] = 'D';
						now ++;
					}
				}
			}
			if (f[l - 1] >= l - 1) return "Radiant";
			if (f[l - 1] <= 1 - l) return "Dire";
		}
	}
}