//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public static int findPages(int[]A,int N,int M){
        if(M>N){
            return -1;
        }
        int lo = Integer.MIN_VALUE;
        int hi = 0;
        
        for(int val:A){
            hi += val;
            lo = Math.max(lo,val);
        }
        
        while(lo<hi){
            int mid = (lo+hi)/2;
            int limit = mid;
            
            int partition = 1;
            int csum = 0;
            
            for(int val:A){
                if(csum+val<=limit){
                    csum += val;
                }
                else{
                    partition++;
                    csum = val;
                }
            }
            
            if(partition>M){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }
        if(lo!=hi){
            return -1;
        }
        return lo;
    }
}