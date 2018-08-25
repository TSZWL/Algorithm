package leetcode;

public class Solutionb557 {
	
	public static void main(String args[]){
		Solutionb557 s = new Solutionb557();
		System.out.println(s.reverseWords("Let's take LeetCode contest"));
	}
	//String+=和charAt 。。改用char[](要不一直超时)
	public String reverseWords(String s) {
		char[] c = s.toCharArray();
		int k = 0;
		for (int i = 0; i <= c.length; i ++){
			if (i == c.length || c[i] == ' '){
				for (int j = k; j < (k + i) / 2; j ++){
					char h = c[j];
					c[j] = c[k + i - 1 - j];
					c[k + i - 1 - j] = h;
				}
				k = i + 1;
			}
		}
		return new String(c);
	}
}