/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 *
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 *
 * algorithms
 * Medium (47.04%)
 * Likes:    1604
 * Dislikes: 90
 * Total Accepted:    78.9K
 * Total Submissions: 166.7K
 * Testcase Example:  '"ABAB"\n2'
 *
 * Given a string s that consists of only uppercase English letters, you can
 * perform at most k operations on that string.
 * 
 * In one operation, you can choose any character of the string and change it
 * to any other uppercase English character.
 * 
 * Find the length of the longest sub-string containing all repeating letters
 * you can get after performing the above operations.
 * 
 * Note:
 * Both the string's length and k will not exceed 10^4.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * s = "ABAB", k = 2
 * 
 * Output:
 * 4
 * 
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "AABABBA", k = 1
 * 
 * Output:
 * 4
 * 
 * Explanation:
 * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
// @lc code=end

