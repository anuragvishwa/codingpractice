//Recursive

public class LcsRecursive {

	public static void main(String[] args) {

		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		int m = s1.length();
		int n = s2.length();

		System.out.println(getLCS(s1, s2, m, n));

	}

	static int getLCS(String s1, String s2, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}

		int choose = 0;

		if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			return 1 + getLCS(s1, s2, m - 1, n - 1);
		}

		return Math.max(getLCS(s1, s2, m, n - 1), getLCS(s1, s2, m - 1, n));

	}

}
