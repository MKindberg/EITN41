package c1;

import java.util.Random;

public class Coin {

	private Random rand = new Random();

	private int[] a;
	private int[] c;
	private int[] d;
	private int[] r;
	private int[] B;
	private int signature;

	private int n;
	private int[] R; // shouldn't be saved in coin

	public Coin(int n, int k, int id) {
		this.n = n;

		a = new int[2 * k];
		c = new int[2 * k];
		d = new int[2 * k];
		r = new int[2 * k];
		B = new int[2 * k];
		for (int i = 0; i < 2 * k; i++) {
			a[i] = rand.nextInt(n);
			c[i] = rand.nextInt(n);
			d[i] = rand.nextInt(n);
			r[i] = rand.nextInt(n);
			String x = Util.hash(a[i], c[i]);
			String y = Util.hash(a[i] ^ id, d[i]);
			B[i] = (int) (Math.pow(r[i], 3) * Util.f(x, y)) % n;
		}
	}

	public int[] getB() {
		return B;
	}

	/**
	 * 
	 * @param R
	 *            The indicies the bank wants to see
	 * @return A vector containing a, c, d and r values. First all a, then all
	 *         c, then d, then r. Ordered as R.
	 */
	public int[] verify(int[] R) {
		this.r = R;
		int l = B.length;
		int[] res = new int[4 * l];

		for (int i = 0; i < l; i++) {
			res[i] = a[R[i]];
			res[i + l] = c[R[i]];
			res[i + 2 * l] = d[R[i]];
			res[i + 3 * l] = r[R[i]];
		}

		return res;
	}

	// Probably not entirely correct
	public void sign(int S, int id) {
		String x = Util.hash(a[R[0]], c[R[0]]);
		String y = Util.hash(a[R[0]] ^ id, d[R[0]]);
		signature = (int) Math.pow(Util.f(x, y), inv(3));
		for (int i = 1; i < R.length; i++) {
			x = Util.hash(a[R[i]], c[R[i]]);
			y = Util.hash(a[R[i]] ^ id, d[R[i]]);
			signature *= (int) Math.pow(Util.f(x, y), inv(3));
		}
	}

	private double inv(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
