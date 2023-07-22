//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int l = sc.nextInt();
            int n = sc.nextInt();
            
            int arr[] =  new int[l];
            
            for(int i = 0;i<l;i++)
                arr[i] = sc.nextInt();
            
            Solution ob = new Solution();
                
            if(ob.findPair(arr, l, n)==true)
                System.out.println(1);
                
            else
                System.out.println(-1);    
                
        }
        
    }
}
// } Driver Code Ends

class Solution{
    public boolean findPair(int arr[],int size,int n){
        Arrays.sort(arr);
        
        int i = 0;
        int j = 1;
        
        while(j<size){
            if(arr[j] - arr[i] < n){
                j++;
            }
            else if(arr[j] - arr[i] > n){
                i++;
                if(i==j){
                    j++;
                }
            }
            else if(arr[j] -arr[i] == n){
                return true;
            }
        }
        return false;
    }
}