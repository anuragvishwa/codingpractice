/*
 * @lc app=leetcode id=1553 lang=java
 *
 * [1553] Minimum Number of Days to Eat N Oranges
 *
 * https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/description/
 *
 * algorithms
 * Hard (26.80%)
 * Likes:    274
 * Dislikes: 28
 * Total Accepted:    9.4K
 * Total Submissions: 34.2K
 * Testcase Example:  '10'
 *
 * There are n oranges in the kitchen and you decided to eat some of these
 * oranges every day as follows:
 * 
 * 
 * Eat one orange.
 * If the number of remaining oranges (n) is divisible by 2 then you can eat
 * n/2 oranges.
 * If the number of remaining oranges (n) is divisible by 3 then you can eat
 * 2*(n/3) oranges.
 * 
 * 
 * You can only choose one of the actions per day.
 * 
 * Return the minimum number of days to eat n oranges.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 10
 * Output: 4
 * Explanation: You have 10 oranges.
 * Day 1: Eat 1 orange,  10 - 1 = 9.  
 * Day 2: Eat 6 oranges, 9 - 2*(9/3) = 9 - 6 = 3. (Since 9 is divisible by 3)
 * Day 3: Eat 2 oranges, 3 - 2*(3/3) = 3 - 2 = 1. 
 * Day 4: Eat the last orange  1 - 1  = 0.
 * You need at least 4 days to eat the 10 oranges.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 6
 * Output: 3
 * Explanation: You have 6 oranges.
 * Day 1: Eat 3 oranges, 6 - 6/2 = 6 - 3 = 3. (Since 6 is divisible by 2).
 * Day 2: Eat 2 oranges, 3 - 2*(3/3) = 3 - 2 = 1. (Since 3 is divisible by 3)
 * Day 3: Eat the last orange  1 - 1  = 0.
 * You need at least 3 days to eat the 6 oranges.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 1
 * Output: 1
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: n = 56
 * Output: 6
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 2*10^9
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    private HashMap<Integer,Integer> mp = new HashMap<>();
    public int minDays(int n) {
        if(n <= 2)
            return n;
        if(mp.containsKey(n))
            return mp.get(n);
        
        mp.put(n, 1 + Math.min(n % 2 + minDays(n/2), n % 3 + minDays(n/3)));
        return mp.get(n);
    }
    // public int minDays(int n) {
		
    //     long[] dp = new long[n+1];
        
    //     if(n==1){
    //         return 1;
    //     }
		
		
	// 	dp[0]=0;dp[1]=1;
		
	// 	for(int i = 2 ;i<=n;i++){
		
	// 		dp[i] = dp[i-1];	
			
	// 		if(i%2==0){	
			
	// 			dp[i] = Math.min(dp[i],dp[i-i/2]);
	// 		}
			
	// 		if(i%3 ==0 ){
	// 			dp[i] = Math.min(dp[i],dp[i-2*(i/3)]);
	// 		}	
			
	// 		dp[i] = 1+ dp[i];
			
			
	// 	}
		
    //     return (int)dp[n];
		
      
    // }

    //  int min(int n,HashMap<Integer,Integer> map){
        
    //     if(map.containsKey(n)){
    //         return map.get(n);
    //     }
	// 	if(n==0){
	// 		return 0;
	// 	}
		
	// 	if(n==1){
	// 		return 1;
	// 	}	
		
	// 	//System.out.println(n);
	// 	int one = min(n-1,map);
		
	// 	int two = Integer.MAX_VALUE;
	// 	int three = Integer.MAX_VALUE;
		
	// 	//System.out.println("n=> " + n +" n/2 => " + n/2);
	// 	if(n%2 == 0){
	// 		two = min(n-n/2,map);
	// 	}
		
	// 	if(n%3 == 0){
	// 		three = min(n-2*(n/3),map);
	// 	}
        
    //     int minimum = 1+ Math.min(one,Math.min(two,three));

    //     map.put(n,minimum);
        
	// 	return minimum;
	// }
    
}
// @lc code=end

