package help;

import java.util.Arrays;
import java.util.Scanner;

public class Xx {
	
	private static Scanner sc;
	private static int total = 0, msx = 0, score = 0, cover = 0;

	public static void main(String args[]) {
		for (int xxx = 0; xxx < 10; xxx ++) {
			sc = new Scanner(System.in);
			score = 0;
			cover = 0;
			int[][] map = new int[9][17];
			int[][][] f = {{{0, 0}, {0, 2}, {0, 4}, {0, 6}},// ��	0
					{{0, 0}, {1, -1}, {2, -2}, {3, -3}},// /		1
					{{0, 0}, {1, 1}, {2, 2}, {3, 3}},// \			2
					{{0, 0}, {1, -1}, {1, 1}, {2, 0}},// ��			3
					{{0, 0}, {0, 2}, {1, 1}, {1, 3}},// z			4
					{{0, 0}, {0, 2}, {1, 1}, {1, -1}},// ��z			5
					{{0, 0}, {1, -1}, {1, 1}, {1, 3}},// ��1			6
					{{0, 0}, {1, 1}, {1, -1}, {1, -3}},// ��2		7
					{{0, 0}, {0, 2}, {0, 4}, {1, 1}},// ��3			8
					{{0, 0}, {0, 2}, {0, 4}, {1, 3}},// ��4			9
					{{0, 0}, {1, -1}, {2, 2}, {1, 1}},// \ 1		10
					{{0, 0}, {1, 1}, {2, 2}, {2, 0}},// \ 2			11
					{{0, 0}, {0, 2}, {2, 2}, {1, 1}},// \ 3			12
					{{0, 0}, {1, 1}, {2, 2}, {1, 3}},// \ 4			13
					{{0, 0}, {0, 2}, {2, 0}, {1, 1}},// / 1			14
					{{0, 0}, {1, 1}, {0, 2}, {-1, 3}},// / 2		15
					{{0, 0}, {1, -1}, {2, -2}, {1, 1}},// / 3		16
					{{0, 0}, {1, -1}, {2, -2}, {2, 0}},// / 4		17
					{{0, 0}, {1, -1}, {1, 3}, {0, 2}},// ��ͷ			18
					{{0, 0}, {2, 2}, {1, 3}, {0, 2}},//				19
					{{0, 0}, {1, 1}, {2, 0}, {2, -2}},//			20
					{{0, 0}, {0, 4}, {1, 1}, {1, 3}},//				21
					{{0, 0}, {1, -1}, {2, 0}, {2, 2}},//			22
					{{0, 0}, {1, -1}, {0, 2}, {2, 0}},//			23
					{{0, 0}}};// ��									24
			int[] std = {5, 6, 7, 8, 9, 8, 7, 6, 5};
			int[] st = {4, 3, 2, 1, 0, 1, 2, 3, 4};
			int[] ed = {12, 13, 14, 15, 16, 15, 14, 13, 12};
			int[] x = {5, 6, 7, 8, 9, 8, 7, 6, 5};
			int[] y = {5, 6, 7, 8, 9, 8, 7, 6, 5};
			int[] z = {5, 6, 7, 8, 9, 8, 7, 6, 5};
			int[] get = {(int)Math.floor(Math.random() * 25), (int)Math.floor(Math.random() * 25), (int)Math.floor(Math.random() * 25)};
			while (true) {
				int choose = -1, cx = -1, cy = -1, chance = Integer.MIN_VALUE;
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
								int t = value(nmap, a, b, f, st, ed, nx, ny, nz, std);
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
				if (get[choose] == 24) cover ++; else cover += 4;
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
				/*get[choose] = sc.nextInt();
				if (get[choose] == 0) get[choose] = 24;
				else if (get[choose] == 1) get[choose] = 0;
				else if (get[choose] == 2) get[choose] = 2;
				else if (get[choose] == 3) get[choose] = 1;
				else if (get[choose] == 11) get[choose] = 6;
				else if (get[choose] == 12) get[choose] = 7;
				else if (get[choose] == 13) get[choose] = 8;
				else if (get[choose] == 14) get[choose] = 9;
				else if (get[choose] == 21) get[choose] = 10;
				else if (get[choose] == 22) get[choose] = 11;
				else if (get[choose] == 23) get[choose] = 12;
				else if (get[choose] == 24) get[choose] = 13;
				else if (get[choose] == 31) get[choose] = 14;
				else if (get[choose] == 32) get[choose] = 15;
				else if (get[choose] == 33) get[choose] = 16;
				else if (get[choose] == 34) get[choose] = 17;
				else if (get[choose] == 41) get[choose] = 3;
				else if (get[choose] == 42) get[choose] = 4;
				else if (get[choose] == 43) get[choose] = 5;
				else if (get[choose] == 51) get[choose] = 18;
				else if (get[choose] == 52) get[choose] = 19;
				else if (get[choose] == 53) get[choose] = 20;
				else if (get[choose] == 54) get[choose] = 21;
				else if (get[choose] == 55) get[choose] = 22;
				else if (get[choose] == 56) get[choose] = 23;*/
				get[choose] = (int)Math.floor(Math.random() * 25);
			}
			System.out.println(score + " " + cover);
			total += score;
			if (score > msx) msx = score;
		}
		System.out.println(total / 10 + " " + msx);
	}

