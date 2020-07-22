
public class OnesAndZeros {

	public static void main(String[] args) {

		String[] strs = { "10", "0001", "111001", "1", "0" };
		int m = 4;
		int n = 3;
		System.out.println(findMax(strs, m, n, 0));
	}

	static int findMax(String[] strs, int m, int n, int i) {

		if (m + n == 0 || i >= strs.length) {
			return 0;
		}

		if (m == 0 && n == 0) {
			return 1;
		}

		int choose = 0;

		int zero = (int) strs[i].chars().filter(ch -> ch == '0').count();
		int one = (int) strs[i].chars().filter(ch -> ch == '1').count();

		if (m >= zero && n >= one)
			choose = 1 + findMax(strs, m - zero, n - one, i + 1);
		int notChoose = findMax(strs, m, n, i + 1);

		return Math.max(choose, notChoose);
	}

}
