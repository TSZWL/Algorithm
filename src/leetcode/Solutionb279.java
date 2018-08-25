package leetcode;

public class Solutionb279 {
	
	public static void main(String args[]){
		Solutionb279 s = new Solutionb279();
		System.out.println(s.numSquares(123456));
	}
	//ʹ��min = Math.min(min, f[i - j * j])����f[i] = Math.min(f[i], f[i - j * j] + 1)
	//Ч�������50%
	public int numSquares(int n) {
		int[] f = new int[n + 1];
		for (int i = 1; i <= n; i ++){
			int min = f[i - 1];
			for (int j = 2; j * j <= i; j ++)
				min = Math.min(min, f[i - j * j]);
			f[i] = min + 1;
		}
		return f[n];
	}
/* ��ƽ���Ͷ���
 * ���������ܱ�ʾ��4��ƽ���ĺ�
 * ֻ��4^k*(8m+7)��ʽ����Ҫ4��ƽ����
 * ������ֻ��Ҫ3��
    public int numSquares(int n) {
        while (n % 4 == 0)
            n = n/4;
        
        if (n % 8 == 7)
            return 4;
        
        for (int a = 0; a * a <= n; a++) {
            int b = (int)Math.sqrt(n - a*a);
            
            if (a * a + b * b == n ) {
                if (a == 0 || b == 0)
                    return 1;
                else 
                    return 2;
            }
                
        }
        
        return 3;
    }
*/
}