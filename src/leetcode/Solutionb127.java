package leetcode;

import java.util.*;

public class Solutionb127 {
	public static void main(String args[]){
		Solutionb127 s = new Solutionb127();
		List<String> a = new ArrayList<String>();
		a.add("hot");
		a.add("dot");
		a.add("dog");
		a.add("lot");
		a.add("log");
		a.add("cog");
		System.out.println(s.ladderLength("hit", "cog", a));
	}
	//不建图，直接利用map广搜，效率会高很多
	//两边同时进行，先搜数量少的一边
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		String[] list = new String[10001];
		int[] x = new int[100001];
		int[] y = new int[100001];
		int[] q = new int[100001];
		int[] f = new int[100001];
		int[] next = new int[100001];
		int[] point = new int[10001];
		int lnum = 0, pnum = 3;
		list[1] = beginWord;
		list[2] = endWord;
		boolean has = false;
		for (String s : wordList){
			if (s.equals(endWord)) has = true;
			list[pnum] = s;
			pnum ++;
		}
		if (!has) return 0;
		for (int i = 1; i < pnum - 1; i ++)
			for (int j = i + 1; j < pnum; j ++)
				if (check(list[i], list[j])){
					lnum ++;
					x[lnum] = i;
					y[lnum] = j;
					next[lnum] = point[x[lnum]];
					point[x[lnum]] = lnum;
					lnum ++;
					x[lnum] = j;
					y[lnum] = i;
					next[lnum] = point[x[lnum]];
					point[x[lnum]] = lnum;
				}
		boolean[] b = new boolean[pnum];
		int head = 0, tail = 1;
		q[head] = 1;
		b[1] = true;
		for (int i = 2; i < pnum; i ++) f[i] = Integer.MAX_VALUE;
		while (head < tail){
			if (f[q[head]] == f[2]) break;
			int l = point[q[head]];
			while (l != 0){
				if (f[y[l]] >= f[x[l]] + 1){
					f[y[l]] = f[x[l]] + 1;
					if (!b[y[l]]){
						b[y[l]] = true;
						q[tail] = y[l];
						tail ++;
					}
				}
				l = next[l];
			}
			head ++;
		}
		return f[2] == Integer.MAX_VALUE ? 0 : f[2] + 1;
	}
	private boolean check(String a, String b) {
		int l = 0;
		for (int i = 0; i < a.length(); i ++)
			if (a.charAt(i) != b.charAt(i)){
				l ++;
				if (l > 1) return false;
			}
		if (l == 1) return true; else return false;
	}
/*
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> s1 = new HashSet<String>();
        Set<String> s2 = new HashSet<String>();
        Set<String> dict = new HashSet<String>(wordList);
        s1.add(beginWord);
        s2.add(endWord);
        if (!dict.contains(endWord)) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }
        dict.remove(endWord);
        return twoEndBfs(s1, s2, dict, 2);
    }
    
    private int twoEndBfs(Set<String> s1, Set<String> s2, Set<String> dict, int len) {
        if (s1.isEmpty() || s2.isEmpty()) {
            return 0;
        }
        if (s1.size() > s2.size()) {
            return twoEndBfs(s2, s1, dict, len);
        }
        Set<String> temp = new HashSet<String>();
        for (String word : s1) {
            char[] charArr = word.toCharArray();
            for (int i = 0; i < charArr.length; i++) {
                char ch = charArr[i];
                for (char newCh = 'a'; newCh <= 'z'; newCh++) {
                    charArr[i] = newCh;
                    String newWord = String.valueOf(charArr);
                    if (s2.contains(newWord)) {
                        return len;
                    }
                    
                    if (dict.contains(newWord)) {
                        temp.add(newWord);
                        dict.remove(newWord);
                    }
                }
                charArr[i] = ch;
            }
        }
        return twoEndBfs(temp, s2, dict, len + 1);
    }
*/
}