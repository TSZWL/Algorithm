package help;

import java.util.Arrays;
import java.util.Scanner;

public class x2 {
	
	private static Scanner sc;
	private static int total = 0, msx = 0, score = 0;

	public static void main(String args[]) {
		for (int xxx = 0; xxx < 100; xxx ++) {
			sc = new Scanner(System.in);
			score = 0;
			int[][] map = new int[9][17];
			int[][][] f = {{{0, 0}, {0, 2}, {0, 4}, {0, 6}},// ºá	0
					{{0, 0}, {1, -1}, {2, -2}, {3, -3}},// /		1
					{{0, 0}, {1, 1}, {2, 2}, {3, 3}},// \			2
					{{0, 0}, {1, -1}, {1, 1}, {2, 0}},// Áâ			3
					{{0, 0}, {0, 2}, {1, 1}, {1, 3}},// z			4
					{{0, 0}, {0, 2}, {1, 1}, {1, -1}},// ·´z			5
					{{0, 0}, {1, -1}, {1, 1}, {1, 3}},// ºá1			6
					{{0, 0}, {1, 1}, {1, -1}, {1, -3}},// ºá2		7
					{{0, 0}, {0, 2}, {0, 4}, {1, 1}},// ºá3			8
					{{0, 0}, {0, 2}, {0, 4}, {1, 3}},// ºá4			9
					{{0, 0}, {1, -1}, {2, 2}, {1, 1}},// \ 1		10
					{{0, 0}, {1, 1}, {2, 2}, {2, 0}},// \ 2			11
					{{0, 0}, {0, 2}, {2, 2}, {1, 1}},// \ 3			12
					{{0, 0}, {1, 1}, {2, 2}, {1, 3}},// \ 4			13
					{{0, 0}, {0, 2}, {2, 0}, {1, 1}},// / 1			14
					{{0, 0}, {1, 1}, {0, 2}, {-1, 3}},// / 2		15
					{{0, 0}, {1, -1}, {2, -2}, {1, 1}},// / 3		16
					{{0, 0}, {1, -1}, {2, -2}, {2, 0}},// / 4		17
					{{0, 0}, {1, -1}, {1, 3}, {0, 2}},// ¹øÍ·			18
					{{0, 0}, {2, 2}, {1, 3}, {0, 2}},//				19
					{{0, 0}, {1, 1}, {2, 0}, {2, -2}},//			20
					{{0, 0}, {0, 4}, {1, 1}, {1, 3}},//				21
					{{0, 0}, {1, -1}, {2, 0}, {2, 2}},//			22
					{{0, 0}, {1, -1}, {0, 2}, {2, 0}},//			23
					{{0, 0}}};// µã									24
			int[] std = {5, 6, 7, 8, 9, 8, 7, 6, 5};
			int[] st = {4, 3, 2, 1, 0, 1, 2, 3, 4};
			int[] ed = {12, 13, 14, 15, 16, 15, 14, 13, 12};
			int[] x = {5, 6, 7, 8, 9, 8, 7, 6, 5};
			int[] y = {5, 6, 7, 8, 9, 8, 7, 6, 5};
			int[] z = {5, 6, 7, 8, 9, 8, 7, 6, 5};
			int[] get = {(int)Math.floor(Math.random() * 25), (int)Math.floor(Math.random() * 25), (int)Math.floor(Math.random() * 25)};
			while (true) {
				int choose = -1, cx = -1, cy = -1, chance = 0;
				for (int i = 0; i < 3; i ++) {
					for (int j = 0; j < 9; j ++)
						for (int l = st[j]; l <= ed[j]; l += 2)
							if (check(f, get[i], j, l, map, st, ed)) {
								int[][] nmap = new int[9][17];
								int[] nx = Arrays.copyOf(x, 9);
								int[] ny = Arrays.copyOf(y, 9);
								int[] nz = Arrays.copyOf(z, 9);
								for (int i1 = 0; i1 < 9; i1 ++)
									for (int j1 = 0; j1 < 17; j1 ++) nmap[i1][j1] = map[i1][j1];
								change(nmap, get[i], j, l, f, nx, ny, nz, std, st, ed, false);
								int a = 0, b = 0;
								if (i == 0) {
									a = get[1];
									b = get[2];
								} else if (i == 1) {
									a = get[0];
									b = get[2];
								} else {
									a = get[0];
									b = get[1];
								}
								int t = value(nmap, a, b, f, st, ed);
								if (t > chance) {
									chance = t;
									choose = i;
									cx = j;
									cy = l;
								}
							}
				}
				if (choose == -1) break;
				score += 40;
				change(map, get[choose], cx, cy, f, x, y, z, std, st, ed, true);
				/*System.out.println(get[choose] + " " + cx + " " + cy);
				for (int i = 0; i < 9; i ++) {
					for (int j = 0; j < 17; j ++) {
						if (j < st[i] || j > ed[i] || ((i + j) & 1) == 1) System.out.print(" ");
						else {
							boolean b = false;
							for (int l = 0; l < f[get[choose]].length; l ++)
								if (i == cx + f[get[choose]][l][0] && j == cy + f[get[choose]][l][1]) {
									b = true;
									break;
								}
							if (b) System.out.print((char) 1); else System.out.print(".");
						}
					}
					System.out.println();
				}*/
				/*for (int i = 0; i < 9; i ++) {
					for (int j = 0; j < 17; j ++) {
						if (j < st[i] || j > ed[i] || ((i + j) & 1) == 1) System.out.print(" ");
						else System.out.print(map[i][j]);
					}
					System.out.println();
				}*/
				//get[choose] = sc.nextInt();
				get[choose] = (int)Math.floor(Math.random() * 25);
			}
			System.out.println(score);
			msx = Math.max(msx, score);
			total += score;
		}
		System.out.println(msx);
		System.out.println(total / 100);
	}

