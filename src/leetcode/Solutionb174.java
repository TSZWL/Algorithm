package leetcode;

public class Solutionb174 {
	
	public static void main(String args[]){
	}
	//直接从右下角倒推就可以了。。
	public int calculateMinimumHP(int[][] dungeon) {
		int head = Math.max(1, 1 - dungeon[0][0]), tail = Integer.MAX_VALUE / 2;
		while (head != tail){
			int mid = (head + tail) / 2;
			if (check(dungeon, mid)) tail = mid; else head = mid + 1;
		}
		return head;
	}
	private boolean check(int[][] dungeon, int mid) {
		int m = dungeon.length, n = dungeon[0].length;
		int[][] now = new int[m][n];
		now[0][0] = mid + dungeon[0][0];
		for (int i = 0; i < m; i ++)
			for (int j = 0; j < n; j ++)
				if (i != 0 || j != 0){
					if (i != 0 && now[i - 1][j] > 0) 
						now[i][j] = Math.max(now[i][j], now[i - 1][j] + dungeon[i][j]);
					if (j != 0 && now[i][j - 1] > 0) 
						now[i][j] = Math.max(now[i][j], now[i][j - 1] + dungeon[i][j]);
				}
		if (now[m - 1][n - 1] > 0) return true; else return false;
	}
}