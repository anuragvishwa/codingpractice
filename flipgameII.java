public class flipgameII {
    public boolean canWin(String s) {
        if(s==null || s.length()<2){
            return false;
        }
        Map<String,Boolean> map = new HashMap<>();
        return win(s,map);
        
    }
    
    Boolean win(String s,Map<String,Boolean> map){
        
        if(map.containsKey(s)){
            return map.get(s);
        }
        
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='+' && s.charAt(i+1)=='+'){
                String opponent = s.substring(0,i)+"--"+s.substring(i+2);
                
                if(!win(opponent,map)){
                    return true;
                }
            }
        }
        
        return false;
        
    }
}
