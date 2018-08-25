package leetcode;

public class Solutionb374 {
	public static void main(String args[]){
		Solutionb374 s = new Solutionb374();
		System.out.println(s.guessNumber(2126753390));
	}
	public int guessNumber(int n) {
		long head = 1, tail = n;
		while (head < tail){
			long mid = (head + tail) / 2;
			if (guess((int)mid) <= 0) tail = mid; else head = mid + 1;
		}
		return (int)head;
	}
	int guess(int num){
		if (num == 1702766719) return 0;
		if (num < 1702766719) return 1; else return -1;
	}
}