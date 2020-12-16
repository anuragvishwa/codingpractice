/*
 * @lc app=leetcode id=503 lang=java
 *
 * [503] Next Greater Element II
 *
 * https://leetcode.com/problems/next-greater-element-ii/description/
 *
 * algorithms
 * Medium (57.26%)
 * Likes:    1966
 * Dislikes: 83
 * Total Accepted:    116.1K
 * Total Submissions: 200.8K
 * Testcase Example:  '[1,2,1]'
 *
 * 
 * Given a circular array (the next element of the last element is the first
 * element of the array), print the Next Greater Number for every element. The
 * Next Greater Number of a number x is the first greater number to its
 * traversing-order next in the array, which means you could search circularly
 * to find its next greater number. If it doesn't exist, output -1 for this
 * number.
 * 
 * 
 * Example 1:
 * 
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2; The number 2 can't find
 * next greater number; The second 1's next greater number needs to search
 * circularly, which is also 2.
 * 
 * 
 * 
 * Note:
 * The length of given array won't exceed 10000.
 * 
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
		int result[] = new int[nums.length];
		
		int n = nums.length;
		
		for(int i = n-1 ; i>=0;i--){
			stack.push(i);
		}
		
		for(int i= n-1; i>=0; i--){
			
			result[i] = -1;
			
			while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
				stack.pop();
			}
			
			if(!stack.isEmpty()){
				result[i] = nums[stack.peek()];
			}
			
			stack.add(i);
			
		}		
	return result;		
    }
}
// @lc code=end

