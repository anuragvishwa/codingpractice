public class CycleDetectionDirectedGraph {
    static class Graph{
		int v;
		LinkedList<Integer> adjList[];
		
		Graph(int v){
			this.v = v;
			adjList = new LinkedList[v];
			for(int i=0;i<v;i++){
				adjList[i] = new LinkedList<Integer>();
			}
		}
		
		void addEdge(int src,int dest){
			adjList[src].add(dest);
		}			
	}
	
	static boolean isCyclic(Graph graph,int v){
		Boolean[] visited = new Boolean[v];
		Boolean[] recStack = new Boolean[v];
		
		Arrays.fill(visited,false);
		Arrays.fill(recStack,false);
				
		for(int i=0;i<v;i++){
			if(cycleUtil(graph,visited,recStack,i)){
				return true;
			}
		}
		
		return false;
	}
	
	static boolean cycleUtil(Graph graph,Boolean[] visited,Boolean[] recStack,int i){
		
		if(recStack[i]){
			return true;
		}
		
		if(visited[i]){
			return false;
		}
		
		recStack[i]=true;
		visited[i]=true;
				
		Iterator<Integer> it = graph.adjList[i].listIterator();
		
		while(it.hasNext()){

			int v = it.next();
			if(cycleUtil(graph,visited,recStack,v)){
				return true;
			}
			
		}
		
		recStack[i] = false;
		
		return false;
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(4); 
        graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(1, 2); 
        graph.addEdge(2, 0); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 3); 
       		
		System.out.println(isCyclic(graph,4));
		
	}
}
