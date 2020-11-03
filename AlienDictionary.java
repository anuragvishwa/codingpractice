class AlienDictionary {
    public String alienOrder(String[] words) {
        int[] indegree = new int[26];
		Map<Character,Set<Character>> g = new HashMap<>();
		buildGraph(g,words,indegree);
		
		return bfs(g,indegree);
    }
     private String bfs(Map<Character,Set<Character>> g,int[] indegree){
		StringBuilder sb = new StringBuilder();
		int totalChars = g.size();
		
		Queue<Character> q = new LinkedList<>();
		//All the nodes with indegree zero:
		
		for(char c : g.keySet()){
			if(indegree[c-'a']==0){
				sb.append(c);
				q.offer(c);
			}
		}
		
		while(!q.isEmpty()){
			char current = q.poll();
			if(g.get(current)==null || g.get(current).size()==0){
				continue;
			}
			
			for(char neigh : g.get(current)){
				indegree[neigh-'a']--;
				if(indegree[neigh- 'a']==0){
					q.offer(neigh);
					sb.append(neigh);
				}
			}
		}
		
		return sb.length()==totalChars ? sb.toString():"";
	}
	
	private void buildGraph(Map<Character,Set<Character>> g,String[] words,int[] indegree){
		for(String word : words){
			for(char c : word.toCharArray()){
				g.putIfAbsent(c,new HashSet<>());
			}
		}
		
		for(int i=1;i<words.length;i++){
			String first = words[i-1];
			String second = words[i];
			int len = Math.min(first.length(),second.length());
			
			for(int j=0;j<len;j++){
				if(first.charAt(j)!=second.charAt(j)){
					char out = first.charAt(j);
					char in = second.charAt(j);
					
                 
                    
					if(!g.get(out).contains(in)){
						g.get(out).add(in);
						indegree[in-'a']++;
					}
					
					break;
				}
                
                   if(j+1 == len && first.length() > second.length()){
                    g.clear();
                    return;
                    }
			}
		}
		
	}
}
