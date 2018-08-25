package Bs;

import java.util.*;
import java.util.Map.Entry;

public class Pdd4 {
	
	//1 8 8 7 7 2 3 4 5 6
	//实在是想不出来贪心能不能合理解了，当前程序错误在于在考虑权重的同时，还强迫必须从第一个元素开始队列
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		boolean[] b = new boolean[n];
		for (int i = 0; i < n; i ++) a[i] = sc.nextInt();
		sc.close();
		int tot = 0;
		for (int i = 0; i < n; i ++)
			if (!b[i]) {
				Map<Integer, Integer> js = new HashMap<Integer, Integer>();
				for (int j = 0; j < a.length; j ++)
					if (!b[j]) js.put(a[j], js.getOrDefault(a[j], 0) + 1);
				int maxVal = 0;
				for (Iterator<Entry<Integer, Integer>> it = js.entrySet().iterator(); it.hasNext(); ) {
					Entry<Integer, Integer> en = it.next();
					if (en.getValue() > maxVal) maxVal = en.getValue();
				}
				List<Integer> x1 = check(a, b, js, i, 1, maxVal);
				List<Integer> x2 = check(a, b, js, i, -1, maxVal);
				System.out.println(i +" "+x1.get(0) + " " + x2.get(0));
				if (x1.get(0) > x2.get(0)) {
					x1.remove(0);
					for (int j : x1) b[j] = true;
				} else {
					x2.remove(0);
					for (int j : x2) b[j] = true;
				}
				tot ++;
			}
		System.out.println(tot);
	}

	private static List<Integer> check(int[] a, boolean[] b, Map<Integer, Integer> js, int st, int mlt, int maxVal) {
		List<Integer> result = new ArrayList<Integer>();
		int max = 1, pos = st;
		int[] f = new int[a.length];
		int[] pre = new int[a.length];
		for (int i = 0; i < f.length; i ++) f[i] = Integer.MIN_VALUE;
		f[st] = 1;
		for (int i = st + 1; i < a.length; i ++)
			if (!b[i]) {
				for (int j = st; j < a.length; j ++)
					if (!b[j] && a[i] * mlt < a[j] * mlt)
						if (f[j] + 1 > f[i]) {
							f[i] = f[j] + 1;
							pre[i] = j;
						}
				if (js.get(a[i]) == maxVal) f[i] += 100;
				if (f[i] > max) {
					max = f[i];
					pos = i;
				}
			}
		result.add(max);
		result.add(st);
		while (pos != st) {
			result.add(pos);
			pos = pre[pos];
		}
		return result;
	}
}