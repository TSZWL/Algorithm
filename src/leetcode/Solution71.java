package leetcode;

public class Solution71 {
	
	public static void main(String args[]){
		Solution71 s = new Solution71();
		System.out.println(s.simplifyPath("/abc/..."));
	}
	public String simplifyPath(String path) {
		String[] s = path.split("/");
		String[] q = new String[s.length];
		int tail = 0;
		for (int i = 0; i < s.length; i ++)
			if (s[i].equals(".")) continue;
			else if (s[i].equals("..")){
				if (tail > 0) tail --;
			} else if (s[i].length() == 0) continue;
			else {
				q[tail] = s[i];
				tail ++;
			}
		String result = "";
		for (int i = 0; i < tail; i ++)
			result += "/" + q[i];
		return result == "" ? "/" : result;
	}
}