public class NumberOfConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        int parent[] = new int[n];
        
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
        
        for(int[] edge : edges){
            int root1 = find(parent,edge[0]);
            int root2 = find(parent,edge[1]);
            
            if(root1!=root2){
                parent[root1] = root2;
                n--;
            }
        }
       return n; 
    }
    
    public int find(int[] parent,int id){
        int oid = id;
        while(parent[id]!=id){
            id = parent[id];
        }
        
        parent[oid]=id;
        return id;
    }
}
