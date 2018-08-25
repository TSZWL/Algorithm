package leetcode;

public class Solution76 {
	
	public static void main(String args[]){
		Solution76 s = new Solution76();
		System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));
	}
	public String minWindow(String s, String t) {
		if (s.length() < t.length() || t.length() == 0) return "";
		int minl = Integer.MAX_VALUE, left = 0, right = 0, rl = 0, rr = 0;
		int[] c = new int[256];
		for (int i = 0; i < t.length(); i ++) c[t.charAt(i)] ++;
		int d = t.length();
		while (true){
			while (d > 0 && rr < s.length()){
				int a = s.charAt(rr);
				c[a] --;
				if (c[a] >= 0) d --;
				rr ++;
			}
			while (rl < s.length()){
				int a = s.charAt(rl);
				if (c[a] >= 0 && d == 0) break;
				c[a] ++;
				rl ++;
			}
			if (d == 0 && rr - rl < minl){
				minl = rr - rl;
				left = rl;
				right = rr;
			}
			if (rr == s.length()) break;
			c[s.charAt(rl)] ++;
			rl ++;
			d ++;
		}
		if (minl == Integer.MAX_VALUE) return "";
		else return s.substring(left, right);
	}
/*  public String minWindow(String s, String t) {
        int[] map=new int[128];
        for(char c:t.toCharArray()){
            map[c]++;
        }
        int count=t.length();
        int i=0; int j=0; 
        int maxlen=Integer.MAX_VALUE;
        int sta=0;
        char[] c=s.toCharArray();
        while(i<c.length){
            if(map[c[i++]]-->0) count--;
            while(count==0){
                if(i-j<maxlen){
                    sta=j;
                    maxlen=i-j;
                }
                //System.out.println(maxlen+" ");
                if(map[c[j++]]++ ==0) count++;
            }
        }
        return maxlen==Integer.MAX_VALUE?"" :s.substring(sta,sta+maxlen);
    }*/
}