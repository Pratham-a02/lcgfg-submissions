//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            StringTokenizer stt = new StringTokenizer(br.readLine());
            long k1 = Long.parseLong(stt.nextToken());
            long k2 = Long.parseLong(stt.nextToken());
            
            Solution obj = new Solution();
            System.out.println( obj.sumBetweenTwoKth(a, n, k1, k2) );
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution { 
    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2){
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long k1 = getSmallest(A,K1,pq);
        pq.clear();
        long k2 = getSmallest(A,K2,pq);
        
        long ans = 0;
        for(int i = 0;i<N;i++){
            if(A[i]>k1 && A[i]<k2){
                ans += A[i];
            }
        }
        return ans;
    }
    
    private static long getSmallest(long[] arr,long k,PriorityQueue<Long> pq){
        for(int i = 0;i<arr.length;i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                pq.remove();
            }
        }
        
        return pq.peek();
    }
}
