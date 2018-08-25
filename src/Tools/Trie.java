package Tools;

import java.util.*;

public class Trie {
	
	Node root = new Node();
	
	private class Node {
		int end;
		Node fail;
		Node[] next;
		Node(){
			end = 0;
			fail = null;
			next = new Node[26];
		}
	}
	
	public void insert(String word) {
		Node p = root;
		for (char c : word.toCharArray()) {
			int now = c - 'a';
			if (p.next[now] == null) p.next[now] = new Node();
			p = p.next[now];
		}
		p.end ++;
	}
	
	public void build_Fail() {
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(root);
		while (!list.isEmpty()) {
			Node now = list.poll(), pre = null;
			for (int i = 0; i < 26; i ++)
				if (now.next[i] != null) {
					pre = now.fail;
					while (pre != null && pre.next[i] == null) pre = pre.fail;
					now.next[i].fail = pre == null ? root : pre.next[i];
					list.add(now.next[i]);
				}
		}
	}
	
	public int get_Total(String word) {
		int result = 0;
		Node now = root;
		for (char c : word.toCharArray()) {
			int num = c - 'a';
			while (now.next[num] == null && now != root) now = now.fail;
			now = now.next[num];
			if (now == null) now = root;
			Node p = now;
			while (p != root) {
				result += p.end;
				p = p.fail;
			}
		}
		return result;
	}
	
	public int get_Num_Once(String word) {
		int result = 0;
		Node now = root;
		for (char c : word.toCharArray()) {
			int num = c - 'a';
			while (now.next[num] == null && now != root) now = now.fail;
			now = now.next[num];
			if (now == null) now = root;
			Node p = now;
			while (p != root && p.end >= 0) {
				result += p.end;
				p.end = -1;
				p = p.fail;
			}
		}
		return result;
	}
	
	public int get_Num_Recover(String word) {
		int result = 0;
		Node now = root;
		List<Node> list = new ArrayList<Node>();
		List<Integer> total = new ArrayList<Integer>();
		for (char c : word.toCharArray()) {
			int num = c - 'a';
			while (now.next[num] == null && now != root) now = now.fail;
			now = now.next[num];
			if (now == null) now = root;
			Node p = now;
			while (p != root && p.end >= 0) {
				list.add(p);
				total.add(p.end);
				result += p.end;
				p.end = -1;
				p = p.fail;
			}
		}
		for (int i = 0; i < list.size(); i ++) list.get(i).end = total.get(i);
		return result;
	}
	
	public static void main(String[] args) {
		Trie t = new Trie();
		//Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < 100000; i ++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < 32; j ++) sb.append((char) (Math.floor(Math.random() * 26) + 'a'));
			String word = sb.toString();
			System.out.println(word);
			//map.put(word, map.getOrDefault(word, 0) + 1);
			t.insert(word);
		}
		t.build_Fail();
		for (int i = 0; i < 100000; i ++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < 64; j ++) sb.append((char) (Math.floor(Math.random() * 26) + 'a'));
			String word = sb.toString();
			int x = 0, y = 0;
			/*for (int j = 0; j < 9; j ++) {
				x += map.getOrDefault(word.substring(j, j + 2), 0);
				map.put(word.substring(j, j + 2), 0);
			}*/
			y = t.get_Total(word);
			System.out.println(i + " " + x + " " + y);
			//if (x != y) break;
		}
	}
}
