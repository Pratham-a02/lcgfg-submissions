//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.canReach(A,N));
        }
    }
}
// } Driver Code Ends

class Solution{
    static int canReach(int[] A, int N){
        if(N == 1){
            return 1;
        }
        
        if(A[0] == 0){
            return 0;
        }
        
        int maxReach = A[0];
        int steps = A[0];
        int jump = 1;
        
        for(int i = 1;i<N;i++){
            if(i == N-1){
                return 1;
            }
            
            maxReach = Math.max(maxReach,i+A[i]);
            steps--;
            
            if(steps == 0){
                if(i>=maxReach){
                    return 0;
                }
                steps = maxReach-i;
                jump++;
            }
        }
        return 1;
    }
}