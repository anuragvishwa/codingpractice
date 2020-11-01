/*
 * @lc app=leetcode id=767 lang=java
 *
 * [767] Reorganize String
 *
 * https://leetcode.com/problems/reorganize-string/description/
 *
 * algorithms
 * Medium (49.37%)
 * Likes:    2118
 * Dislikes: 98
 * Total Accepted:    104.6K
 * Total Submissions: 211.6K
 * Testcase Example:  '"aab"'
 *
 * Given a string S, check if the letters can be rearranged so that two
 * characters that are adjacent to each other are not the same.
 * 
 * If possible, output any possible result.  If not possible, return the empty
 * string.
 * 
 * Example 1:
 * 
 * 
 * Input: S = "aab"
 * Output: "aba"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: S = "aaab"
 * Output: ""
 * 
 * 
 * Note:
 * 
 * 
 * S will consist of lowercase letters and have length in range [1, 500].
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public String reorganizeString(String S) {
        Map<Character,Integer> map = new HashMap<>();
		
		for(char c : S.toCharArray()){
			map.put(c,map.getOrDefault(c,0)+1);
		}
		
		PriorityQueue<Character> pq = new PriorityQueue<>((a,b)-> map.get(b)-map.get(a));
		pq.addAll(map.keySet());
		
		StringBuilder result = new StringBuilder();
		
		while(pq.size()>1){
			char current = pq.remove();
			char next = pq.remove();
			
			result.append(current);
			result.append(next);
			
			
			//decrement their counts:
			map.put(current,map.get(current)-1);
			map.put(next,map.get(next)-1);
			
			if(map.get(current)>0){
				pq.add(current);
			}
			
			if(map.get(next)>0){
				pq.add(next);
			}
			
		}
		
		if(!pq.isEmpty()){
			char last = pq.remove();
			
			if(map.get(last)>1){
				
				return "";
			}
			
			result.append(last);
		}
			
				
		return result.toString();
    }
    }

// @lc code=end

