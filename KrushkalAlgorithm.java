import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KrushkalAlgorithm {
	
	static class Edge{
		int source;
		int destination;
		int weight;
		 
		 public Edge(int source,int destination,int weight){
		 	this.source = source;
		 	this.destination = destination;
		 	this.weight = weight;
		 }
		
	}
	
	static class Graph{
		int vertices;
		ArrayList<Edge> allEdges = new ArrayList<Edge>();
		
		Graph(int vertices){
			this.vertices = vertices;
		}
		
		public void addEdge(int source,int destination,int weight){
			Edge edge = new Edge(source,destination,weight);
			allEdges.add(edge);
		}
		
		
		public void kruskalMST(){
			//To sort the edges on the basis of weight:
			PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(),Comparator.comparingInt(o -> o.weight));
			//add edges to priority queue and sort them:
			for(int i=0;i<allEdges.size();i++){
				pq.add(allEdges.get(i));
			}
			
			//create a parent :
			int[] parent = new int[vertices];
			makeSet(parent);
			
			ArrayList<Edge> mst = new ArrayList<Edge>();
			
			
			//process vertices - 1 edges:Because MST needs to have the same-
			int index = 0;
			
			while(index<vertices-1){
			
				Edge edge = pq.remove();
				
				//check if adding this edge creates a cycle:
				int x_set = find(parent,edge.source);
				int y_set = find(parent,edge.destination);
				
				if(x_set == y_set){
				//ignore will lead to cycle:
				}else{
					//add it to final result:
					mst.add(edge);
					index++;
					union(parent,x_set,y_set);					
				}
				
			}
		
		//printMST:
		System.out.println("Minimum spanning tree is:\t\n");
		printGraph(mst);
					
		}
		
		public void printGraph(ArrayList<Edge> edgeList){
			for(int i=0;i<edgeList.size();i++){
				Edge edge = edgeList.get(i);
				System.out.println("Edge-" + i + " source: " + edge.source +
                        " destination: " + edge.destination +
                        " weight: " + edge.weight);
			}
		}
		
		public void union(int[] parent,int x,int y){
			int x_set_parent = find(parent,x);
			int y_set_parent = find(parent,y);
			
			//make x parent of y:
			parent[y_set_parent] = x_set_parent;
		}
		
		public int find(int[] parent,int vertex){
			//chain of parent pointers from x upwards through the tree 
			//until an element is reached whose parent is itself:
			
			if(parent[vertex]!=vertex){
				find(parent,parent[vertex]);
			}
			
			return vertex;
		}
		
		public void makeSet(int[] parent){
		//Create a new element with parent pointer to itself:
			for(int i=0;i<parent.length;i++){
				parent[i]=i;
			}
		}
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		int vertices = 6;
		
		Graph graph = new Graph(vertices);
		graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
		graph.kruskalMST();
		

	}

}
