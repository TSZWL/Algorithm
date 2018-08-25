package leetcode;

public class Solutionb134 {
	
	public static void main(String args[]){
	}
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int now = 0, min = Integer.MAX_VALUE, pos = 0;
		for (int i = 0; i < gas.length; i ++){
			now = now + gas[i] - cost[i];
			if (now < min){
				min = now;
				pos = i;
			}
		}
		pos = (pos + 1) % gas.length;
		return now >= 0 ? pos : -1;
	}
}