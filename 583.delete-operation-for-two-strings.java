/*
 * @lc app=leetcode id=583 lang=java
 *
 * [583] Delete Operation for Two Strings
 *
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 *
 * algorithms
 * Medium (48.76%)
 * Likes:    1143
 * Dislikes: 26
 * Total Accepted:    52.2K
 * Total Submissions: 107K
 * Testcase Example:  '"sea"\n"eat"'
 *
 * 
 * Given two words word1 and word2, find the minimum number of steps required
 * to make word1 and word2 the same, where in each step you can delete one
 * character in either string.
 * 
 * 
 * Example 1:
 * 
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to
 * make "eat" to "ea".
 * 
 * 
 * 
 * Note:
 * 
 * The length of given words won't exceed 500.
 * Characters in given words can only be lower-case letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        return deleteOperation(word1,word2);
    }

    //O(M) space:
   int deleteOperation(String word1, String word2) {

		int l1 = word1.length();
		int l2 = word2.length();

		int[] map = new int[l2 + 1];

		for (int j = 0; j <= l2; j++) {
			map[j] = j;
		}

		for (int i = 0; i < l1; i++) {
			int[] newMap = new int[l2 + 1];
			newMap[0] = i + 1;
			for (int j = 0; j < l2; j++) {
				if (word1.charAt(i) == word2.charAt(j)) {
					newMap[j + 1] = map[j];
				} else {
					newMap[j + 1] = Math.min(map[j + 1], newMap[j]) + 1;
				}
			}

			map = newMap;
		}

		return map[l2];

	}

    //O(M*N space):
    // int deleteOperation(String word1, String word2) {
	// 	int l1 = word1.length();
	// 	int l2 = word2.length();

	// 	int[][] dp = new int[l1 + 1][l2 + 1];

	// 	for (int j = 0; j <= l2; j++) {
	// 		dp[0][j] = j;
	// 	}

	// 	for (int i = 0; i <= l1; i++) {
	// 		dp[i][0] = i;
	// 	}

	// 	for (int i = 1; i <= l1; i++) {
	// 		for (int j = 1; j <= l2; j++) {
	// 			if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
	// 				dp[i][j] = dp[i - 1][j - 1];
	// 			} else {
	// 				dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
	// 			}
	// 		}
	// 	}

	// 	return dp[l1][l2];

	// }

    //Recursive
    // int deleteOperation(String word1, String word2, int i, int j) {
	// 	if (i == 0) {
	// 		return j;
	// 	}

	// 	if (j == 0) {
	// 		return i;
	// 	}

	// 	if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
	// 		return deleteOperation(word1, word2, i - 1, j - 1);
	// 	}

	// 	int d1 = 1 + deleteOperation(word1, word2, i - 1, j);
	// 	int d2 = 1 + deleteOperation(word1, word2, i, j - 1);

	// 	return Math.min(d1, d2);

	// }
}
// @lc code=end

