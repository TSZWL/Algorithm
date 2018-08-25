package leetcode;

public class Solutionb678 {
	
	public static void main(String args[]){
		Solutionb678 s = new Solutionb678();
		System.out.println(s.checkValidString("()(()(*(())()*)(*)))()))*)((()(*(((()())()))()()*)((*)))()))(*)(()()(((()*()()((()))((*((*)()"));
	}
	//tot一共*,max最多添多少)->前面被逼添加的(算作负数
	//非常简单，用low和high记录当前位置所能达到的now的值的范围
	public boolean checkValidString(String s) {
		char[] c = s.toCharArray();
		int max = 0, now = 0, tot = 0;
		for (int i = 0; i < c.length; i ++)
			if (c[i] == ')'){
				now --;
				if (now < 0 && -now > tot) return false;
				if (now < max) max --;
			} else if (c[i] == '*'){
				tot ++;
				max ++;
			}
			else now ++;
		if (now > max) return false;
		return true;
	}
/*
public boolean checkValidString(String s) {
    int high = 0;
    int low = 0;
    for(int i=0; i<s.length(); i++){
        if(s.charAt(i) == '('){
            low++;
            high++;
        }else if(s.charAt(i) == ')'){
            if(low>0){
                low--;
            }
            high--;
        }else{
            if(low>0){
                low--;
            }
            high++;
        }
        if(high<0){
            return false;
        }
    }
    return low == 0;
}
 */
}