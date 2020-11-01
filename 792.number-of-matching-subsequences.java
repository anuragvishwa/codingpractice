/*
 * @lc app=leetcode id=792 lang=java
 *
 * [792] Number of Matching Subsequences
 *
 * https://leetcode.com/problems/number-of-matching-subsequences/description/
 *
 * algorithms
 * Medium (47.73%)
 * Likes:    1087
 * Dislikes: 78
 * Total Accepted:    46.9K
 * Total Submissions: 98.2K
 * Testcase Example:  '"abcde"\n["a","bb","acd","ace"]'
 *
 * Given string S and a dictionary of words words, find the number of words[i]
 * that is a subsequence of S.
 * 
 * 
 * Example :
 * Input: 
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * Output: 3
 * Explanation: There are three words in words that are a subsequence of S:
 * "a", "acd", "ace".
 * 
 * 
 * Note:
 * 
 * 
 * All words in words and S will only consists of lowercase letters.
 * The length of S will be in the range of [1, 50000].
 * The length of words will be in the range of [1, 5000].
 * The length of words[i] will be in the range of [1, 50].
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int n = words.length;
        int res = 0;
        Map<String, Boolean> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String curr = words[i];
            if (map.containsKey(curr)) {
                if (map.get(curr)) {
                    res++;
                }
            } else {
                boolean isSub = isSubsequence(S, curr);
                if (isSub) {
                    res++;
                }
                map.put(curr, isSub);
            }
        }
        return res;
    }
    
    private boolean isSubsequence(String S, String word) {
        if (S.length() < word.length()) return false;
        if (S.contains(word)) return true;
        int m = S.length(), n = word.length();
        int i = 0, j = 0;
        
        while (i < m && j < n) {
            char c1 = S.charAt(i);
            char c2 = word.charAt(j);
            if (c1 == c2) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == n;
    
    }
}
// @lc code=end

