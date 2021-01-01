/*
 * @lc app=leetcode id=815 lang=java
 *
 * [815] Bus Routes
 *
 * https://leetcode.com/problems/bus-routes/description/
 *
 * algorithms
 * Hard (43.01%)
 * Likes:    957
 * Dislikes: 31
 * Total Accepted:    43.9K
 * Total Submissions: 101.8K
 * Testcase Example:  '[[1,2,7],[3,6,7]]\n1\n6'
 *
 * We have a list of bus routes. Each routes[i] is a bus route that the i-th
 * bus repeats forever. For example if routes[0] = [1, 5, 7], this means that
 * the first bus (0-th indexed) travels in the sequence
 * 1->5->7->1->5->7->1->... forever.
 * 
 * We start at bus stop S (initially not on a bus), and we want to go to bus
 * stop T. Travelling by buses only, what is the least number of buses we must
 * take to reach our destination? Return -1 if it is not possible.
 * 
 * 
 * Example:
 * Input: 
 * routes = [[1, 2, 7], [3, 6, 7]]
 * S = 1
 * T = 6
 * Output: 2
 * Explanation: 
 * The best strategy is take the first bus to the bus stop 7, then take the
 * second bus to the bus stop 6.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 10^5.
 * 0 <= routes[i][j] < 10 ^ 6.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
       	Map<Integer,Set<Integer>> map = new HashMap<>();
		int busCount = 0;
		Set<Integer> set = new HashSet<Integer>();
        if (S==T) return 0; 
		
		for(int[] route : routes){
			
			
			for(int i=0;i<route.length;i++){
				map.putIfAbsent(route[i],new HashSet<Integer>());
				Set<Integer> temp = map.get(route[i]);
				temp.add(busCount);
				map.put(route[i],temp);
			}
			
			busCount++;
		}	
		
		return bfs(S,T,map,set,routes);

	}
	
	 int bfs(int S,int T,Map<Integer,Set<Integer>> map,Set<Integer> visited,int[][] routes){
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(S);
		int length = 0;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			length++;
			for(int i=0;i<size;i++){
				int route = queue.poll();
				
				Set<Integer> temp = map.get(route);
				
				for(int t : temp){
					if(!visited.contains(t)){
						visited.add(t);
						
						for(int j=0;j<routes[t].length;j++){
							if(routes[t][j] == T){
								return length;
							}
							queue.offer(routes[t][j]);
						}
					}
				}
			
			}
			
			
				
		}
		
		return -1;
		
	
    }
}
// @lc code=end

