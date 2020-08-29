/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 *
 * https://leetcode.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (35.77%)
 * Likes:    1344
 * Dislikes: 521
 * Total Accepted:    201.3K
 * Total Submissions: 562.6K
 * Testcase Example:  '"25525511135"'
 *
 * Given a string s containing only digits. Return all possible valid IP
 * addresses that can be obtained from s. You can return them in any order.
 * 
 * A valid IP address consists of exactly four integers, each integer is
 * between 0 and 255, separated by single points and cannot have leading zeros.
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and
 * "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP
 * addresses. 
 * 
 * 
 * Example 1:
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 * Example 2:
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 * Example 3:
 * Input: s = "1111"
 * Output: ["1.1.1.1"]
 * Example 4:
 * Input: s = "010010"
 * Output: ["0.10.0.10","0.100.1.0"]
 * Example 5:
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 3000
 * s consists of digits only.
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0 || s.length() > 12) return result;
        restoreIP(s, 0, result, 3, new StringBuilder());
        return result;    
    }

    void restoreIP(String s,int index,List<String> result,int dots,StringBuilder sb){
        if(dots<0){
            return;
        }

        if(index == s.length() && dots==0){
            result.add(sb.toString());
            return;
        }

        for(int i=index;i<s.length();i++){
            String first = s.substring(index,i+1);

            if(!isValid(first))
                break;

            int len = sb.length();

            //Choose:
            sb.append(first);

            //Explore:
            if(i+1==s.length()){
                restoreIP(s,i+1,result,dots,sb);
            }
            else{
                sb.append(".");
                restoreIP(s,i+1,result,dots-1,sb);
            }

            //Unchoose:
            sb.setLength(len);
        }



    }

    Boolean isValid(String part){
        if (part.length() == 0 || part.length() > 1 && part.charAt(0) == '0' || Integer.valueOf(part) > 255) {
			return false;
		}
		return true;
    }


}
// @lc code=end

