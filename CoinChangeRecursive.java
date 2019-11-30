// Problem : You are given coins of different denominations 
// and a total amount of money.
// Write a function to compute the number of combinations that make up that amount. 
// You may assume that you have infinite number of each kind of coin.

//https://leetcode.com/problems/coin-change-2/

static int getCoinChange(int[] coins,int amount,int i) {
		
		if(amount==0) 
			return 1;
		
		
		if(i>=coins.length)
			return 0;
		
		if(amount<0)
			return 0;
		
		
		return (getCoinChange(coins, amount-coins[i], i)
				+ getCoinChange(coins, amount, i+1));
	}
