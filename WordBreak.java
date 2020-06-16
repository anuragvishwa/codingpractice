//Recursive Solution:

public class WordBreakRecursive {

	public static void main(String[] args) {
		
		String s = "catsanddog";
		List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
		
		System.out.println(wordBreak(s, wordDict));

	}
	
	static boolean wordBreak(String s, List<String> wordDict) {
		
		if(wordDict.contains(s)) {
            return true;
        }
					
		for(int i=0;i<s.length();i++) {
			
			String firstString = s.substring(0,i); 	
			
			if(wordDict.contains(firstString) && wordBreak(s.substring(i), wordDict)) 
				return true;
			
		}
		
		return false;
	}

}
