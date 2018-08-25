package leetcode;

public class Solutionb413 {
	
	public static void main(String args[]){
		Solutionb413 s = new Solutionb413();
		int[] a = {1, 2, 3, 4};
		System.out.println(s.numberOfArithmeticSlices(a));
	}
	public int numberOfArithmeticSlices(int[] A) {
		int l = 0, result = 0;
		for (int i = 2; i < A.length; i ++){
			if (A[i] + A[i - 2] == A[i - 1] * 2) l ++; else l = 0;
			result += l;
		}
		return result;
	}
/*¿´´íÌâ
		Map<String, Integer> m = new HashMap<String, Integer>();
		for (int i = 1; i < A.length; i ++)
			for (int j = 0; j < i; j ++){
				int num = 1;
				String key = A[i] + " " + (A[i] - A[j]);
				String key2 = A[j] + " " + (A[i] - A[j]);
				if (m.containsKey(key)) num += m.get(key);
				if (m.containsKey(key2)) num += m.get(key2);
				System.out.println(key+" "+num);
				m.put(key, num);
			}
		int l = A.length, result = -l * (l - 1) / 2;
		for (Iterator<String> i = m.keySet().iterator(); i.hasNext(); )
			result += m.get(i.next());
		return result;
 */
}