/*
 * @lc app=leetcode id=299 lang=java
 *
 * [299] Bulls and Cows
 *
 * https://leetcode.com/problems/bulls-and-cows/description/
 *
 * algorithms
 * Medium (43.84%)
 * Likes:    832
 * Dislikes: 978
 * Total Accepted:    194.6K
 * Total Submissions: 443.6K
 * Testcase Example:  '"1807"\n"7810"'
 *
 * You are playing the Bulls and Cows game with your friend.
 * 
 * You write down a secret number and ask your friend to guess what the number
 * is. When your friend makes a guess, you provide a hint with the following
 * info:
 * 
 * 
 * The number of "bulls", which are digits in the guess that are in the correct
 * position.
 * The number of "cows", which are digits in the guess that are in your secret
 * number but are located in the wrong position. Specifically, the non-bull
 * digits in the guess that could be rearranged such that they become bulls.
 * 
 * 
 * Given the secret number secret and your friend's guess guess, return the
 * hint for your friend's guess.
 * 
 * The hint should be formatted as "xAyB", where x is the number of bulls and y
 * is the number of cows. Note that both secret and guess may contain duplicate
 * digits.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: secret = "1807", guess = "7810"
 * Output: "1A3B"
 * Explanation: Bulls are connected with a '|' and cows are underlined:
 * "1807"
 * ⁠ |
 * "7810"
 * 
 * Example 2:
 * 
 * 
 * Input: secret = "1123", guess = "0111"
 * Output: "1A1B"
 * Explanation: Bulls are connected with a '|' and cows are underlined:
 * "1123"        "1123"
 * ⁠ |      or     |
 * "0111"        "0111"
 * Note that only one of the two unmatched 1s is counted as a cow since the
 * non-bull digits can only be rearranged to allow one 1 to be a bull.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: secret = "1", guess = "0"
 * Output: "0A0B"
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: secret = "1", guess = "1"
 * Output: "1A0B"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= secret.length, guess.length <= 1000
 * secret.length == guess.length
 * secret and guess consist of digits only.
 * 
 * 
 */

// @lc code=start
class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> h = new HashMap();
        for (char s : secret.toCharArray()) {
            h.put(s, h.getOrDefault(s, 0) + 1);
        }
            
        int bulls = 0, cows = 0;
        int n = guess.length();
        for (int idx = 0; idx < n; ++idx) {
            char ch = guess.charAt(idx);
            if (h.containsKey(ch)) {
                // corresponding characters match
                if (ch == secret.charAt(idx)) {
                    // update the bulls
                    bulls++;
                    // update the cows 
                    // if all ch characters from secret 
                    // were used up
                    if (h.get(ch) <= 0)
                        cows--;    
                // corresponding characters don't match
                } else {
                    // update the cows
                    if (h.get(ch) > 0)
                        cows++;     
                }
                // ch character was used
                h.put(ch, h.get(ch) - 1); 
            }
        }
                
        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }

    
}
// @lc code=end

