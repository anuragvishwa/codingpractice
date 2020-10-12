public class meetingRooms2 {
    
    public static void main(String[] args) {
		
		int[][] intervals = {{7,10},{2,4}};
		
		Arrays.sort(intervals,new Comparator<int[]>(){
			public int compare(int[] a1,int[] a2){
				return a1[0]-a2[0];
			}
		});
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(intervals.length,new Comparator<int[]>(){
			public int compare(int[] a1,int[] a2){
				return a1[1]-a2[1];
			}
		});
		
		for(int i = 0; i<intervals.length;i++){
			int limit = intervals[i][0];
			
			if(!pq.isEmpty() && limit > pq.peek()[1]){
				pq.poll();
			}
			pq.offer(intervals[i]);
		}
		
		
		
		
		System.out.println(pq.size());
		
	}
}
