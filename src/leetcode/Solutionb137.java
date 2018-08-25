package leetcode;

public class Solutionb137 {
	
	public static void main(String args[]){
		Solutionb137 s = new Solutionb137();
		int[] a = {3, -1, -1, 5, 5, -1, 5};
		System.out.println(s.singleNumber(a));
	}
	//xor��������Ϊһλֻ�ܱ�ʾĳλ�Ƿ��ظ���2n�Σ������2λ�������Ƿ��ظ���3n��
	//ͬ��4��ͬΪ2λ��5-8��Ϊ3λ��(�г�Ѱ�ҹ��ɡ�
	public int singleNumber(int[] nums) {
		int x = 0, y = 0;
		for (int i = 0; i < nums.length; i ++){
			x = (x ^ nums[i]) & (~y);
			//�仯���x
			y = (y ^ nums[i]) & (~x);
		}
		return x;
	}
}