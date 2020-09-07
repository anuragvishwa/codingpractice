/*
 * @lc app=leetcode id=1143 lang=java
 *
 * [1143] Longest Common Subsequence
 *
 * https://leetcode.com/problems/longest-common-subsequence/description/
 *
 * algorithms
 * Medium (58.36%)
 * Likes:    1802
 * Dislikes: 21
 * Total Accepted:    134.3K
 * Total Submissions: 230.1K
 * Testcase Example:  '"abcde"\n"ace"'
 *
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence.
 * 
 * A subsequence of a string is a new string generated from the original string
 * with some characters(can be none) deleted without changing the relative
 * order of the remaining characters. (eg, "ace" is a subsequence of "abcde"
 * while "aec" is not). A common subsequence of two strings is a subsequence
 * that is common to both strings.
 * 
 * 
 * 
 * If there is no common subsequence, return 0.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: text1 = "abcde", text2 = "ace" 
 * Output: 3  
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * The input strings consist of lowercase English characters only.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1,text2);
    }

     int lcs(String text1,String text2){
	
		int n1 = text1.length();
		int n2 = text2.length();
		
		int[][] dp = new int[n1+1][n2+1];
		
		for(int	i = 0; i<=n1;i++){
			for(int j=0;j<=n2;j++){
				if(i==0 || j==0){
					dp[i][j] = 0;
				}
				else if(text1.charAt(i-1)==text2.charAt(j-1)){
					dp[i][j] = 1+ dp[i-1][j-1];
				}
				
				else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		
		return dp[n1][n2];
		
		
	}
}
// @lc code=end

