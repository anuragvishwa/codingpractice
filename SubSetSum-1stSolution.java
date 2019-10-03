import java.util.Arrays;

public class SubSetSum{
    public static void main(String[] args){
        int[] arr = {3,34,4,12,5,2};
        int size = arr.length;
        int[] sol = new int[size];
        Arrays.fill(sol, 0);
        System.out.println(getSum(arr,0,0,2,sol)); 
        System.out.println(Arrays.toString(sol));
    
    }

    public static Boolean getSum(int[] arr,int i,int currentSum,int sum,int[] sol){

        if(i==arr.length-1 && currentSum + arr[i] == sum){
            sol[i]=1;
            return true;
        }

        if(i<arr.length){



            if(currentSum==sum){
              
                return true;
            }   
            sol[i] = 1;
            if(getSum(arr,i+1,currentSum + arr[i],sum,sol)){
                
                return true;
            }   
            sol[i] = 0;
        if (getSum(arr, i+1, currentSum, sum,sol)){
            
            return true;
        }    
    }
       
        return false;
    }

}
