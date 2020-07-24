import java.util.ArrayList;
import java.util.List;

public class LetterCombination {

	static String[] string = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public static void main(String[] args) {

		System.out.println(letterComb("23"));
	}

	static List<String> letterComb(String digits) {

		List<String> resultList = new ArrayList<String>();

		if (digits.length() == 0) {
			return resultList;
		}

		resultList.add("");

		for (int i = 0; i < digits.length(); i++) {

			resultList = combList(string[digits.charAt(i) - '0'], resultList);
		}

		return resultList;
	}

	static List<String> combList(String str, List<String> hList) {

		List<String> list = new ArrayList<String>();

		for (int i = 0; i < str.length(); i++) {
			for (String string : hList) {
				list.add(string + str.charAt(i));
			}
		}

		return list;

	}

}
