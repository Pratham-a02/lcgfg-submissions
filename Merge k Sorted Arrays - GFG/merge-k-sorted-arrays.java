//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


// } Driver Code Ends
class Solution{
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            pq.add(new int[]{arr[i][0],0,i});
        }
        
        while(pq.size()>0){
            int[] num = pq.remove();
            
            int val = num[0];
            int idx = num[1];
            int arrNo = num[2];
            
            ans.add(val);
            
            if(idx+1<arr[arrNo].length){
                int nval = arr[arrNo][idx+1];
                pq.add(new int[]{nval,idx+1,arrNo});
            }
        }
        return ans;
    }
}