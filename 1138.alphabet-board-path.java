class Solution {
    public String alphabetBoardPath(String target) {
        int n = 0;
		int sourceRow = 0;
		int sourceCol = 0;
		
		StringBuilder str = new StringBuilder("");
		
		while(n<target.length()) {
		
			int c = (int)target.charAt(n);
			int row = (c-97)/5;
			int col = (c-97)%5;
            
			while(row<sourceRow ){
				str.append('U');
				sourceRow--;
			}
			
		
			
			while(col>sourceCol){
				str.append('R');
				sourceCol++;
			}
			
			
			while(col<sourceCol){
				str.append('L');
				sourceCol--;
			}
            
            	while(row>sourceRow){
				str.append('D');
				sourceRow++;
			}
			
			str.append('!');
			
		
			
			n++;
			
						
			
		}
		
			return str.toString();
		
    }
}