/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 *
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (51.55%)
 * Likes:    8668
 * Dislikes: 667
 * Total Accepted:    873.7K
 * Total Submissions: 1.7M
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a
 * point at coordinate (i, ai). n vertical lines are drawn such that the two
 * endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which,
 * together with the x-axis forms a container, such that the container contains
 * the most water.
 * 
 * Notice that you may not slant the container.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array
 * [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the
 * container can contain is 49.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: height = [1,1]
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: height = [4,3,2,1,4]
 * Output: 16
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: height = [1,2,1]
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == height.length
 * 2 <= n <= 3 * 10^4
 * 0 <= height[i] <= 3 * 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int p1 = 0;
        int p2 = height.length-1;
        int max = Integer.MIN_VALUE;
        
        while(p1<p2){
            int currentArea = Math.min(height[p1],height[p2])*(p2-p1);
            max = Math.max(currentArea,max);

            if(height[p1]<height[p2]){
                p1++;
            }else if(height[p2]<height[p1]){
                p2--;
            }
            else{
                p1++;
            }
        }

        return max;
    }
}
// @lc code=end

