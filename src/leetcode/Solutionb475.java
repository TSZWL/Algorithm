package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Solutionb475 {
	public static void main(String args[]){
		Solutionb475 s = new Solutionb475();
		int[] a = {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
		int[] b = {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};
		System.out.println(s.findRadius(a, b));
	}
	//不需要栈，直接记录上一个heater之后的第一个house的坐标和上一个heater的坐标
	public int findRadius(int[] houses, int[] heaters) {
		Stack<Integer> f = new Stack<Integer>();
		int x = 0, y = 0, result = 0, last = -1;
		Arrays.sort(houses);
		Arrays.sort(heaters);
		while (x < houses.length){
			while ((x < houses.length) && ((y == heaters.length) || (houses[x] <= heaters[y]))){
				f.push(houses[x]);
				x ++;
			}
			while (!f.isEmpty()){
				int a = f.pop();
				if (last != -1){
					if (y != heaters.length) result = Math.max(result, Math.min(heaters[y] - a, a - last));
					else result = Math.max(result, a - last);
				} else 
					if (y != heaters.length) result = Math.max(result, heaters[y] - a);
			}
			if (y != heaters.length){
				last = heaters[y];
				y ++;
			}
		}
		return result;
	}
}