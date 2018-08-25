package leetcode;

public class Solutionb210 {
	public static void main(String args[]){
		Solutionb210 s = new Solutionb210();
		int[][] a = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
		int[] b = s.findOrder(4, a);
		for (int i = 0; i < b.length; i ++) System.out.println(b[i]);
	}
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] point = new int[numCourses];
		int[] num = new int[numCourses];
		int[] result = new int[numCourses];
		int[] next = new int[prerequisites.length + 1];
		for (int i = 0; i < prerequisites.length; i ++){
			next[i + 1] = point[prerequisites[i][1]];
			point[prerequisites[i][1]] = i + 1;
			num[prerequisites[i][0]] ++;
		}
		for (int i = 0; i < numCourses; i ++){
			int j = 0;
			for (j = 0; j < numCourses; j ++)
				if (num[j] == 0){
					num[j] --;
					result[i] = j;
					int l = point[j];
					while (l != 0){
						num[prerequisites[l - 1][0]] --;
						l = next[l];
					}
					break;
				}
			if (j == numCourses) return new int[]{};
		}
		return result;
	}
}