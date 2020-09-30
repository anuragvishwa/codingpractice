/*
 * @lc app=leetcode id=809 lang=java
 *
 * [809] Expressive Words
 *
 * https://leetcode.com/problems/expressive-words/description/
 *
 * algorithms
 * Medium (46.99%)
 * Likes:    357
 * Dislikes: 900
 * Total Accepted:    51.3K
 * Total Submissions: 109.2K
 * Testcase Example:  '"heeellooo"\n["hello", "hi", "helo"]'
 *
 * Sometimes people repeat letters to represent extra feeling, such as "hello"
 * -> "heeellooo", "hi" -> "hiiii".  In these strings like "heeellooo", we have
 * groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".
 * 
 * For some given string S, a query word is stretchy if it can be made to be
 * equal to S by any number of applications of the following extension
 * operation: choose a group consisting of characters c, and add some number of
 * characters c to the group so that the size of the group is 3 or more.
 * 
 * For example, starting with "hello", we could do an extension on the group
 * "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has
 * size less than 3.  Also, we could do another extension like "ll" -> "lllll"
 * to get "helllllooo".  If S = "helllllooo", then the query word "hello" would
 * be stretchy because of these two extension operations: query = "hello" ->
 * "hellooo" -> "helllllooo" = S.
 * 
 * Given a list of query words, return the number of words that are
 * stretchy. 
 * 
 * 
 * 
 * 
 * Example:
 * Input: 
 * S = "heeellooo"
 * words = ["hello", "hi", "helo"]
 * Output: 1
 * Explanation: 
 * We can extend "e" and "o" in the word "hello" to get "heeellooo".
 * We can't extend "helo" to get "heeellooo" because the group "ll" is not size
 * 3 or more.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= len(S) <= 100.
 * 0 <= len(words) <= 100.
 * 0 <= len(words[i]) <= 100.
 * S and all words in words consist only of lowercase letters
 * 
 * 
 */

// @lc code=start
class Solution {
    public int expressiveWords(String S, String[] words) {
        
        int res = 0;

		for(String word:words){
			
            if(check(S,word)){
                res++;
            }
		}
			return res;
			
        }
        
        public boolean check(String S, String word){
            int i=0;
            int j=0;
            while(i<S.length() && j<word.length()){
				
				if(S.charAt(i)!=word.charAt(j)){
                    return false;
                }
					
					int e1 = i;
					int e2 = j;
					
					while(e1<S.length() && S.charAt(e1)==S.charAt(i)){
						e1++;
					}
					
					while(e2<word.length() && word.charAt(e2)==word.charAt(j)){
						e2++;
					}
					
					int n1 = e1-i;
					int n2 = e2-j;
					
					//Conditions:
					if(n1<n2 || n1 < 3 && n2!=n1){
                        return false;
                    }

					i=e1;
					j=e2;
					
                }

            if(i==S.length() && j==word.length()){
                return true;
            }
            else{
                return false;
            }

        }
}

// @lc code=end

