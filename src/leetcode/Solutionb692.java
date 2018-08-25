package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solutionb692 {
	
	public static void main(String args[]){
		Solutionb692 s = new Solutionb692();
		String[] a = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		List<String> r = s.topKFrequent(a, 4);
		for (String st : r) System.out.println(st);
	}
	public List<String> topKFrequent(String[] words, int k) {
		List<String> result = new ArrayList<String>();
		Map<String, Integer> m = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i ++)
			if (!m.containsKey(words[i])){
				m.put(words[i], 1);
			} else m.put(words[i], m.get(words[i]) + 1);
		PriorityQueue<No> q = new PriorityQueue<No>();
		for (Iterator<String> i = m.keySet().iterator(); i.hasNext(); ){
			String word = i.next();
			No n = new No(word, m.get(word));
			if (q.size() < k) q.add(n);
			else if (n.compareTo(q.peek()) > 0){
				q.poll();
				q.add(n);
			}
		}
		while (q.size() != 0){
			No n = q.poll();
			result.add(0, n.word);
		}
		return result;
	}
	private static class No implements Comparable<No>{
        String word;
        int number;
        No(String word, int number){
            this.word = word;
            this.number = number;
        }
        public int compareTo(No e) {
            if(this.number == e.number){
                return e.word.compareTo(this.word);
            } else return this.number - e.number;
        }
    }
}