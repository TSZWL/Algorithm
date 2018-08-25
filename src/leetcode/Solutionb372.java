package leetcode;

public class Solutionb372 {
	
	public static void main(String args[]){
		Solutionb372 s = new Solutionb372();
		int[] a = {3, 4};
		System.out.println(s.superPow(2, a));
	}
	public int superPow(int a, int[] b) {
		return dfs(a % 1337, b, 0, b.length - 1);
	}
	private int dfs(int a, int[] b, int x, int l) {
		int d = l;
		for (int i = x; i < l; i ++)
			if (b[i] != 0) {
				if (d == l) d = i;
				b[i + 1] += (b[i] & 1) * 10;
				b[i] = b[i] >> 1;
			}
		if (b[l] == 0 && d == l) return 1;
		if ((b[l] & 1) == 1) {
			b[l] = b[l] >> 1;
			return ((int)Math.pow(dfs(a, b, d, l), 2)) % 1337 * a % 1337;
		} else {
			b[l] = b[l] >> 1;
			return (int)Math.pow(dfs(a, b, d, l), 2) % 1337;
		}
	}
}
/*log2(n)与log10(n)的区别？
public int superPow(int a, int[] b) {
    int r = 1;
    for (int i = b.length - 1; i >= 0; i--) {
        r = mul(r, pow(a, b[i]));
        a = pow(a, 10);
    }
    return r;
}

private int pow(int a, int b) {
    int r = 1;
    while (b > 0) {
        if (b % 2 == 1) {
            r = mul(r, a);
        }
        b /= 2;
        a = mul(a, a);
    }
    return r;
}

private int mul(int a, int b) {
    return (int)(((long)a * b) % MOD);
}
*/