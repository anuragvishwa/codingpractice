//Backtracking:
//https://www.lintcode.com/problem/flip-game-ii/description

public class FlipGame {

	public static void main(String[] args) {

		String str = "+++++";
		System.out.println(flipGame(str));

	}

	static Boolean flipGame(String str) {

		if (str == null || str.length() < 2)
			return false;

		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == '+' && str.charAt(i + 1) == '+') {
				String nextState = str.substring(0, i) + "--" + str.substring(i + 2);

				if (!flipGame(nextState)) {
					return true;
				}
			}
		}

		return false;
	}
}

//Backtracking:

public class FlipGame {

	public static void main(String[] args) {

		String str = "++++";
		System.out.println(flipGame(str.toCharArray()));

	}

	static Boolean flipGame(char[] str) {

		for (int i = 0; i < str.length - 1; i++) {
			if (str[i] == '+' && str[i + 1] == '+') {

				str[i] = '-';
				str[i + 1] = '-';

				boolean otherWin = flipGame(str);

				str[i] = '+';
				str[i + 1] = '+';

				if (!otherWin) {
					return true;
				}

			}

		}

		return false;
	}
}

