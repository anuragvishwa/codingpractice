class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        
        Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
        
        for(int i:hand){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        for(int i : map.keySet()){
            int count = map.get(i);
            if(count==0)
                continue;
            for(int j=i;j<i+W;j++){
                Integer c = map.get(j);
                if(c==null || c < count){
                    return false;
                }
                map.put(j,c-count);
            }
        }
        
        return true;
        
    }
}