package b1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Luhn {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		try (BufferedReader br = new BufferedReader(new FileReader(".\\val"));) {
			String line = br.readLine();
			while (line != null) {
				sb.append(findX(line));
				line = br.readLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(sb);
	}

	public static int findX(String str) {
		int sum = 0;
		int mul = -1;
		for (int i = 0; i < str.length(); i++)
			if (str.charAt(str.length() - i - 1) == 'X')
				mul = i % 2 + 1;
			else {
				int n = Character.getNumericValue(str.charAt(str.length() - i - 1)) * (i % 2 + 1);
				sum += n < 10 ? n : n - 9;
			}
		int r = 10 - sum % 10;

		r = r == 10 ? 0 : r;

		r = r % 2 == 1 && mul == 2 ? r + 9 : r;

		r = r / mul;

		// if (!isValid(str, r))
		// for (int i = 0; i < 10; i++)
		// if (isValid(str, i))
		// System.out.println("Should be " + i + " (" + mul + ")");

		return r;
	}

	// public static boolean isValid(String str, int x) {
	// int sum = 0;
	// for (int i = 0; i < str.length(); i++)
	// if (str.charAt(str.length() - i - 1) == 'X') {
	// int n = (i % 2 + 1) * x;
	// sum += n < 10 ? n : n - 9;
	// } else {
	// int n = Character.getNumericValue(str.charAt(str.length() - i - 1)) * (i
	// % 2 + 1);
	// sum += n < 10 ? n : n - 9;
	// }
	// return sum % 10 == 0;
	// }

}
