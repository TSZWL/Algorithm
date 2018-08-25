package leetcode;

public class Solutionb459 {
	
	public static void main(String args[]){
		Solutionb459 s = new Solutionb459();
		System.out.println(s.repeatedSubstringPattern("abcabcdabcabc"));
	}
	//��������kmp�㷨�������
	public boolean repeatedSubstringPattern(String s) {
		for (int i = 1; i <= s.length() / 2; i ++)
			if (s.length() % i == 0){
				boolean b = true;
				String st = s.substring(0, i);
				for (int j = 1; j < s.length() / i; j ++)
					if (!s.substring(j * i, j * i + i).equals(st)){
						b = false;
						break;
					}
				if (b) return b;
			}
		return false;
	}
/*
 * ����xλ���ܶ�Ӧ˵��Ϊ����x��ѭ��..
	int[] prefix = kmp(str);
	int len = prefix[str.length()-1];
	int n = str.length();
	return (len > 0 && n%(n-len) == 0);
*/
}