package leetcode;

import java.util.*;

public class Solutionb218 {
	
	public static void main(String args[]){
	}
	//�տ�ʼ�����õ������У����Ǹ�����������и߶Ⱥ��յ�����δ��������
	//�޷������ĳ��Ӻ���ӣ�ֻ����LinkedList�������ʹЧ�����
	//TreeSet PriorityQueue
	//Sort and Merge
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> result = new ArrayList<int[]>();
		List<int[]> f = new ArrayList<int[]>();
		if (buildings.length == 0) return result;
		for (int[] i : buildings){
			f.add(new int[]{i[0], i[2]});
			f.add(new int[]{i[1], -i[2]});
		}
		Collections.sort(f, new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				if (a[0] == b[0]) return b[1] - a[1];
				return a[0] - b[0];
			}
		});
		Queue<Integer> heap = new PriorityQueue<>(buildings.length, new Comparator<Integer>(){
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});
		heap.add(0);
		int last = 0;
		for (int[] i : f){
			if (i[1] < 0) heap.remove(-i[1]);
			else heap.add(i[1]);
			if (heap.peek() != last){
				last = heap.peek();
				result.add(new int[]{i[0], last});
			}
		}
		return result;
	}
}