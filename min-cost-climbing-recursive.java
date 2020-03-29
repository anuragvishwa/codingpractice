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
