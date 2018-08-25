package leetcode;

public class Solutionb696 {
	
	public static void main(String args[]){
		Solutionb696 s = new Solutionb696();
		System.out.println(s.countBinarySubstrings("10101"));
	}
	public int countBinarySubstrings(String s) {
		char[] c = s.toCharArray();
		int len = 1, last = 0, result = 0;
		for (int i = 1; i < c.length; i ++)
			if (c[i] == c[i - 1]){
				len ++;
			} else {
				result += Math.min(len, last);
				last = len;
				len = 1;
			}
		return result + Math.min(len, last);
	}
/*？？？还要0和1在一起	
	public int countBinarySubstrings(String s) {
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		char[] c = s.toCharArray();
		int sum = 0, result = 0;
		m.put(0, 1);
		for (int i = 0; i < c.length; i ++){
			if (c[i] == '0') sum --; else sum ++;
			if (m.containsKey(sum)) m.put(sum, m.get(sum) + 1);
			else m.put(sum, 1);
		}
		Collection<Integer> t = m.values();
		for (int x : t) result += x * (x - 1) / 2;
		return result;
	}
*/
}