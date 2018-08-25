package help;

import java.util.Scanner;

/*
1
SOME
4 4
TDOR
SNAM
OEFI
SMZO
2
QUIET
QUUIET
4 4
TDOR
SNAQ
OEIF
TMZO
 */

public class boggle {
	
	private static int length;
	private static String output;
	//f�����ֵ���,d�����Ƿ�Ϊ�����ڵ㣬node����ڵ���
	private static int[][] f = new int[400000][26];
	private static int[] d = new int[400000];
	private static int node = 1;
	//n��m�����ͼ������������
	//����a��¼��ͼ
	private static int n;
	private static int m;
	private static int[][] a = new int[100][100];
	//·����¼
	private static int[] x = new int[500];
	private static int[] y = new int[500];
	//����ѡ��
	private static int[] xx = {0, 0, 1, 1, 1, -1, -1, -1};
	private static int[] yy = {1, -1, 1, 0, -1, 1, 0, -1};
	//��¼�ù��ĵ�
	private static boolean[][] b = new boolean[100][100];
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//k�����ʱ��ʸ���
		//����Ĭ��������ĸȫΪ��д
		int k = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < k; i ++){
			int l = 0;
			String st = sc.nextLine();
			for (int j = 0; j < st.length(); j ++){
				int ch = st.charAt(j) - 65;//СдΪ97
				if (f[l][ch] == 0){
					f[l][ch] = node;
					node ++;
				}
				l = f[l][ch];
			}
			d[l] ++;
		}
		
		//n��m�����ͼ������������
		//����a��¼��ͼ
		//����Ĭ��������ĸȫΪ��д
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i ++){
			String st = sc.nextLine();
			for (int j = 0; j < st.length(); j ++){
				a[i][j] = st.charAt(j) - 65;
			}
		}
		
		for (int i = 0; i < n; i ++)
			for (int j = 0; j < m; j ++){
				b[i][j] = true;
			}
		
		for (int i = 0; i < n; i ++)
			for (int j = 0; j < m; j ++)
				if (f[0][a[i][j]] != 0){
					length = 1;
					output = "";
					output += (char)(a[i][j] + 65);
					x[0] = i;
					y[0] = j;
					b[i][j] = false;
					dfs(i, j, f[0][a[i][j]], a[i][j]);
					b[i][j] = true;
				}
		
		sc.close();
	}

	//�����꣬�����꣬�ֵ����е�λ�ã��ڵ�ֵ
	private static void dfs(int nowx, int nowy, int l, int num) {
		//���
		if (d[l] == 1){
			System.out.println("Get: " + output);
			System.out.print("Path: (" + x[0] + ", " + y[0] + ")");
			for (int i = 1; i < length; i ++){
				System.out.print("->(" + x[i] + ", " + y[i] + ")");
			}
			System.out.println();
		}
		
		//�жϽ�Qת����QU�����
		if (num == 16)
			if (f[l][20] != 0){
				output += "U";
				dfs(nowx, nowy, f[l][20], 20);
				output = output.substring(0, output.length() - 1);
			}
		
		//�����������
		for (int i = 0; i < 8; i ++){
			int nextx = nowx + xx[i];
			int nexty = nowy + yy[i];
			if ((nextx >= 0) && (nextx < n) && (nexty >= 0) && (nexty < m))
				if (f[l][a[nextx][nexty]] != 0)
					if (b[nextx][nexty]){
						output += (char)(a[nextx][nexty] + 65);
						x[length] = nextx;
						y[length] = nexty;
						length ++;
						b[nextx][nexty] = false;
						dfs(nextx, nexty, f[l][a[nextx][nexty]], a[nextx][nexty]);
						b[nextx][nexty] = true;
						length --;
						output = output.substring(0, output.length() - 1);
					}
		}
	}
}
