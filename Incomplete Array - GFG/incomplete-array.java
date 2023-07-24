//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            int A[] = new int[N];
            String[] S = read.readLine().split(" ");
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(S[i]);
            Solution ob = new Solution();
            System.out.println(ob.countElements(N, A));
        }
    }
}
// } Driver Code Ends

class Solution{
    int countElements(int N,int A[]){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int val:A){
            min = Math.min(min,val);
            max = Math.max(max,val);
        }
        
        HashSet<Integer> hs = new HashSet<>();
        for(int val:A){
            hs.add(val);
        }
        int count = 0;
        for(int i = min;i<=max;i++){
            if(!hs.contains(i)){
                count++;
            }
        }
        return count;
    }
}