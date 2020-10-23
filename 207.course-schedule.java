/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 *
 * https://leetcode.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (43.66%)
 * Likes:    4571
 * Dislikes: 195
 * Total Accepted:    480.5K
 * Total Submissions: 1.1M
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should
 * also have finished course 1. So it is impossible.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input
 * prerequisites.
 * 1 <= numCourses <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null || prerequisites.length==0 || prerequisites[0].length==0){
			return true;
		}
		//Build Graph
		
		LinkedList<Integer>[] adjList = new LinkedList[numCourses];
		
		for(int i=0;i<numCourses;i++){
			adjList[i] = new LinkedList<>();
		}
		
		for(int[] i : prerequisites){
			int pre = i[1];
			int course = i[0];		
			adjList[course].add(pre);
			
		}
		
		//Find the cycle:
		int[] visited = new int[numCourses];
		
		for(int i=0;i<numCourses;i++){
			//if there is a cycle return false
			if(dfs(adjList,visited,i))
				return false;
		}
		
		return true;
    }

    boolean dfs(LinkedList<Integer>[] adjList,int[] visited,int v){
	
		if(visited[v]==2){
			return false;
		}
		if(visited[v]==1){
			return true;
		}
		//visit v:
		visited[v] = 1;
		
		//visit the neighbours:
		
		for(int i: adjList[v]){
			if(dfs(adjList,visited,i)){
				return true;
			}
		}
		
		visited[v] = 2;//visited all
		return false;
	}
}
// @lc code=end

