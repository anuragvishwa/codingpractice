//Leetcode : https://leetcode.com/problems/maximal-square/submissions/
/* Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        return maximalSquare1(matrix);
    }
    
    static int maximalSquare1(char[][] matrix) {
		if (matrix == null || matrix.length==0)
			return 0;

		int row = matrix.length;
		int col = matrix[0].length;
		int maximal = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				if (matrix[i][j] == '1') {
					int len = getLength(matrix, row, col, i, j, 1);
					if (len > maximal) {
						maximal = len;
					}
				}
			}
		}

		return maximal * maximal;

	}

	static int getLength(char[][] matrix, int row, int col, int i, int j, int length) {

		if (i + length > row || j + length > col) {
			return 0;
		}

		for (int x = i; x < i + length; x++) {
			for (int y = j; y < j + length; y++) {
				if (matrix[x][y] != '1') {
					return 0;
				}
			}

		}

		return 1 + getLength(matrix, row, col, i, j, length + 1);

	}
}
