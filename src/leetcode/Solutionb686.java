package leetcode;

public class Solutionb686 {
	
	public static void main(String args[]){
		Solutionb686 s = new Solutionb686();
		System.out.println(s.repeatedStringMatch("aa", "a"));
	}
	//�ֳ���1��2���������������
	//ֱ�ӿ��Ƿ���lengthAΪ����ѭ������
	public int repeatedStringMatch(String A, String B) {
		if (A.indexOf(B) != -1) return 1;
		if ((A + A).indexOf(B) != -1) return 2;
		int l = B.indexOf(A), result = 0;
		if (l == -1) return l;
		if (!A.endsWith(B.substring(0, l))) return -1;
		if (l != 0) result ++;
		B = B.substring(l);
		l = A.length();
		while (B.length() > l){
			if (!B.startsWith(A)) return -1;
			B = B.substring(l);
			result ++;
		}
		if (!A.startsWith(B)) return -1;
		return ++ result;
	}
}