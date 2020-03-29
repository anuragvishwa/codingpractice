//Problem : https://leetcode.com/problems/min-cost-climbing-stairs/
/* On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3]. */

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        return minCost(cost,-1,0);
        
    }
    
      int minCost(int[] cost,int i,int sum){
	        
	        
	        
	        System.out.println(i+" i "+sum+" sum ");
	        
	        
	        if(i<cost.length-2) {	
	        
	        int route1 = minCost(cost,i+1,sum+cost[i+1]);
	        int route2 = minCost(cost,i+2,sum+cost[i+2]);
	        
	        return Math.min(route1,route2);
	        
	        }
	        
	        return sum;
	     
	    }
}

//Dynamic Programming Solution:
public class StaircaseDP {
	
	public static void main(String[] args) {
		
		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		
		System.out.println(minCost(cost));
		
	}
	
	 static int minCost(int[] cost){
	        
		 	int l = cost.length;
	        int[] dp = new int[l];
	        dp[0] = cost[0];
	        dp[1] = cost[1];
	        
	        for(int i=2;i<l;i++) {
	        	dp[i]= Math.min(dp[i-1], dp[i-2])+cost[i];
	        }
	        
	        return Math.min(dp[l-1], dp[l-2]);
	    }
	

}
