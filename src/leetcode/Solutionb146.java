package leetcode;

import java.util.*;

//或者通过双向链表储存key值使用顺序
//再通过hashmap记录key值对应的DoubleLinkedNode S460
class LRUCache {

	int head, tail, tot;
	int[] q;
	Map<Integer, int[]> map;
	public LRUCache(int capacity) {
		head = 0;
		tail = -1;
		q = new int[10001];
		map = new HashMap<Integer, int[]>();
		tot = capacity;
	}
    
	public int get(int key) {
    	if (!map.containsKey(key)) return -1;
    	else {
    		int[] x = map.get(key);
    		x[1] ++;
    		map.put(key, x);
    		tail ++;
    		q[tail] = key;
    		return x[0];
    	}
	}
    
	public void put(int key, int value) {
		int[] x = new int[2];
		if (map.containsKey(key)) x = map.get(key);
		else if (tot > 0) tot --;
		else {
			while (true){
				int[] y = map.get(q[head]);
				if (y[1] == 1){
					map.remove(q[head]);
					head ++;
					break;
				}
				y[1] --;
				map.put(q[head], y);
				head ++;
			}
		}
		x[0] = value;
		x[1] ++;
		tail ++;
		q[tail] = key;
		map.put(key, x);
	}
}