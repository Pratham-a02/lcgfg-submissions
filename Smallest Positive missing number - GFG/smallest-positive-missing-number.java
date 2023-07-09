//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution{
    static int missingNumber(int arr[], int size){
        for(int i = 0;i<size;i++){
            if(arr[i] <= 0 || arr[i] > size){
                arr[i] = size+1;
            }
        }
        
        for(int i = 0;i<size;i++){
            int val = Math.abs(arr[i]);
            if(val <= size){
                int idx = val-1;
                
                if(arr[idx]>0){
                    arr[idx] = -1*arr[idx];
                }
            }
        }
        
        for(int i = 0;i<size;i++){
            if(arr[i]>0){
                return (i+1);
            }
        }
        return size+1;
    }
}


//{ Driver Code Starts.

class Main
{   
    public static void main (String[] args) 
    {

		Scanner sc=new Scanner(System.in);
		
        //taking testcases
		int t=sc.nextInt();
		while(t-->0){
		    
		    //input number n
			int n=sc.nextInt();
			int[] arr=new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			System.out.println(missing);
		}
    }
}


// } Driver Code Ends