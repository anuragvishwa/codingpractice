/*
 * @lc app=leetcode id=354 lang=java
 *
 * [354] Russian Doll Envelopes
 *
 * https://leetcode.com/problems/russian-doll-envelopes/description/
 *
 * algorithms
 * Hard (35.60%)
 * Likes:    1238
 * Dislikes: 42
 * Total Accepted:    70.8K
 * Total Submissions: 198.8K
 * Testcase Example:  '[[5,4],[6,4],[6,7],[2,3]]'
 *
 * You have a number of envelopes with widths and heights given as a pair of
 * integers (w, h). One envelope can fit into another if and only if both the
 * width and height of one envelope is greater than the width and height of the
 * other envelope.
 * 
 * What is the maximum number of envelopes can you Russian doll? (put one
 * inside other)
 * 
 * Note:
 * Rotation is not allowed.
 * 
 * Example:
 * 
 * 
 * 
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3 
 * Explanation: The maximum number of envelopes you can Russian doll is 3
 * ([2,3] => [5,4] => [6,7]).
 * 
 * 
 * 
 */

// @lc code=start
import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.comparingInt(a -> a[0]));
        return max(envelopes);
    }
    static int max(int[][] matrix) {

        if(matrix.length==0){
            return 0;
        }
		int arr[] = new int[matrix.length];
		Arrays.fill(arr, 1);

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < i; j++) {
				if (matrix[i][1] > matrix[j][1] && matrix[i][0] > matrix[j][0] && arr[i] < arr[j] + 1) {
					arr[i] = arr[j] + 1;
				}
			}
		}

		return Arrays.stream(arr).max().getAsInt();
	}

}
// @lc code=end

