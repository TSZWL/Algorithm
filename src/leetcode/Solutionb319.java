package leetcode;

public class Solutionb319 {
	public static void main(String args[]){
		Solutionb319 s = new Solutionb319();
		System.out.println(s.bulbSwitch(1));
	}
	public int bulbSwitch(int n) {
		return (int) Math.floor(Math.sqrt(n));
	}
}