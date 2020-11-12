/*
 * @lc app=leetcode id=1345 lang=java
 *
 * [1345] Jump Game IV
 *
 * https://leetcode.com/problems/jump-game-iv/description/
 *
 * algorithms
 * Hard (39.77%)
 * Likes:    301
 * Dislikes: 21
 * Total Accepted:    15K
 * Total Submissions: 37.5K
 * Testcase Example:  '[100,-23,-23,404,100,23,23,23,3,404]'
 *
 * Given an array of integers arr, you are initially positioned at the first
 * index of the array.
 * 
 * In one step you can jump from index i to index:
 * 
 * 
 * i + 1 where: i + 1 < arr.length.
 * i - 1 where: i - 1 >= 0.
 * j where: arr[i] == arr[j] and i != j.
 * 
 * 
 * Return the minimum number of steps to reach the last index of the array.
 * 
 * Notice that you can not jump outside of the array at any time.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
 * Output: 3
 * Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that
 * index 9 is the last index of the array.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: arr = [7]
 * Output: 0
 * Explanation: Start index is the last index. You don't need to jump.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: arr = [7,6,9,6,9,6,9,7]
 * Output: 1
 * Explanation: You can jump directly from index 0 to index 7 which is last
 * index of the array.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: arr = [6,1,9]
 * Output: 2
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: arr = [11,22,7,7,7,7,7,7,7,22,13]
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr.length <= 5 * 10^4
 * -10^8 <= arr[i] <= 10^8
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
		
		Map<Integer,LinkedList<Integer>> map = new HashMap<>();		
		
		for(int i=0;i<arr.length;i++){
		
			LinkedList<Integer> temp = map.get(arr[i]);
			if(temp!=null){
				temp.add(i);
				map.put(arr[i],temp);
			}
			else{
				temp = new LinkedList<>();
				temp.add(i);
				map.put(arr[i],temp);
			}
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(0);
		int steps = 0;
		boolean[] visited = new boolean[n];
		
		visited[0]=true;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			
			while(size-- >0){
				int i = queue.poll();
				if(i==n-1){
					
					return steps;
				}
				
				List<Integer> next = map.get(arr[i]);
				next.add(i-1);
				next.add(i+1);
				
				for(int j : next){
					if(j>=0 && j<n && !visited[j]){
						visited[j]=true;
						queue.offer(j);
					}
				}	
				
				next.clear();
			}
			
			steps++;
		}
		
		return 0;
	
    }
}
// @lc code=end

