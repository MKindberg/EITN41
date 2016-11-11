package b2;

import java.util.Random;

public class MicroMint {

	public static void main(String[] args) {

		final int N = 1000;

		final int u = 20;
		final int k = 7;
		final int c = 10000;

		long sum = 0;
		int[] trials = new int[N];
		for (int i = 0; i < N; i++) {
			trials[i] = calc(u, k, c);
			sum += trials[i];
		}
		long mean = sum / N;
		double sd = 0;
		for (int i : trials)
			sd += Math.pow(mean - i, 2);
		sd = Math.sqrt(sd / N);
		System.out.println(mean + "+-" + 3.66 * sd / Math.sqrt(N));
	}

	public static int calc(int u, int k, int c) {
		Random r = new Random();
		int b = (int) Math.pow(2, u);
		int[] bins = new int[b];
		int i = 0;
		while (c > 0) {
			int n = r.nextInt(b);
			if (bins[n] != -1) {
				bins[n]++;
				if (bins[n] == k) {
					c--;
					bins[n] = -1;
				}

			}
			i++;
		}
		return i;
	}
}
