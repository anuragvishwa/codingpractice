/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 *
 * https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 *
 * algorithms
 * Medium (41.27%)
 * Likes:    1434
 * Dislikes: 294
 * Total Accepted:    83K
 * Total Submissions: 200K
 * Testcase Example:  '[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]'
 *
 * Given an m x n matrix of non-negative integers representing the height of
 * each unit cell in a continent, the "Pacific ocean" touches the left and top
 * edges of the matrix and the "Atlantic ocean" touches the right and bottom
 * edges.
 * 
 * Water can only flow in four directions (up, down, left, or right) from a
 * cell to another one with height equal or lower.
 * 
 * Find the list of grid coordinates where water can flow to both the Pacific
 * and Atlantic ocean.
 * 
 * Note:
 * 
 * 
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Given the following 5x5 matrix:
 * 
 * ⁠ Pacific ~   ~   ~   ~   ~ 
 * ⁠      ~  1   2   2   3  (5) *
 * ⁠      ~  3   2   3  (4) (4) *
 * ⁠      ~  2   4  (5)  3   1  *
 * ⁠      ~ (6) (7)  1   4   5  *
 * ⁠      ~ (5)  1   1   2   4  *
 * ⁠         *   *   *   *   * Atlantic
 * 
 * Return:
 * 
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with
 * parentheses in above matrix).
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    private static final int[][] DIRECTIONS = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] ableToReachPacific = new boolean[rows][cols];
        boolean[][] ableToReachAtlantic = new boolean[rows][cols];
        
        for (int i = 0; i < cols; i++) {
            dfs(matrix, 0 , i, ableToReachPacific, Integer.MIN_VALUE);
            dfs(matrix, rows - 1 , i, ableToReachAtlantic, Integer.MIN_VALUE);
        }
        
        for (int i = 0; i < rows; i++) {
            dfs(matrix, i, 0, ableToReachPacific, Integer.MIN_VALUE);
            dfs(matrix, i, cols - 1, ableToReachAtlantic, Integer.MIN_VALUE);
        }
        
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (ableToReachPacific[i][j] && ableToReachAtlantic[i][j])
                    res.add(Arrays.asList(i, j));
        
        return res;
    }
    
    
    private boolean outOfBounds(int x, int y, int[][] matrix) {
        return x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length;
    }
    
    
    private void dfs(int[][]matrix, int i, int j, boolean[][] ableToReach, int prev) {
        if (outOfBounds(i, j, matrix) || matrix[i][j] < prev || ableToReach[i][j]) return;
        ableToReach[i][j] = true;
        for (int[] dir : DIRECTIONS) {
            int newI = i + dir[0], newJ = j + dir[1];
            dfs(matrix, newI, newJ, ableToReach, matrix[i][j]);
        }
    }
}
// @lc code=end

