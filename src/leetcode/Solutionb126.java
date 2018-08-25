package leetcode;

import java.util.*;

public class Solutionb126 {
	public static void main(String args[]){
		Solutionb126 s = new Solutionb126();
		List<String> a = new ArrayList<String>();
		a.add("hot");
		a.add("dot");
		a.add("dog");
		a.add("lot");
		a.add("log");
		a.add("cog");
		List<List<String>> r = s.findLadders("hit", "cog", a);
		for (List<String> l : r){
			for (String st : l) System.out.print(st + " ");
			System.out.println();
		}
	}
	//不建图，直接利用map广搜，效率会高很多
	//两边同时进行，先搜数量少的一边
	//直接改字符串里面的值，再在map里面找
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		String[] list = new String[10001];
		int[] x = new int[100001];
		int[] y = new int[100001];
		int[] q = new int[100001];
		int[] f = new int[100001];
		int[] next = new int[100001];
		int[] point = new int[10001];
		List<List<String>> result = new ArrayList<List<String>>();
		int lnum = 0, pnum = 3;
		list[1] = beginWord;
		list[2] = endWord;
		boolean has = false;
		for (String s : wordList){
			if (s.equals(endWord)) has = true;
			list[pnum] = s;
			pnum ++;
		}
		if (!has) return result;
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
		int[][] map = new int[pnum][200];
		int[] length = new int[pnum];
		while (head < tail){
			if (f[q[head]] == f[2]) break;
			int l = point[q[head]];
			while (l != 0){
				if (f[y[l]] >= f[x[l]] + 1){
					if (f[y[l]] > f[x[l]] + 1) length[y[l]] = 0;
					f[y[l]] = f[x[l]] + 1;
					map[y[l]][length[y[l]]] = x[l];
					length[y[l]] ++;
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
		List<String> now = new ArrayList<String>();
		now.add(list[2]);
		getPath(length, map, 2, now, result, list);
		return result;
	}
	private void getPath(int[] length, int[][] map, int x, 
			List<String> now, List<List<String>> result, String[] list) {
		if (x == 1){
			result.add(new ArrayList<String>(now));
			return;
		}
		for (int i = 0; i < length[x]; i ++){
			now.add(0, list[map[x][i]]);
			getPath(length, map, map[x][i], now, result, list);
			now.remove(0);
		}
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
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)){
            return res;
        }
        Map<String,List<String>> map = new HashMap<>();
        Set<String> set1 = new HashSet<>();
        set1.add(beginWord);
        Set<String> set2 = new HashSet<>();
        set2.add(endWord);
        bfs(set1,set2,map,dict, false);
        List<String> sol = new ArrayList<String>();
        sol.add(beginWord);
        generateList(beginWord,endWord,map,res,sol);
        return res;
        
    }
    
    private boolean bfs(Set<String> set1, Set<String> set2, Map<String, List<String>> map,Set<String>dict, boolean flip){
        if(set1.isEmpty()){
            return false;
        }
        
        if(set1.size() > set2.size()){
            return bfs(set2,set1,map,dict, !flip);
        }
        
        dict.removeAll(set1);
        dict.removeAll(set2);
        boolean done = false;
        Set<String> set = new HashSet<>();
        for(String str:set1){
            for(int i=0;i < str.length(); i++){
                char[] arr = str.toCharArray();
                for(char ch = 'a'; ch<='z'; ch++){
                    arr[i] = ch;
                    String word = new String(arr);
                    String key = flip? word:str;
                    String value = flip? str:word;
                    List<String> list = map.containsKey(key)? map.get(key): new ArrayList<>();
                    if(set2.contains(word)){
                        done = true;
                        list.add(value);
                        map.put(key,list);
                    }
                    
                    if(!done && dict.contains(word)){
                        set.add(word);
                        list.add(value);
                        map.put(key,list);
                    }
                }
            }
        }
        return done || bfs(set2, set,map,dict,!flip);
    }
    
    private void generateList(String start, String end, Map<String,List<String>> map, List<List<String>> res, List<String> sol){
        if(start.equals(end)){
            res.add(new ArrayList<String>(sol));
            return;
        }
        if(!map.containsKey(start)){
            return;
        }

        for(String str: map.get(start)){
            sol.add(str);
            generateList(str,end,map,res,sol);
            sol.remove(sol.size()-1);
        }

    }
}
*/
}