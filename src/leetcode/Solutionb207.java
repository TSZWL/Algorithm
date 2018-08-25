package leetcode;

public class Solutionb207 {
	public static void main(String args[]){
		Solutionb207 s = new Solutionb207();
		int[][] a = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
		System.out.println(s.canFinish(4, a));
	}
	//������spfa��һ���֣�ֱ�ӹ����ڵ���У�������ѭ����ʱ�临�Ӷȱ��n^2
	//����������Ҫboolean�����ж��Ƿ����ڶ�����
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] point = new int[numCourses];
		int[] num = new int[numCourses];
		int[] next = new int[prerequisites.length + 1];
		for (int i = 0; i < prerequisites.length; i ++){
			next[i + 1] = point[prerequisites[i][1]];
			point[prerequisites[i][1]] = i + 1;
			num[prerequisites[i][0]] ++;
		}
		int head = 0, tail = 0;
		int[] q = new int[numCourses];
		for (int i = 0; i < numCourses; i ++)
			if (num[i] == 0){
				q[tail] = i;
				tail ++;
			}
		if (tail == numCourses) return true;
		while (head < tail){
			int l = point[q[head]];
			while (l != 0){
				num[prerequisites[l - 1][0]] --;
				if (num[prerequisites[l - 1][0]] == 0){
					q[tail] = prerequisites[l - 1][0];
					tail ++;
					if (tail == numCourses) return true;
				}
				l = next[l];
			}
			head ++;
		}
		return false;
	}
}