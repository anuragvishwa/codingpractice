import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class UnionFindRank {
	static class Edge{
        int source;
        int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    static class SubSet {
        int parent;
        int rank;
    }

    static class Graph{
        int vertices;
        LinkedList<Edge>[] adjList;
        ArrayList<Edge> allEdges = new ArrayList<>();

        Graph(int vertices){
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i <vertices ; i++) {
                adjList[i] = new LinkedList<>();
            }
        }
        public void addEgde(int source, int destination){
            Edge edge = new Edge(source, destination);
            adjList[source].addFirst(edge);
            allEdges.add(edge); //add to total edges
        }
        
        //Path compression:
        public int find(SubSet[] subset,int vertex){
        	if(subset[vertex].parent!= vertex){
        		subset[vertex].parent = find(subset,subset[vertex].parent);
        	}
        	return subset[vertex].parent;
        }
	
		//Union by rank:
		public void union(SubSet[] subset,int x,int y){
			int x_set_parent = find(subset,x);
			int y_set_parent = find(subset,y);
			
			//attach the smaller rank tree to higher rank tree:
			if(subset[x_set_parent].rank>subset[y_set_parent].rank){
				//make x as the parent of y
				subset[x_set_parent].parent = y_set_parent;
			}
			else if(subset[x_set_parent].rank<subset[y_set_parent].rank){
				subset[y_set_parent].parent = x_set_parent;
			}
			else{
			//make any tree child of other tree:
				subset[y_set_parent].parent = x_set_parent;
				subset[x_set_parent].rank++;
				
			}
			
		}
		
		public void makeSet(SubSet[] subset){
			for(int i=0;i<vertices;i++){
				subset[i] = new SubSet();
				subset[i].parent = i;
				subset[i].rank = 0;
			}
		}
		
		public void disjointSet(){
			SubSet[] subset = new SubSet[vertices];
			//MakeSet:
			makeSet(subset);
			
			for (int i = 0; i <allEdges.size() ; i++) {
                Edge edge = allEdges.get(i);
                int x_set = find(subset, edge.source);
                int y_set = find(subset, edge.destination);

                //check if source vertex and destination vertex belongs to the same set
                // if in same set then cycle has been detected else combine them into one set
                if(x_set==y_set) {
                    //do nothing
                }else
                    union(subset, x_set, y_set);
            }
            printSets(subset);
        }

        public void printSets(SubSet[] subSets){
            //Find different Sets
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for (int i = 0; i <subSets.length ; i++) {
                if(map.containsKey(subSets[i].parent)){
                    ArrayList<Integer> list = map.get(subSets[i].parent);
                    list.add(i);//add vertex
                    map.put(subSets[i].parent,list);
                }else{
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(subSets[i].parent,list);
                }
            }
            //Print the Different sets
            Set<Integer> set = map.keySet();
            Iterator<Integer> iterator = set.iterator();
            while(iterator.hasNext()){
                int key = iterator.next();
                System.out.println("Set Id: " + key + " elements: " + map.get(key));
            }
        }
    }
    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEgde(0, 1);
        graph.addEgde(0, 2);
        graph.addEgde(1, 3);
        graph.addEgde(4, 5);
        System.out.println("Disjoint Sets: ");
        graph.disjointSet();
    }
}
