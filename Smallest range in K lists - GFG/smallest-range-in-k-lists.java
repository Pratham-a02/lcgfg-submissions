//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class DriverClass
{
	public static void main(String args[]) 
	{
	   Scanner sc = new Scanner(System.in);
	   int t = sc.nextInt();
	   int range[];
	   while(t-- >0)
	   {
	     int n = sc.nextInt();
	     int k = sc.nextInt();
	     int arr[][] = new int[k][n];
	       for(int i = 0; i < k; i++)
	       {
	        for(int j = 0; j < n; j++)
	               arr[i][j] = sc.nextInt();
	       }
	       range = new Solution().findSmallestRange(arr, n, k);
	       System.out.println(range[0] + " " + range[1]);
	   }
	}
}

// } Driver Code Ends

class Pair implements Comparable<Pair>{
    int idx;
    int li;
    int val;
    
    Pair(int idx,int li,int val){
        this.idx = idx;
        this.li = li;
        this.val = val;
    }
    
    public int compareTo(Pair o){
        return this.val - o.val;
    }
}


class Solution{
	static int[] findSmallestRange(int[][] KSortedArray,int n,int k){
	    PriorityQueue<Pair> pq = new PriorityQueue<>();
	    int max = Integer.MIN_VALUE;
	    for(int i = 0;i<KSortedArray.length;i++){
            pq.add(new Pair(0,i,KSortedArray[i][0]));
            max = Math.max(max,KSortedArray[i][0]);
	    }
	    
	    
	    int sr = 0;
	    int er = 0;
	    int rsize = Integer.MAX_VALUE;
	    while(pq.size() == KSortedArray.length){
	        Pair p = pq.remove();
	        int i = p.idx;
	        int arrNo = p.li;
	        int value = p.val;
	        
	        int currRange = max - value;
	        if(currRange < rsize){
	            rsize = currRange;
	            sr = value;
	            er = max;
	        }
	        
	        if(i<KSortedArray[arrNo].length-1){
	            i++;
	            int nval = KSortedArray[arrNo][i];
	            pq.add(new Pair(i,arrNo,nval));
	            
	            if(nval > max){
	                max = nval;
	            }
	        }
	    }
	    
	    return new int[]{sr,er};
	}
}