	private static int value(int[][] map, int a, int b, int[][][] f, int[] st, int[] ed, int[] x, int[] y, int[] z, int[] std) {
		int c = 0;
		for (int i = 0; i < f.length; i ++) {
			int now = 0;
			for (int j = 0; j < 9; j ++)
				for (int l = st[j]; l <= ed[j]; l += 2)
					if (check(f, i, j, l, map, st, ed)) {
						int[][] nmap = new int[9][17];
						int[] nx = Arrays.copyOf(x, 9);
						int[] ny = Arrays.copyOf(y, 9);
						int[] nz = Arrays.copyOf(z, 9);
						for (int i1 = 0; i1 < 9; i1 ++)
							for (int j1 = 0; j1 < 17; j1 ++) nmap[i1][j1] = map[i1][j1];
						change(nmap, i, j, l, f, nx, ny, nz, std, st, ed, false);
						if (i == a) {
							now += value2(nmap, -1, b, f, st, ed, x, y, z, std, 2);
						} else if (i == b) {
							now += value2(nmap, a, -1, f, st, ed, x, y, z, std, 2);
						} else {
							now += value2(nmap, a, b, f, st, ed, x, y, z, std, 1);
						}
					}
			if (i == a || i == b) now = now * 25;
			c += now;
		}
		return c;
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
	
	private static int value2(int[][] map, int a, int b, int[][][] f, int[] st, int[] ed, int[] x, int[] y, int[] z, int[] std, int k) {
		int c = 0;
		for (int i = 0; i < f.length; i ++) {
			int now = 0;
			for (int j = 0; j < 9; j ++)
				for (int l = st[j]; l <= ed[j]; l += 2)
					if (check(f, i, j, l, map, st, ed)) {
						if (cover > 25) {
							int[][] nmap = new int[9][17];
							int[] nx = Arrays.copyOf(x, 9);
							int[] ny = Arrays.copyOf(y, 9);
							int[] nz = Arrays.copyOf(z, 9);
							for (int i1 = 0; i1 < 9; i1 ++)
								for (int j1 = 0; j1 < 17; j1 ++) nmap[i1][j1] = map[i1][j1];
							change(nmap, i, j, l, f, nx, ny, nz, std, st, ed, false);
							if (i == a) {
								now += value3(nmap, -1, b, f, st, ed, k + 1);
							} else if (i == b) {
								now += value3(nmap, a, -1, f, st, ed, k + 1);
							} else {
								now += value3(nmap, a, b, f, st, ed, k);
							}
						} else now ++;
					}
			if (i == a || i == b) now = now * 25; else now = now * k;
			c += now;
		}
		return c;
	}
	
	private static int value3(int[][] map, int a, int b, int[][][] f, int[] st, int[] ed, int k) {
		int c = 0;
		for (int i = 0; i < f.length; i ++) {
			int now = 0;
			for (int j = 0; j < 9; j ++)
				for (int l = st[j]; l <= ed[j]; l += 2)
					if (check(f, i, j, l, map, st, ed)) now ++;
			if (i == a || i == b) now = now * 25; else now = now * k;
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
				if (!d) c -= 5;
			}*/
		return c;
	}

	private static void clean(int[][] map, int[] x, int[] y, int[] z, int[] std, int[] st, int[] ed, boolean d) {
		for (int i = 0; i < 9; i ++)
			if (x[i] == 0) {
				for (int j = st[i]; j <= ed[i]; j += 2) {
					if (d) {
						score += 20;
						if (map[i][j] != 0) cover --;
					}
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
							if (d) {
								score += 20;
								if (map[a][b] != 0) cover --;
							}
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
							if (d) {
								score += 20;
								if (map[a][b] != 0) cover --;
							}
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
