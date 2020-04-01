// https://leetcode.com/problems/minimum-path-sum/
/* Given a m x n grid filled with non-negative numbers,
find a path from top left to bottom right which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.*/

//Recursive Solution : Bottom Up

public class MinPathSum {
	
	

	public static void main(String[] args) {
		int matrix[][] = {
				{1,3,1},{1,5,1},{4,2,1}
		};
		
		int col = matrix[0].length;
		int row = matrix.length;
		
		System.out.println(mps(matrix, 0, 0, row, col));


	}
	
	static int mps(int[][] matrix,int i,int j,int row,int col) {
		System.out.println( " " + "i "+i +" j "+j);
	
		
		
		if(i == row-1 && j == col-1) {
			return matrix[i][j];
		}
		
		if(i <row-1 && j < col-1) {
		
		

		int right = matrix[i][j] + mps(matrix, i+1, j, row, col);
		
	
	

		int down = matrix[i][j] + mps(matrix, i, j+1, row, col);
		

		
		return Math.min(right, down);
		
		}
		
		
		if(i<row-1) {
			
			return matrix[i][j]+ mps(matrix, i+1 , j, row, col);
			
			
		}
		
		if(j<col-1) {
			return matrix[i][j]+ mps(matrix, i, j+1, row, col);
		}
		
		return 0;
	}

}

//Top Down
class Solution {
    public int minPathSum(int[][] grid) {
        return  mps(grid,grid.length-1,grid[0].length-1);
  }
    
   static int mps(int[][] matrix,int i,int j) {
		System.out.println( " " + "i "+i +" j "+j);
	
		
		
		if(i == 0 && j == 0) {
			return matrix[i][j];
		}
		
		if(i > 0 && j > 0) {
		
		

		int right = matrix[i][j] + mps(matrix, i-1, j);
		
	
	

		int down = matrix[i][j] + mps(matrix, i, j-1);
		

		
		return Math.min(right, down);
		
		}
		
		
		if(i>0) {
			
			return matrix[i][j]+ mps(matrix, i-1 , j);
			
			
		}
		
		if(j>0) {
			return matrix[i][j]+ mps(matrix, i, j-1);
		}
		
		return 0;
	}
}

//Dynamic Programming Solution
public class MinPathSum {
	
	public static void main(String[] args) {
		int matrix[][] = {
				{1,2,5},{3,2,1}
		};
		
		int col = matrix[0].length;
		int row = matrix.length;
		
		int sol[][]= new int[matrix.length][matrix[0].length];
		
		System.out.println(mps(matrix,row, col,sol));

	}
	
	static int mps(int[][] matrix,int row,int col,int[][] sol) {

		
		sol[0][0] = matrix[0][0];
		//filling rows:
		for(int i = 1;i<col;i++) {
			sol[0][i] = sol[0][i-1] + matrix[0][i]; 
		}
		
		//filling columns
		for(int j = 1;j<row;j++) {
			sol[j][0] = sol[j-1][0] + matrix[j][0]; 
		}
		
		//filling others
		
		for(int k=1;k<row;k++) {
			for(int l=1;l<col;l++) {
				sol[k][l]= Math.min(sol[k-1][l], sol[k][l-1]) + matrix[k][l];
			}
		}
				
				return sol[row-1][col-1];
	}
}
