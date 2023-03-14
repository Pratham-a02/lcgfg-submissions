//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			long a = sc.nextInt();
			Solution obj = new Solution();
			System.out.println(obj.floorSqrt(a));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution{
     public long floorSqrt(long x){
		long ans = -1;
		long lo = 1;
		long hi = x;
		while(lo<=hi){
		    long mid = lo - (lo-hi)/2;
		    
		    if(mid*mid == x){
		        return mid;
		    }
		    else if(mid*mid<x){
		        ans = mid;
		        lo = mid+1;
		    }
		    else{
		        hi = mid-1;
		    }
		}
		return ans;
	 }
}
