/*
 * @lc app=leetcode id=1162 lang=java
 *
 * [1162] As Far from Land as Possible
 *
 * https://leetcode.com/problems/as-far-from-land-as-possible/description/
 *
 * algorithms
 * Medium (43.51%)
 * Likes:    541
 * Dislikes: 29
 * Total Accepted:    22.4K
 * Total Submissions: 51.1K
 * Testcase Example:  '[[1,0,1],[0,0,0],[1,0,1]]'
 *
 * Given an N x N grid containing only values 0 and 1, where 0 represents water
 * and 1 represents land, find a water cell such that its distance to the
 * nearest land cell is maximized and return the distance.
 * 
 * The distance used in this problem is the Manhattan distance: the distance
 * between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 * 
 * If no land or water exists in the grid, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: [[1,0,1],[0,0,0],[1,0,1]]
 * Output: 2
 * Explanation: 
 * The cell (1, 1) is as far as possible from all the land with distance 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: [[1,0,0],[0,0,0],[0,0,0]]
 * Output: 4
 * Explanation: 
 * The cell (2, 2) is as far as possible from all the land with distance
 * 4.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] is 0 or 1
 * 
 * 
 */

// @lc code=start
class Solution {

        int[][] directions = new int[][] {{-1, 0},{1,0},{0,-1},{0,1}};
        public int maxDistance(int[][] grid) {
            int N = grid.length;
            int[][] dist = new int[N][N];
            for (int[] row : dist) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == 1) {
                        q.offer(new int[] {i, j});
                        dist[i][j] = 0;
                    }
                }
            }
            
            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    int[] curr = q.poll();
                    for (int[] dir : directions) {
                        int x = curr[0] + dir[0];
                        int y = curr[1] + dir[1];
                        if (x < 0 || x >= N || y < 0 || y >= N || 
                            dist[x][y] != Integer.MAX_VALUE) {
                            continue;
                        }
                        
                        dist[x][y] = dist[curr[0]][curr[1]] + 1;
                        q.offer(new int[] {x, y});
                    }
                }
            }
            
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == 0 && dist[i][j] != Integer.MAX_VALUE)
                        res = Math.max(res, dist[i][j]);
                }
            }
            
            return res == Integer.MIN_VALUE ? -1 : res;
        }
    
    
}
// @lc code=end

