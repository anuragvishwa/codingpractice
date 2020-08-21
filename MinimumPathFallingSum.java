//Recursive:
class Solution {
    public int minFallingPathSum(int[][] A) {
        int min = Integer.MAX_VALUE;

		for (int col = 0; col < A.length; col++) {
			min = Math.min(min, minSum(A, 0, col));
		}

		return min;
    }
    
    static int minSum(int[][] matrix, int i, int j) {
		int n = matrix.length;

		if (j == n || j < 0) {
			return Integer.MAX_VALUE;
		}

		if (i == n - 1) {
			return matrix[i][j];
		}

		int sum = matrix[i][j] + Math.min(minSum(matrix, i + 1, j - 1),
				Math.min(minSum(matrix, i + 1, j), minSum(matrix, i + 1, j + 1)));


		return sum;
	}

}
//T.C : O(3^N)

//Memoization Solution:
class Solution {
    public int minFallingPathSum(int[][] A) {
        int min = Integer.MAX_VALUE;
        int memo[][] = new int[A.length][A.length];

		for (int col = 0; col < A.length; col++) {
			min = Math.min(min, minSum(A, 0, col,memo));
		}

		return min;
    }
    
    static int minSum(int[][] matrix, int i, int j, int[][] memo) {
		int n = matrix.length;

		if (j == n || j < 0) {
			return Integer.MAX_VALUE;
		}

		if (i == n - 1) {
			return matrix[i][j];
		}

		if (memo[i][j] != 0) {
			return memo[i][j];
		}

		int sum = matrix[i][j] + Math.min(minSum(matrix, i + 1, j - 1, memo),
				Math.min(minSum(matrix, i + 1, j, memo), minSum(matrix, i + 1, j + 1, memo)));

		memo[i][j] = sum;

		return sum;
	}

}

//T.C : O(N^2)

//Bottom Up:
class Solution {
    public int minFallingPathSum(int[][] A) {
    
        return minSumDP(A);
    }
    
    static int minSumDP(int[][] matrix) {
		int n = matrix.length;

		int dp[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			dp[0][i] = matrix[0][i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {

				int x = (j - 1 < 0) ? Integer.MAX_VALUE : dp[i - 1][j - 1];
				int y = (j + 1 >= n) ? Integer.MAX_VALUE : dp[i - 1][j + 1];
				int z = dp[i - 1][j];

				dp[i][j] = matrix[i][j] + Math.min(x, Math.min(y, z));

			}
		}

		System.out.println(Arrays.deepToString(dp));
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			min = Math.min(min, dp[n - 1][i]);
		}

		return min;
	}


}
