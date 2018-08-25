package leetcode;

public class Solutionb365 {
	
	public static void main(String args[]){
		Solutionb365 s = new Solutionb365();
		System.out.println(s.canMeasureWater(1, 2, 3));
	}
	//gcd(x,y)һ��������ax+by��ʾ
	//������ax+by�ܱ�ʾ����С��������
	//����Ͱ��ˮһ���ܵ�����ax+by����ϣ���Ϊab������ͬ�ţ�����ͺ�����ʵ����
	public boolean canMeasureWater(int x, int y, int z) {
		if (z > x + y) return false;
		if (x * y == 0){
			if (z == x || z == y || z == x + y) return true;
			return false;
		}
		return z % gcd(x, y) == 0 ? true : false;
	}
	private int gcd(int a, int b){
		if (a % b == 0) return b;
		return gcd(b, a % b);
	}
/*
	public boolean canMeasureWater(int x, int y, int z) {
		boolean[] b = new boolean[Math.max(x, y) + 1];
		if (z == 0) return true;
		b[x] = true;
		b[y] = true;
		Stack<Integer> l = new Stack<Integer>();
		l.add(x);
		l.add(y);
		while (!l.isEmpty()){
			int n = l.pop();
			if (n == z || n + x == z || n + y == z) return true;
			if (n > x && !b[n - x]){
				l.push(n - x);
				b[n - x] = true;
			}
			if (n > y && !b[n - y]){
				l.push(n - y);
				b[n - y] = true;
			}
			if (x > n && !b[x - n]){
				l.push(x - n);
				b[x - n] = true;
			}
			if (y > n && !b[y - n]){
				l.push(y - n);
				b[y - n] = true;
			}
		}
		return false;
	}
*/
}