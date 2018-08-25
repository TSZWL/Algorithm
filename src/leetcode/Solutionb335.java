package leetcode;

public class Solutionb335 {
	
	public static void main(String args[]){
	}
	//不相交只有包在里面或者从外面包住这两种情况
	//在此情况下的相交只有x与x-3,x-4,x-5这3组线才可以达成
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