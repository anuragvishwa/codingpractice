/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 *
 * https://leetcode.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (28.67%)
 * Likes:    2422
 * Dislikes: 734
 * Total Accepted:    277.2K
 * Total Submissions: 950.4K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * Example:
 * 
 * 
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * 
 * After running your function, the board should be:
 * 
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * 
 * Explanation:
 * 
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on
 * the border of the board are not flipped to 'X'. Any 'O' that is not on the
 * border and it is not connected to an 'O' on the border will be flipped to
 * 'X'. Two cells are connected if they are adjacent cells connected
 * horizontally or vertically.
 * 
 */

// @lc code=start

class Solution {
    public void solve(char[][] board) {
    if (board.length == 0 || board[0].length == 0) return;
    if (board.length < 3 || board[0].length < 3) return;
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
        if (board[i][0] == 'O') helper(board, i, 0);
        if (board[i][n - 1] == 'O') helper(board, i, n - 1);
    }
    for (int j = 1; j < n - 1; j++) {
        if (board[0][j] == 'O') helper(board, 0, j);
        if (board[m - 1][j] == 'O') helper(board, m - 1, j);
    }
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (board[i][j] == 'O') board[i][j] = 'X';
            if (board[i][j] == '*') board[i][j] = 'O';
        }
    }
}

private void helper(char[][] board, int r, int c) {
    if (r < 0 || c < 0 || r > board.length - 1 || c > board[0].length - 1 || board[r][c] != 'O') return;
    board[r][c] = '*';
    helper(board, r + 1, c);
    helper(board, r - 1, c);
    helper(board, r, c + 1);
    helper(board, r, c - 1);
}
}
// @lc code=end

