//https://leetcode.com/problems/decode-ways/

public class DecodeWays {

	public static void main(String[] args) {

		String string = "226";
		System.out.println(numDecodings(string, 0));

	}

	static int numDecodings(String s, int i) {

		int n = s.length();

		if (i == n) {
			return 1;
		}

		if (s.charAt(i) == 0) {
			return 0;
		}

		int count = numDecodings(s, i + 1);

		if (i < n - 1) {
			if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
				count = count + numDecodings(s, i + 2);
			}
		}

		return count;
	}

}
