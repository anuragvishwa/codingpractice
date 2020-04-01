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
