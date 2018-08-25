package leetcode;

public class Solutionb278 {
	public static void main(String args[]){
		Solutionb278 s = new Solutionb278();
		System.out.println(s.firstBadVersion(2126753390));
	}
	public int firstBadVersion(int n) {
		long head = 1, tail = n;
		while (head < tail){
			long mid = (head + tail) / 2;
			if (isBadVersion((int)mid)) tail = mid; else head = mid + 1;
		}
		return (int)head;
	}
	boolean isBadVersion(int version){
		if (version < 1702766719) return false; else return true;
	}
}