	private static void change(int[][] nmap, int n, int x, int y, int[][][] f, int[] xx, int[] yy, int[] zz, int[] std, int[] st, int[] ed, boolean d) {
		for (int i = 0; i < f[n].length; i ++) {
			int a = x + f[n][i][0], b = y + f[n][i][1];
			nmap[a][b] = 1;
			xx[a] --;
			yy[(a + b) / 2 - 2] --;
			zz[(b - a) / 2 + 2] --;
		}
		clean(nmap, xx, yy, zz, std, st, ed, d);
	}
	
	private static int value(int[][] map, int a, int b, int[][][] f, int[] st, int[] ed) {
		int c = 0;
		for (int i = 0; i < f.length; i ++) {
			int now = 0;
			for (int j = 0; j < 9; j ++)
				for (int l = st[j]; l <= ed[j]; l += 2)
					if (check(f, i, j, l, map, st, ed)) now ++;
			if (i == a || i == b) now = now * 25;
			c += now;
		}
		/*for (int j = 0; j < 9; j ++)
			for (int l = st[j]; l <= ed[j]; l += 2) {
				boolean d = false;
				for (int i = 0; i < f.length - 1; i ++)
					if (check(f, i, j, l, map, st, ed)) {
						d = true;
						break;
					}
				//if (!d) c -= 25;
			}*/
		return c;
	}

	private static void clean(int[][] map, int[] x, int[] y, int[] z, int[] std, int[] st, int[] ed, boolean d) {
		for (int i = 0; i < 9; i ++)
			if (x[i] == 0) {
				for (int j = st[i]; j <= ed[i]; j += 2) {
					if (d) score += 20;
					map[i][j] = 0;
					x[i] ++;
					y[(i + j) / 2 - 2] ++;
					z[(j - i) / 2 + 2] ++;
				}
			}
		for (int i = 0; i < 9; i ++)
			if (y[i] == 0) {
				for (int a = 0; a < 9; a ++)
					for (int b = st[a]; b <= ed[a]; b += 2)
						if ((a + b) / 2 - 2 == i) {
							if (d) score += 20;
							map[a][b] = 0;
							x[a] ++;
							y[(a + b) / 2 - 2] ++;
							z[(b - a) / 2 + 2] ++;
						}
			}
		for (int i = 0; i < 9; i ++)
			if (z[i] == 0) {
				for (int a = 0; a < 9; a ++)
					for (int b = st[a]; b <= ed[a]; b += 2)
						if ((b - a) / 2 + 2 == i) {
							if (d) score += 20;
							map[a][b] = 0;
							x[a] ++;
							y[(a + b) / 2 - 2] ++;
							z[(b - a) / 2 + 2] ++;
						}
			}
	}

	private static boolean check(int[][][] f, int n, int x, int y, int[][] map, int[] st, int[] ed) {
		for (int i = 0; i < f[n].length; i ++) {
			int a = x + f[n][i][0], b = y + f[n][i][1]; 
			if (a >= 9 || a < 0 || b > ed[a] || b < st[a] || map[a][b] == 1) return false;
		}
		return true;
	}
}
