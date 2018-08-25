package help;

import java.util.*;

class Number {
	private int num = 0;
	Number(int x){
		num = x;
	}
	int val() {
		return num;
	}
}

interface Sign {
	Number cal(Number a, Number b);
}

class Plus implements Sign {
	@Override
	public Number cal(Number a, Number b) {
		return new Number(a.val() + b.val());
	}
}

class Minus implements Sign {
	@Override
	public Number cal(Number a, Number b) {
		return new Number(a.val() - b.val());
	}
}

class Multiply implements Sign {
	@Override
	public Number cal(Number a, Number b) {
		return new Number(a.val() * b.val());
	}
}

class Division implements Sign {
	@Override
	public Number cal(Number a, Number b) {
		return new Number(a.val() / b.val());
	}
}

public class Calculate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] question = sc.nextLine().toCharArray();
		sc.close();
		//转后缀表达式
		List<Object> Expression = new ArrayList<>();
		Stack<Character> sign = new Stack<>();
		int now = 0;			//当前数字
		boolean flag = false;	//是否输入了数字
		for (int i = 0; i < question.length; i ++) {
			char c = question[i];
			if (c >= '0' && c <= '9') {
				flag = true;
				now = now * 10 + c - '0';
			} else {
				if (flag) {
					flag = false;
					Expression.add(new Number(now));
					now = 0;
				}
				if (c == '(') {
					sign.push(c);
					continue;
				} else if (c == ')') {
					while (sign.peek() != '(') Expression.add(getSign(sign.pop()));
					sign.pop();
					c = question[++ i];
				}
				if (!sign.isEmpty()) {
					char s = sign.peek();
					if (s != '(' && (c == '+' || c == '-' || s == '*' || s == '/')) {
						Expression.add(getSign(sign.pop()));
					}
				}
				sign.add(c);
			}
		}
		if (flag) Expression.add(new Number(now));
		while (!sign.isEmpty()) Expression.add(getSign(sign.pop()));
		
		//输出后缀表达式(验证)
		for (Object o : Expression) {
			if (o instanceof Number) {
				System.out.print(((Number) o).val() + " ");
			} else {
				System.out.print(o.getClass().getSimpleName() + " ");
			}
		}
		System.out.println();
		
		//计算后缀表达式
		Stack<Number> s = new Stack<>();
		for (Object o : Expression) {
			if (o instanceof Number) {
				s.push((Number) o);
			} else {
				Number a = s.pop();
				Number b = s.pop();
				s.push(((Sign) o).cal(b, a));
			}
		}
		System.out.println(s.peek().val());
	}
	
	private static Sign getSign(char c) {
		if (c == '+') return new Plus();
		if (c == '-') return new Minus();
		if (c == '*') return new Multiply();
		if (c == '/') return new Division();
		return null;
	}
}
