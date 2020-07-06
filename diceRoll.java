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
		
		return result;
	}
}
