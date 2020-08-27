/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (35.71%)
 * Likes:    4181
 * Dislikes: 195
 * Total Accepted:    515.2K
 * Total Submissions: 1.4M
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * Example:
 * 
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * board and word consists only of lowercase and uppercase English letters.
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    public boolean exist(char[][] board, String word) {

        Boolean[][] visited = new Boolean[board.length][board[0].length];
        for (Boolean[] row : visited) 
            Arrays.fill(row, false);

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(word.charAt(0)==board[i][j] && searchWord(board,i,j,visited,word,0)){
                    return true;
                }
            }
        }
        
        return false;
    }

    static Boolean searchWord(char[][] matrix,int i,int j,Boolean[][] visited,String word,int wordIndex){
        if(wordIndex == word.length()){
            return true;
        }

        if(i<0 || j<0 || i>=matrix.length || j>=matrix[i].length || matrix[i][j]!=word.charAt(wordIndex)||visited[i][j]){
            return false;
        }

        visited[i][j]=true;       

        Boolean left = searchWord(matrix,i,j-1,visited,word,wordIndex+1);
        Boolean right = searchWord(matrix,i,j+1,visited,word,wordIndex+1);
        Boolean up = searchWord(matrix,i-1,j,visited,word,wordIndex+1);
        Boolean down = searchWord(matrix,i+1,j,visited,word,wordIndex+1);

        if(left || right ||up ||down){
            return true;
        }

        visited[i][j]=false;
        return false;
    }
}
// @lc code=end

