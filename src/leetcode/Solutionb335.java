package leetcode;

public class Solutionb335 {
	
	public static void main(String args[]){
	}
	//���ֻཻ�а���������ߴ������ס���������
	//�ڴ�����µ��ֻཻ��x��x-3,x-4,x-5��3���߲ſ��Դ��
	public boolean isSelfCrossing(int[] x) {
		int l = x.length;
		if(l <= 3) return false;
		for(int i = 3; i < l; i ++){
			if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) return true;
			if (i >= 4 && x[i -  1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) return true;
			if (i >= 5 && x[i - 2] >= x[i - 4] && x[i] >= x[i - 2] - x[i - 4] && x[i - 1] >= x[i - 3] - x[i - 5] && x[i - 1] <= x[i - 3]) return true;
		}
		return false;
	}
}