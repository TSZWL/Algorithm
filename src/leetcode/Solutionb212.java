package leetcode;

import java.util.*;

public class Solutionb212 {
	
	public static void main(String args[]){
		Solutionb212 s = new Solutionb212();
		String[] a = {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};
		char[][] b = {{'a', 'b'}, {'c', 'd'}};
		List<String> r = s.findWords(b, a);
		for (String x : r) System.out.println(x);
	}
	public List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<String>();
		int m = board.length;
		if (m == 0) return result;
		int n = board[0].length;
		int[][] f = new int[52001][30];
		boolean[][] b = new boolean[m][n];
		int[] xx = {0, 0, 1, -1};
		int[] yy = {1, -1, 0, 0};
		int tot = 1;
		for (int i = 0; i < words.length; i ++){
			int l = 0;
			char[] c = words[i].toCharArray();
			for (int j = 0; j < c.length; j ++){
				if (f[l][c[j] - 'a'] == 0){
					f[l][c[j] - 'a'] = tot;
					f[l][27] ++;
					tot ++;
				}
				int fa = l;
				l = f[l][c[j] - 'a'];
				f[l][28] = fa;
				f[l][29] = c[j] - 'a';
			}
			f[l][26] = -1 - i;
		}
		Stack<Integer> q = new Stack<Integer>();
		for (int i = 0; i < m; i ++)
			for (int j = 0; j < n; j ++)
				if (f[0][board[i][j] - 'a'] != 0){
					q.push(f[0][board[i][j] - 'a']);
					q.push(j);
					q.push(i);
					q.push(1);
				}
		while (!q.empty()){
			int d = q.pop(), x = q.pop(), y = q.pop(), pos = q.pop();
			if (d == 1){
				if (f[pos][26] < 0){
					result.add(words[-1 - f[pos][26]]);
					f[pos][26] = 0;
					if (f[pos][27] == 0){
						int k1 = f[pos][28];
						int k2 = f[pos][29];
						f[k1][k2] = 0;
						f[k1][27] --;
						while (k1 != 0 && f[k1][27] == 0){
							k2 = f[k1][29];
							k1 = f[k1][28];
							f[k1][k2] = 0;
							f[k1][27] --;
						}
					}
				}
				b[x][y] = true;
				q.push(pos);
				q.push(y);
				q.push(x);
				q.push(0);
				for (int i = 0; i < 4; i ++){
					int x1 = x + xx[i];
					int y1 = y + yy[i];
					if (x1 >= 0 && y1 >= 0 && x1 < m && y1 < n && !b[x1][y1] 
							&& f[pos][board[x1][y1] - 'a'] != 0){
						q.push(f[pos][board[x1][y1] - 'a']);
						q.push(y1);
						q.push(x1);
						q.push(1);
					}
				}
			} else {
				b[x][y] = false;
			}
		}
		return result;
	}
/*
class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}
public TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String w : words) {
        TrieNode p = root;
        for (char c : w.toCharArray()) {
            int i = c - 'a';
            if (p.next[i] == null) p.next[i] = new TrieNode();
            p = p.next[i];
       }
       p.word = w;
    }
    return root;
}
    
public List<String> findWords(char[][] board, String[] words) {
    List<String> res = new ArrayList<>();
    TrieNode root = buildTrie(words);
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            dfs (board, i, j, root, res);
        }
    }
    return res;
}

public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
    char c = board[i][j];
    if (c == '#' || p.next[c - 'a'] == null) return;
    p = p.next[c - 'a'];
    if (p.word != null) {   // found one
        res.add(p.word);
        p.word = null;     // de-duplicate
    }

    board[i][j] = '#';
    if (i > 0) dfs(board, i - 1, j ,p, res); 
    if (j > 0) dfs(board, i, j - 1, p, res);
    if (i < board.length - 1) dfs(board, i + 1, j, p, res); 
    if (j < board[0].length - 1) dfs(board, i, j + 1, p, res); 
    board[i][j] = c;
}
*/
}