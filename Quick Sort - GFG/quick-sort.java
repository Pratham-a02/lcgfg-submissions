//{ Driver Code Starts
import java.util.*;
class Sorting
{
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    // Driver program
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

			
			new Solution().quickSort(arr,0,n-1);
			printArray(arr);
		    T--;
		}
} }
// } Driver Code Ends

class Solution{
    
    static void quickSort(int arr[],int low,int high){
        if(low>=high){
            return; 
        }
        
        int pivot = arr[high];
        
        int pi = partition(arr,low,high,pivot);
        
        quickSort(arr,low,pi-1);
        quickSort(arr,pi+1,high);
    }
    static int partition(int[] arr,int low,int high,int pivot){
        int i = low;
        int j = low;
        
        while(i <= high){
            if(arr[i] <= pivot){
                swap(i,j,arr);
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        return (j-1);
    } 
    
    public static void swap(int i,int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
