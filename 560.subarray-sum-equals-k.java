/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 *
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * algorithms
 * Medium (43.84%)
 * Likes:    5372
 * Dislikes: 173
 * Total Accepted:    360.2K
 * Total Submissions: 822.7K
 * Testcase Example:  '[1,1,1]\n2'
 *
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 * 
 * Example 1:
 * 
 * 
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the
 * integer k is [-1e7, 1e7].
 * 
 * 
 */

// @lc code=start
import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length];
		
		int n = nums.length;
		
		prefix[0]=nums[0];
		
		for(int i=1;i<n;i++){
			prefix[i]=nums[i]+prefix[i-1];
		}	
		
		int count=0;
		
		for(int i=0;i<n;i++){
			for(int j=i;j<n;j++){
				if(i==0 && prefix[j]==k){
					count++;
				}
				else{
					if(i>0 && prefix[j]-prefix[i-1]==k){
						count++;
						
					}
				}
			}			
			
		}
		
	return count;	
	}
               
            }
    
    

// @lc code=end

