/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 *
 * https://leetcode.com/problems/interleaving-string/description/
 *
 * algorithms
 * Hard (31.59%)
 * Likes:    1564
 * Dislikes: 91
 * Total Accepted:    159.8K
 * Total Submissions: 504.5K
 * Testcase Example:  '"aabcc"\n"dbbca"\n"aadbbcbcac"'
 *
 * Given s1, s2, and s3, find whether s3 is formed by the interleaving of s1
 * and s2.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s1 = "", s2 = "", s3 = ""
 * Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1, s2, and s3 consist of lower-case English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        // HashSet<String> set = new HashSet<String>();
        // return (interleaving(s1,s2,s3,0,0,0,set));
        int m = s1.length(), n = s2.length(), l = s3.length();
        if (m + n != l) return false;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i < m; i++) {
            dp[i+1][0] = dp[i][0] && s1.charAt(i) == s3.charAt(i);
        }
        
        for (int i = 0; i < n; i++) {
            dp[0][i+1] = dp[0][i] && s2.charAt(i) == s3.charAt(i);
        }
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i * j == 0) continue;
                if (s3.charAt(i + j - 1) == s1.charAt(i - 1)) dp[i][j] = dp[i][j] || dp[i - 1][j];
                if (s3.charAt(i + j - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i][j] || dp[i][j - 1];
            }
        }
        return dp[m][n];
        
    }
    //Bottom up solution:
    

    //Memoization solution:
    Boolean interleaving(String s1, String s2, String s3, int i, int j, int k,HashSet<String> set) {
		
		if(set.contains(i+""+j+""+k)){
			return false;
		}
		
		if(j == s1.length() ){
			return s2.substring(k).equals(s3.substring(i));
		}
		if(k == s2.length() ){
			return s1.substring(j).equals(s3.substring(i));
		}
		
		set.add(i+""+j+""+k);
		
		Boolean path1 = false;
		Boolean path2 = false;
		
		if(s1.charAt(j) == s3.charAt(i)){
			path1 =  interleaving(s1,s2,s3,i+1,j+1,k,set);
		}
		
		if(s2.charAt(k) == s3.charAt(i)){
			path2 = interleaving(s1,s2,s3,i+1,j,k+1,set);
		}
		
			
		return path1 || path2;

	}
}
// @lc code=end

