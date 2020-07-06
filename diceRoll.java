//https://leetcode.com/problems/number-of-dice-rolls-with-target-sum
//Recursive

class Solution {
    
    public int numRollsToTarget(int d, int f, int target) {
    
        return diceRoll(d,f,target);
    }
    
    int diceRoll(int d,int f,int target) {
		
		if(d==0) {
			if(target==0) {
				return 1;
			}
			else return 0;
		}
		
		int result = 0;
		
		for(int i=1;i<=f;i++) {
			
			result = result + diceRoll(d-1, f, target-i);
			
		}
		
		return result % 1000000007;
	}
}

//Bottom up : Dynamic programming solution:-

//Time: O(d*target*f)
//Space: O(d*target)
class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        if(target>f*d) return 0;
        
        int modulo = (int)Math.pow(10,9)+7;
        
        int[][] dp = new int[d+1][target+1];
        dp[0][0] = 1;
        
        for(int i=1;i<=d;i++){
            for(int j=0;j<=target;j++){
                for(int k=1;k<=f;k++){
                    if(j-k<0) continue; //because [j-k] needs to be within the bounds of dp, that is, it needs to be greater than or equal to 0 
                    dp[i][j] = (dp[i][j] + dp[i-1][j-k])% modulo;
                }
            }
        }
        
        return dp[d][target];
    }
}
