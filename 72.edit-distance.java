/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 *
 * https://leetcode.com/problems/edit-distance/description/
 *
 * algorithms
 * Hard (44.97%)
 * Likes:    4297
 * Dislikes: 59
 * Total Accepted:    294.8K
 * Total Submissions: 654.4K
 * Testcase Example:  '"horse"\n"ros"'
 *
 * Given two words word1 and word2, find the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * 
 * Insert a character
 * Delete a character
 * Replace a character
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation: 
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation: 
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        return editDistance(word1,word2);
    }
    //Bottom Up DP:
    static int editDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();

		// distance[i][j] is the distance converse word1(1~ith) to word2(1~jth)
		int[][] distance = new int[len1 + 1][len2 + 1];
		// for (int j = 0; j <= len2; j++) {
		// 	distance[0][j] = j;
		// } // delete all characters in word2
		// for (int i = 0; i <= len1; i++) {
		// 	distance[i][0] = i;
		// }

		for (int i = 0; i <= len1; i++) {
			for (int j = 0; j <= len2; j++) {
                if(i==0){
                    distance[i][j]=j;
                }

                else if(j==0){
                    distance[i][j]=i;
                }

				else if (word1.charAt(i - 1) == word2.charAt(j - 1)) { // ith & jth
					distance[i][j] = distance[i - 1][j - 1];
				} else {
					distance[i][j] = Math.min(Math.min(distance[i][j - 1], distance[i - 1][j]), distance[i - 1][j - 1])
							+ 1;
				}
			}
		}

		return distance[len1][len2];

	}
    //Recursive solution:
    // static int editDistance(String word1, String word2, int i, int j) {
	// 	if (i < 0 || j < 0) {
	// 		return Integer.MAX_VALUE;
	// 	}

	// 	if (i == 0) {
	// 		return j;
	// 	}

	// 	if (j == 0) {
	// 		return i;
	// 	}

	// 	if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
	// 		return editDistance(word1, word2, i - 1, j - 1);
	// 	}

	// 	int delete = editDistance(word1, word2, i, j - 1);
	// 	int update = editDistance(word1, word2, i - 1, j - 1);
	// 	int insert = editDistance(word1, word2, i - 1, j);

	// 	return 1 + Math.min(update, Math.min(insert, delete));

	// }
}
// @lc code=end

