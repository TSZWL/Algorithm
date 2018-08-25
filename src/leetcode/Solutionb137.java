package leetcode;

public class Solutionb137 {
	
	public static void main(String args[]){
		Solutionb137 s = new Solutionb137();
		int[] a = {3, -1, -1, 5, 5, -1, 5};
		System.out.println(s.singleNumber(a));
	}
	//xor二进制作为一位只能表示某位是否重复了2n次，构造出2位来计算是否重复了3n次
	//同理，4次同为2位，5-8次为3位。(列出寻找规律。
	public int singleNumber(int[] nums) {
		int x = 0, y = 0;
		for (int i = 0; i < nums.length; i ++){
			x = (x ^ nums[i]) & (~y);
			//变化后的x
			y = (y ^ nums[i]) & (~x);
		}
		return x;
	}
}