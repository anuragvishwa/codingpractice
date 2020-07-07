import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class TopologicalSorting {
	
	private int V;
	
	private ArrayList<ArrayList<Integer>> adjArrayList;
	
	public TopologicalSorting(int v) {
		this.V = v;
		adjArrayList = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<v;i++) {
			adjArrayList.add(new ArrayList<Integer>());
		}
	}
	
	void addEdge(int v,int w) {
		adjArrayList.get(v).add(w);
	}
	
	void topologicalSortUtil(Boolean[] visited,Stack<Integer> stack,int v) {
		
		visited[v]=true;
		
		
		ArrayList<Integer>intemIntegers = adjArrayList.get(v);
		
		if(!intemIntegers.isEmpty()) {
			
			for(int i : intemIntegers) {
				if(!visited[i])
				topologicalSortUtil(visited, stack, i);
			}
		
		}
		
		stack.push(v);	
		
	}
	
	void topologicalSort() {
		Boolean[] visited = new Boolean[V];
		Arrays.fill(visited, false);
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<V;i++) {
			if(visited[i]== false) {
				topologicalSortUtil(visited, stack, i);
			}
		}
		
		 while (stack.isEmpty()==false)  
	            System.out.print(stack.pop() + " ");  
		
		
	}

	public static void main(String[] args) {
		TopologicalSorting tpSort = new TopologicalSorting(6);
		tpSort.addEdge(5, 2);
		tpSort.addEdge(5, 0);
		tpSort.addEdge(4, 0);
		tpSort.addEdge(4, 1);
		tpSort.addEdge(2, 3);
		tpSort.addEdge(3, 1);
		
		System.out.println("Following is a topological sort");
		tpSort.topologicalSort();

	}

}
