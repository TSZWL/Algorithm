package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solutionb315 {
	
	public static void main(String args[]){
		Solutionb315 s = new Solutionb315();
		int[] a = {5, 2, 6, 1};
		List<Integer> r = s.countSmaller(a);
		for (int i : r) System.out.println(i);
	}
	//归并排序合并的时候计算逆序对个数(加一个位置变量
	//或者利用树状数组/二叉树维护value(离散化
	public List<Integer> countSmaller(int[] nums) {
		int[] result = new int[nums.length];
		int[] pos = new int[nums.length];
		for (int i = 0; i < nums.length; i ++) pos[i] = i;
		sort(nums, pos, result, 0, nums.length - 1);
		List<Integer> r = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i ++) r.add(result[i]);
		return r;
	}
	private void sort(int[] nums, int[] pos, int[] result, int a, int b) {
		if (a >= b) return;
		int t = (a + b) / 2;
		sort(nums, pos, result, a, t);
		sort(nums, pos, result, t + 1, b);
		int[] l = new int[b - a + 1];
		int i = a, j = t + 1, n = 0;
		while (n <= b - a)
			if (i > t){
				l[n ++] = pos[j ++];
			} else if (j > b || nums[pos[i]] <= nums[pos[j]]){
				l[n ++] = pos[i ++];
				result[pos[i - 1]] += j - t - 1;
			} else {
				l[n ++] = pos[j ++];
			}
		for (int k = 0; k <= b - a; k ++) pos[a + k] = l[k];
	}
}
/*离散化+树状数组
public class Solution {
    private void sort(int[] nums, int[] pos, int from, int to) {
        if (from>=to) return;
        int m = (from+to)/2;
        sort(nums, pos, from, m);
        sort(nums, pos, m+1, to);
        int[] merged = new int[to-from+1];
        int i=from, j=m+1, p=0;
        while (i<=m || j<=to) {
            if (i>m) {
                merged[p++] = pos[j++];
            } else if (j>to) {
                merged[p++] = pos[i++];
            } else if (nums[pos[i]] <= nums[pos[j]]) {
                merged[p++] = pos[i++];
            } else {
                merged[p++] = pos[j++];
            }
        }
        for(int k=0; k<merged.length; k++) pos[from+k] = merged[k];
    }
    private int count(int[] sum, int s) {
        int count = 0;
        while (s>0) {
            count += sum[s];
            s -= (s & -s);
        }
        return count;
    }
    private void update(int[] sum, int s) {
        while (s<sum.length) {
            sum[s] ++;
            s += (s & -s);
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int[] pos = new int[nums.length];
        for(int i=0; i<nums.length; i++) pos[i] = i;
        sort(nums, pos, 0, nums.length-1);
        int[] seq = new int[nums.length];
        for(int i=0, s=0; i<pos.length; i++) {
            if (i==0 || nums[pos[i]] != nums[pos[i-1]]) seq[pos[i]] = ++ s; else seq[pos[i]] = s;
        }
        int[] sum = new int[nums.length+1];
        int[] smaller = new int[nums.length];
        for(int i=nums.length-1; i>=0; i--) {
            smaller[i] = count(sum, seq[i]-1);
            update(sum, seq[i]);
        }
        List<Integer> result = new ArrayList<>(nums.length);
        for(int i=0; i<smaller.length; i++) result.add(smaller[i]);
        return result;
    }
}*/
/*二叉树
public class Solution {
    private int smaller(int[] tree, int[] smaller, int value) {
        int sum = 0;
        int i=0, j=tree.length-1;
        while (i<=j) {
            int m = (i+j)/2;
            if (tree[m] <= value) {
                sum += smaller[m];
                i = m + 1;
            } else {
                smaller[m] ++;
                j = m - 1;
            }
        }
        return sum;
    }
    public List<Integer> countSmaller(int[] nums) {
        int[] tree = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tree);
        int[] smaller = new int[nums.length];
        int[] count = new int[nums.length];
        for(int i=nums.length-1; i>=0; i--) {
            count[i] = smaller(tree, smaller, nums[i]);
        }
        List<Integer> results = new ArrayList<>(nums.length);
        for(int i=0; i<count.length; i++) results.add(count[i]);
        return results;
    }
}*/