package leetcode;

public class Solutionb387 {
	
	public static void main(String args[]){
		Solutionb387 s = new Solutionb387();
		String st = "loveleetcode";
		System.out.println(s.firstUniqChar(st));
	}
	//Ҳ�������ַ�����ѭ���������ַ�λ�ã�������ͬ��Ч��O(26)
	public int firstUniqChar(String s) {
		for (int i = 0; i < s.length(); i ++)
			if (i == s.lastIndexOf(s.charAt(i)) && i == s.indexOf(s.charAt(i))) return i;
		return -1;
	}
}