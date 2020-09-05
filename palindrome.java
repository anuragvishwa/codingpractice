//Program to find Palindrome:

static Boolean isPalindrome(String s,int i ,int j){
		if(i>j){
			return true;
		}
		
		if(s.charAt(i) == s.charAt(j)){
			return isPalindrome(s,i+1,j-1);
		}
		
		return false;
	}