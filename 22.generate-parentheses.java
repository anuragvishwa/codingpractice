/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
    
        char[] c = new char[n*2];
        List<String> str = new ArrayList<String>();
        addParens(str,n,n,c,0);

        return str;

    }

    static void addParens(List<String> list,int leftRem,int rightRem,char[] c,int index){
        //Backtracking condition
        if(leftRem<0 || rightRem<leftRem){
            return;
        }

        if(leftRem ==0 && rightRem == 0){
            String s = String.valueOf(c);
            list.add(s);
        }
        else{

        c[index] = '(';
        addParens(list,leftRem-1,rightRem,c,index+1);

        c[index] = ')';
        addParens(list,leftRem,rightRem-1,c,index+1);
        
    }

    }

   

}
// @lc code=end

