package leetcode;

import java.util.*;

public class Solutionb720 {
	
	public static void main(String args[]){
	}
	//���ֵ������죬�Ͼ�����Ƶ����String����
	//���õĻ�ֱ������Ҳ�ͺ���ô����(�ֵ���
	public String longestWord(String[] words) {
		String r = "";
		Set<String> set = new HashSet<String>();
		Arrays.sort(words);
		for (String s : words) {
			String x = s.substring(0, s.length() - 1);
			if (x.length() == 0 || set.contains(x)) {
				set.add(s);
				if (s.length() > r.length()) r = s;
			}
		}
		return r;
	}
}