class HitCounter {
    
   HashMap<Integer,Integer> hits;  
/** Initialize your data structure here. */
public HitCounter() {
    this.hits = new HashMap<>();     
}  
/** Record a hit.
    @param timestamp - The current timestamp (in seconds granularity). */
public void hit(int timestamp) {
    hits.put(timestamp, hits.getOrDefault(timestamp,0)+1);        
}   
/** Return the number of hits in the past 5 minutes.
    @param timestamp - The current timestamp (in seconds granularity). */
public int getHits(int timestamp) {//all time stamps older than 5 mins will be removed, so that the total key size<=300
    int sum = 0;
    Iterator<Map.Entry<Integer,Integer>> entryIterator = hits.entrySet().iterator();
    while(entryIterator.hasNext()){
    	Map.Entry<Integer,Integer> entry = entryIterator.next();
    	if(timestamp-entry.getKey()>=300) entryIterator.remove();
    	else sum += entry.getValue();
    }
    return sum;
}
    
}