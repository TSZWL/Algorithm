package leetcode;

public class Solutionb275 {
	
	public static void main(String args[]){
		Solutionb275 s = new Solutionb275();
		int[] a = {1};
		System.out.println(s.hIndex(a));
	}
	//升序的话直接二分即可。。
	public int hIndex(int[] citations) {
		int head = 0, tail = citations.length - 1, n = citations.length;
		if (n == 0) return 0;
		while (head < tail){
			int mid = (head + tail) / 2;
			if (n - mid <= citations[mid]) tail = mid; else head = mid + 1;
		}
		return n - head <= citations[head] ? n - head : n - head - 1;
	}
}