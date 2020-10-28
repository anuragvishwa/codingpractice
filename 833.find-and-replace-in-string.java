/*
 * @lc app=leetcode id=833 lang=java
 *
 * [833] Find And Replace in String
 *
 * https://leetcode.com/problems/find-and-replace-in-string/description/
 *
 * algorithms
 * Medium (51.01%)
 * Likes:    374
 * Dislikes: 453
 * Total Accepted:    49K
 * Total Submissions: 96.1K
 * Testcase Example:  '"abcd"\n[0, 2]\n["a", "cd"]\n["eee", "ffff"]'
 *
 * To some string S, we will perform some replacement operations that replace
 * groups of letters with new ones (not necessarily the same size).
 * 
 * Each replacement operation has 3 parameters: a starting index i, a source
 * word x and a target word y.  The rule is that if x starts at position i in
 * the original string S, then we will replace that occurrence of x with y.  If
 * not, we do nothing.
 * 
 * For example, if we have S = "abcd" and we have some replacement operation i
 * = 2, x = "cd", y = "ffff", then because "cd" starts at position 2 in the
 * original string S, we will replace it with "ffff".
 * 
 * Using another example on S = "abcd", if we have both the replacement
 * operation i = 0, x = "ab", y = "eee", as well as another replacement
 * operation i = 2, x = "ec", y = "ffff", this second operation does nothing
 * because in the original string S[2] = 'c', which doesn't match x[0] = 'e'.
 * 
 * All these operations occur simultaneously.  It's guaranteed that there won't
 * be any overlap in replacement: for example, S = "abc", indexes = [0, 1],
 * sources = ["ab","bc"] is not a valid test case.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: S = "abcd", indexes = [0, 2], sources = ["a", "cd"], targets =
 * ["eee", "ffff"]
 * Output: "eeebffff"
 * Explanation:
 * "a" starts at index 0 in S, so it's replaced by "eee".
 * "cd" starts at index 2 in S, so it's replaced by "ffff".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: S = "abcd", indexes = [0, 2], sources = ["ab","ec"], targets =
 * ["eee","ffff"]
 * Output: "eeecd"
 * Explanation:
 * "ab" starts at index 0 in S, so it's replaced by "eee".
 * "ec" doesn't starts at index 2 in the original S, so we do nothing.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= S.length <= 1000
 * S consists of only lowercase English letters.
 * 0 <= indexes.length <= 100
 * 0 <= indexes[i] < S.length
 * sources.length == indexes.length
 * targets.length == indexes.length
 * 1 <= sources[i].length, targets[i].length <= 50
 * sources[i] and targets[i] consist of only lowercase English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        Map<Integer, String[]> map = new HashMap<>();
        for (int i = 0; i < sources.length; i++) {
            map.put(indexes[i], new String[]{sources[i], targets[i]});
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (map.containsKey(i)) {
                String source = map.get(i)[0];
                int len = source.length();
                if (i + len <= S.length() && S.substring(i, i + len).equals(source)) {
                    builder.append(map.get(i)[1]);
                    i += len - 1;
                } else {
                    builder.append(S.charAt(i));
                }
            } else {
                builder.append(S.charAt(i));
            }
        }

        return builder.toString();
    
    }
}
// @lc code=end

