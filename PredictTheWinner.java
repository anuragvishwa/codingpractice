
public class PredictTheWinner {

	public static void main(String[] args) {

		int[] arr = { 1, 5, 233, 7 };
		System.out.println(ptw(arr));

	}

	static Boolean ptw(int[] nums) {

		return getScore(nums, 0, nums.length - 1, 0, true) >= 0 ? true : false;
	}

	static int getScore(int[] arr, int start, int end, int score, Boolean p1turn) {

		if (start == end) {
			return score;
		}

		if (p1turn) {
			int startScore = getScore(arr, start + 1, end, score + arr[start], false);
			int endScore = getScore(arr, start, end - 1, score + arr[end], false);
			return Math.max(startScore, endScore);
		} else {
			int startScore = getScore(arr, start + 1, end, score - arr[start], true);
			int endScore = getScore(arr, start, end - 1, score - arr[end], true);
			return Math.min(startScore, endScore);
		}

	}

}
