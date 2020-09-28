import java.util.Arrays;
public class QuickSort {
    public static void main(String[] args) {
		
		int[] arr = {7,2,1,6,8,5,3,4};
		
		int n = arr.length;
		
		int start = 0;
		int end = arr.length-1;
		
		quickSort(arr,start,end);
		System.out.println(Arrays.toString(arr));
			

	}
	
	static void quickSort(int[] arr,int start,int end){
		
		if(start<end){
			int pIndex = partition(arr,start,end);
			quickSort(arr,start,pIndex-1);
			quickSort(arr,pIndex+1,end);
		}
	}
	
	static int partition(int[] arr,int start,int end){
		
		int pivot = arr[end];
		int pIndex = start;
		
		for(int i = start;i<end;i++){
			
			if(arr[i]<=pivot){
				int temp = arr[i];
				arr[i] = arr[pIndex];
				arr[pIndex] = temp;
				pIndex++;
			}
			
		}
		
		int t = arr[pIndex];
		arr[pIndex] = arr[end];
		arr[end]=t;
		return pIndex;
	}
}
