package leetcode;

import java.util.*;

public class Solutionb726 {
	
	public static void main(String args[]){
		Solutionb726 s = new Solutionb726();
		System.out.println(s.countOfAtoms("K4(ON(SO3)2)2"));
	}
	//List<String> list = new ArrayList<>(map.keySet());
	//TreeMap 感觉比Hashmap慢一点点
	//Stack里面直接压map的话可以合并相同元素加快速度
	public String countOfAtoms(String formula) {
		Stack<Formula> s = new Stack<Formula>();
		char[] c = formula.toCharArray();
		for (int i = 0; i < c.length; )
			if (c[i] == '('){
				i ++;
				s.add(new Formula("(", 0));
			} else if (c[i] == ')') {
				int k = 0;
				while (++ i < c.length && c[i] >= '0' && c[i] <= '9') k = k * 10 + c[i] - '0';
				if (k == 0) k = 1;
				List<Formula> l = new ArrayList<Formula>();
				while (true){
					Formula x = s.pop();
					if (x.st.equals("(")) break;
					l.add(new Formula(x.st, x.num * k));
				}
				for (Formula x : l) s.add(x);
			} else {
				int k = 0;
				String x = c[i ++] + "";
				while (i < c.length && c[i] >= 'a' && c[i] <= 'z') x += c[i ++];
				while (i < c.length && c[i] >= '0' && c[i] <= '9') k = k * 10 + c[i ++] - '0';
				s.add(new Formula(x, k == 0 ? 1 : k));
			}
		Map<String, Integer> map = new TreeMap<String, Integer>();
		while (!s.isEmpty()){
			Formula x = s.pop();
			if (map.containsKey(x.st)) map.put(x.st, map.get(x.st) + x.num);
			else map.put(x.st, x.num);
		}
		String result = "";
		for (Iterator<String> it = map.keySet().iterator(); it.hasNext(); ){
			String x = it.next();
			int k = map.get(x);
			if (k == 1) result += x; else result += x + k;
		}
		return result;
	}
}
class Formula{
	String st;
	int num;
	Formula(String st, int num){
		this.st = st;
		this.num = num;
	}
}