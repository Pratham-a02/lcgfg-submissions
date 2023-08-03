//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int e = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] A = new int[2*e];
            int[] B = new int[2*e];
            
            for(int i=0; i<2*e; i++)
            {
                A[i] = Integer.parseInt(S1[i]);
                B[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.checkMirrorTree(n,e,A,B));
        }
    }
}
// } Driver Code Ends

class Solution{
    static int checkMirrorTree(int n,int e,int[] A,int[] B){
        if(A.length != B.length){
            return 0;
        }
        HashMap<Integer,Stack<Integer>> hm = new HashMap<>();
        for(int i = 0;i<A.length;i+=2){
            int a = A[i];
            int b = A[i+1];
            if(hm.containsKey(a)){
                Stack<Integer> st = hm.get(a);
                st.push(b);
            }
            else{
                Stack<Integer> st = new Stack<>();
                st.push(b);
                hm.put(a,st);
            }
        }
        
        
        for(int i = 0;i<B.length;i+=2){
            int a = B[i];
            int b = B[i+1];
            
            if(!hm.containsKey(a)){
                return 0;
            }
            else{
                Stack<Integer> st = hm.get(a);
                if(st.peek() != b){
                    return 0;
                }
                else{
                    st.pop();
                }
            }
        }
        return 1;
    }
}