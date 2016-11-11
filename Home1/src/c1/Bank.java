package c1;

import java.util.Random;

public class Bank {
	Random rand = new Random();
	int[] R;
	int[] nR;
	int id;

	public Bank(int id) {
		this.id = id;
	}

	public int[] getRand(int k) {
		int[] r = new int[2 * k];
		for (int i = 0; i < 2 * k; i++)
			r[i] = i;
		for (int i = 2 * k; i > 0; i--) {
			int index = rand.nextInt(2 * k);
			int temp = r[index];
			r[index] = r[i];
			r[i] = temp;
		}

		R = new int[k];
		nR = new int[k];
		for (int i = 0; i < k; i++) {
			R[i] = r[i];
			nR[i] = r[i + k];
		}
		return R;
	}

	public boolean verify(int[] B, int[] vals) {
		int l = B.length;
		for (int i = 0; i < l; i++) {
			int a = vals[i];
			int c = vals[i + l];
			int d = vals[i + 2 * l];
			int r = vals[i + 3 * l];
			String x = Util.hash(a, c);
			String y = Util.hash(a ^ id, d);
			if (B[R[i]] != (int) (Math.pow(r, 3) * Util.f(x, y)) % Util.n)
				return false;
		}
		return true;
	}
}
