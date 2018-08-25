package leetcode;

import java.util.*;

public class Solutionb282 {
	
	public static void main(String args[]){
		Solutionb282 s = new Solutionb282();
		List<String> r = s.addOperators("1231231", 66);
		for (String x : r) System.out.println(x);
	}
	//找到合理表示连乘的方式就很简单了
	//cur = cur * 10 + x;
	public List<String> addOperators(String num, int target) {
		List<String> rst = new ArrayList<String>();
		if (num == null || num.length() == 0) return rst;
		helper(rst, "", num, target, 0, 0, 0);
		return rst;
	}
	public void helper(List<String> rst, String path, String num, int target, 
			int pos, long eval, long multed){
		if (pos == num.length()){
			if(target == eval) rst.add(path);
			return;
		}
		for (int i = pos; i < num.length(); i ++){
			if (i != pos && num.charAt(pos) == '0') break;
			long cur = Long.parseLong(num.substring(pos, i + 1));
			if (pos == 0) helper(rst, path + cur, num, target, i + 1, cur, cur);
			else{
				helper(rst, path + "+" + cur, num, target, i + 1, eval + cur, cur);
				helper(rst, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
				helper(rst, path + "*" + cur, num, target, i + 1, 
						eval - multed + multed * cur, multed * cur);
			}
		}
	}
/*大概是傻了。。。。。。。。
	Map<String, Map<Integer, Set<String>>> m = new HashMap<String, Map<Integer, Set<String>>>();
	char[] c;
	public List<String> addOperators(String num, int target) {
		List<String> result = new ArrayList<String>();
		c = num.toCharArray();
		int len = c.length;
		Integer[][] f = new Integer[len][len + 1];
		String[][] sub = new String[len][len + 1];
		for (int i = 0; i < len; i ++)
			for (int j = i + 1; j <= len; j ++){
				sub[i][j] = num.substring(i, j);
				if (Long.parseLong(sub[i][j]) <= Integer.MAX_VALUE)
					f[i][j] = Integer.parseInt(sub[i][j]);
			}
		Map<Integer, Set<String>> check = dfs(sub, f, num, 0, len);
		if (!check.containsKey((Integer)target)) return result;
		Set<String> t1 = check.get((Integer)target);
		for (String t : t1)
			if (t.length() != (target + "").length()) result.add(t);
		return result;
	}
	private Map<Integer, Set<String>> dfs(String[][] sub, Integer[][] f, String num, int x, int y) {
		if (m.containsKey(sub[x][y])){
			return m.get(sub[x][y]);
		}
		Map<Integer, Set<String>> r = new HashMap<Integer, Set<String>>();
		Set<String> t = new HashSet<String>();
		if ((x == y - 1 || c[x] != '0') && Long.parseLong(sub[x][y]) <= Integer.MAX_VALUE){
			t.add(sub[x][y]);
			r.put(f[x][y], t);
		}
		if (x == y - 1) return r;
		for (int i = x + 1; i < y; i ++){
			if (!(i < y - 1 && c[i] == '0' || i > x + 1 && c[x] == '0'))
				if (!r.containsKey(f[x][i] * f[i][y])){
					Set<String> t3 = new HashSet<String>();
					t3.add(sub[x][i] + "*" + sub[i][y]);
					r.put(f[x][i] * f[i][y], t3);
				} else {
					r.get(f[x][i] * f[i][y]).add(sub[x][i] + "*" + sub[i][y]);
				}
			Map<Integer, Set<String>> aa = dfs(sub, f, num, x, i);
			Map<Integer, Set<String>> bb = dfs(sub, f, num, i, y);
			for (Iterator<Integer> it1 = aa.keySet().iterator(); it1.hasNext(); ){
				Integer a = it1.next();
				for (Iterator<Integer> it2 = bb.keySet().iterator(); it2.hasNext(); ){
					Integer b = it2.next();
					Set<String> t1;
					if (!r.containsKey(a + b)){
						t1 = new HashSet<String>();
					} else {
						t1 = r.get(a + b);
					}
					Set<String> sa = aa.get(a);
					Set<String> sb = bb.get(b);
					for (String ta : sa)
						for (String tb : sb)
							if (!t1.contains(ta + "+" + tb)) t1.add(ta + "+" + tb);
					r.put(a + b, t1);
					
					Set<String> t2;
					if (!r.containsKey(a - b)){
						t2 = new HashSet<String>();
					} else {
						t2 = r.get(a - b);
					}
					for (String ta : sa)
						for (String tb : sb){
							tb = tb.replace("+", "?");
							tb = tb.replace("-", "+");
							tb = tb.replace("?", "-");
							if (!t2.contains(ta + "-" + tb)) t2.add(ta + "-" + tb);
						}
					r.put(a - b, t2);
					
					Set<String> t6;
					if (!r.containsKey(a * b)){
						t6 = new HashSet<String>();
					} else {
						t6 = r.get(a * b);
					}
					for (String ta : sa)
						for (String tb : sb)
							if (!ta.contains("+") && !ta.contains("-") && !tb.contains("+") 
									&& !tb.contains("-") && 
									!t6.contains(ta + "*" + tb)) t6.add(ta + "*" + tb);
					if (t6.size() != 0) r.put(a * b, t6);
				}
			}
		}
		m.put(sub[x][y], r);
		return r;
	}
*/
}