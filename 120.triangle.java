/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */

// @lc code=start
import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
     
        int n= triangle.size();

        List<Integer> list = new ArrayList<>(triangle.get(triangle.size()-1));

        for(int i=n-2;i>=0;i--){
            List<Integer> temp = triangle.get(i);

            for(int j=0;j<=i;j++){

                list.set(j,Math.min(list.get(j),list.get(j+1))+temp.get(j));
            }

        }

        return list.get(0);


    }
}
// @lc code=end

