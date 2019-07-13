import java.util.ArrayList;
import java.util.Arrays;

public class GetPerm {
	
	static ArrayList<String> result= new ArrayList<>();
	
	public static void main(String[] args) {
		getPermutation("", "ABCD");
		System.out.println(Arrays.toString(result.toArray()));
	}
	
	static ArrayList<String> getPermutation(String f, String u){
		if(u.length()==0) {
			result.add(f);
		return result;
		}
			for(int i=0;i<u.length();i++) {
				String fixed = f + u.charAt(i);
				String unFixed = u.substring(0,i)+ u.substring(i+1);
				getPermutation(fixed, unFixed);
			}
	
			return result;
	}

}
