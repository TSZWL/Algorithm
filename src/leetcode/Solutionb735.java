package leetcode;

import java.util.*;

public class Solutionb735 {
	
	public static void main(String args[]){
		Solutionb735 s = new Solutionb735();
		int[] a = {-2, -1, 1, 2};
		int[] r = s.asteroidCollision(a);
		for (int i = 0; i < r.length; i ++) System.out.println(r[i]);
	}
	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < asteroids.length; i ++)
			if (asteroids[i] > 0){
				s.add(asteroids[i]);
			} else {
				while (!s.isEmpty() && s.peek() > 0)
					if (s.peek() > -asteroids[i]){
						asteroids[i] = 0;
						break;
					} else if (s.peek() == -asteroids[i]){
						asteroids[i] = 0;
						s.pop();
						break;
					} else s.pop();
				if (asteroids[i] != 0) s.add(asteroids[i]);
			}
		int[] result = new int[s.size()];
		for (int i = result.length - 1; i >= 0; i --) result[i] = s.pop();
		return result;
	}
}
/*
public int[] asteroidCollision(int[] a) {
    LinkedList<Integer> s = new LinkedList<>(); // use LinkedList to simulate stack so that we don't need to reverse at end.
    for (int i = 0; i < a.length; i++) {
        if (a[i] > 0 || s.isEmpty() || s.getLast() < 0) //合理选择分类方法
            s.add(a[i]);
        else if (s.getLast() <= -a[i])
            if (s.pollLast() < -a[i]) i--;
    }
    return s.stream().mapToInt(i->i).toArray(); //JRE8 mapToInt
}
*/