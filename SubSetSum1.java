import java.util.ArrayList;

public class SubSetSum {
	
	static Boolean  result = false;
	
	static ArrayList<Integer> getSubSetSum(int[] set,int index,int sum){
		ArrayList<Integer> resultSet ;
		
		if(index<0) {
			resultSet = new ArrayList<Integer>();	
			resultSet.add(0);
		}
		
		else {			
			
			resultSet = getSubSetSum(set, index-1, sum);
			int element = set[index];
			ArrayList<Integer> newSet = new ArrayList<Integer>();
			newSet.addAll(resultSet);
			
			for(int individual : resultSet) {
				
				if(individual==sum) {
					result = true;
				}
				
				int newSum = individual+element;
				newSet.add(newSum);				
			}	
			
			resultSet = newSet;
				
		}		
		
		return resultSet;
	}
	

	public static void main(String[] args) {
	
		
		int[] set = {3,4,5,2}; 
		int index = set.length-1;
		int sum = 9;
		ArrayList<Integer> resultSet = getSubSetSum(set, index, sum);
		System.out.println(resultSet);
		System.out.println(result);

	}

}
//Backtracking solution:

import java.util.ArrayList;

public class SubSetSum {

	static ArrayList<Integer> resultSet = new ArrayList<Integer>();
	
	static boolean getSubSetSum(int[] set,int index,int sum){
		if (index<0) {
			resultSet.add(0);
		}
		
		else {			
			boolean isSubsetFound = getSubSetSum(set, index-1, sum);
			if (isSubsetFound) {
			    return true;
			}
		
			int element = set[index];
			ArrayList<Integer> newSet = new ArrayList<Integer>();
			newSet.addAll(resultSet);
			
			for (int individual : resultSet) {
				int newSum = individual+element;
				newSet.add(newSum);	
			    resultSet = newSet;
				if (newSum == sum) {
					return true;

				}			
			}	
		}		
		return false;
	}
	

	public static void main(String[] args) {
		int[] set = {3, 34, 4, 12, 5, 2}; 
		int index = set.length-1;
		int sum = 5;
		boolean isSubsetFound = getSubSetSum(set, index, sum);
		System.out.println(resultSet);
		System.out.println(isSubsetFound);

	}

}
