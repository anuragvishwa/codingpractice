public class LongestSubstringWithTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int start = 0;
        int end = 0;
        
        int maxLength=0;
        
        int k=2;
        
        Map<Character,Integer> map = new HashMap<>();
            
        while(end<s.length()){
            char cEnd = s.charAt(end);
            
            map.put(cEnd,map.getOrDefault(cEnd,0)+1);
            
            //Checking for new character:
            if(map.get(cEnd)==1){
                k--;
            }
            
            end++;
            
            while(k<0){
                char cStart = s.charAt(start);
                
                map.put(cStart,map.get(cStart)-1);
                
                if(map.get(cStart)==0){
                    k++;
                }
                start++;
            }
            
            maxLength = Math.max(maxLength,end-start);
            
            
        }
        
        return maxLength;
        
    }
}
