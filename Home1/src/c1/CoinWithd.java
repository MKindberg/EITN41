package c1;

public class CoinWithd {

	public static void main(String[] args) {
		Util.n = 5;
		final int k = 5;
		final int id = 5;

		Bank b = new Bank(id);
		Coin c = new Coin(Util.n, k, id);
		int[] R = b.getRand(k);
		int[] B = c.getB();
		int[] val = c.verify(R);
		if (!b.verify(B, val))
			System.out.println("Invalid coin!");
	}
}
