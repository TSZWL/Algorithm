package leetcode;

public class Solutionb405 {
	
	public static void main(String args[]){
		System.out.println(-5 % 16);
		System.out.println(-5 & 15);
	}
	//当被除数为负数时，%和&的区别(补码带来的影响)
	public String toHex(int num) {
		if (num < 0){
			num = -(num + 1);
			String result = "";
			while (num != 0){
				int x = 15 - num % 16;
				if (x == 10) result = 'a' + result;
				else if (x == 11) result = 'b' + result;
				else if (x == 12) result = 'c' + result;
				else if (x == 13) result = 'd' + result;
				else if (x == 14) result = 'e' + result;
				else if (x == 15) result = 'f' + result;
				else result = x + result;
				num = num / 16;
			}
			while (result.length() != 8) result = 'f' + result;
			return result;
		} else if (num > 0) {
			String result = "";
			while (num != 0){
				int x = num % 16;
				if (x == 10) result = 'a' + result;
				else if (x == 11) result = 'b' + result;
				else if (x == 12) result = 'c' + result;
				else if (x == 13) result = 'd' + result;
				else if (x == 14) result = 'e' + result;
				else if (x == 15) result = 'f' + result;
				else result = x + result;
				num = num / 16;
			}
			return result;
		}
		return "0";
	}
/*
    if(num==0) return "0";
    while(num != 0){
        result = bit[(num & 15)] + result;
        num = num >>> 4;
    }
*/
}