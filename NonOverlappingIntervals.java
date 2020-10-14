class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
       Arrays.sort(intervals,new Comparator<int[]>(){
			public int compare(int[] a1,int a2[]){
				return a1[0]-a2[0];
			}
		});
		
		int prevEnd = intervals[0][1];
		int res = 0;
		
		for(int i=1;i<intervals.length;i++){
			if(prevEnd > intervals[i][0]){
				res++;
				prevEnd = Math.min(prevEnd,intervals[i][1]);
			}else{
				prevEnd = intervals[i][1];
			} 
		}
		
		return res;
    }
}