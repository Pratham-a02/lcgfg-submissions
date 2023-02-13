//{ Driver Code Starts


import java.util.*;
import java.io.*;
class PeakElement{
	public static void main(String[] args)throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
		int t=Integer.parseInt(in.readLine().trim());
		while(t-->0){
			int n=Integer.parseInt(in.readLine().trim());
			int[] a=new int[n];
		    int[] tmp=new int[n];
		    String s[]=in.readLine().trim().split(" ");
			for(int i=0;i<n;i++){
				a[i]=Integer.parseInt(s[i]);
				tmp[i] = a[i];
			}
		    
		    int f=0;
			int A=(new Solution()).peakElement(tmp,n);
			
			if(A<0 && A>=n)
			    out.println(0);
			else
			{
    			if(n==1 && A==0)
    			    f=1;
    			else if(A==0 && a[0]>=a[1])
    			    f=1;
    			else if(A==n-1 && a[n-1]>=a[n-2])
    			    f=1;
    			else if(A >= 0 && A < n && a[A] >=a[A+1] && a[A]>= a[A-1])
    			    f=1;
    			else
    			    f=0;
			    out.println(f);
			}
		}
		out.close();
	}
}
// } Driver Code Ends


/*Complete the function below*/

class Solution{
	
	public int peakElement(int[] nums,int n){
       int lo = 0;
       int hi = n-1;
       while(lo<hi){
           int mid = lo - (lo-hi)/2;
           if(mid == n-1 && nums[mid]>nums[mid-1]){
               return mid;
           }
           else if(mid == 0 && nums[mid]>nums[mid+1]){
               return mid;
           }
           else if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]){
               return mid;
           }
           else if(nums[mid+1]>nums[mid]){
               lo = mid+1;
           }
           else{
               hi = mid;
           }
       }
       return lo;
    }
}