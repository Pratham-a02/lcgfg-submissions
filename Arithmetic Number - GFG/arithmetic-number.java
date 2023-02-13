//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int A = Integer.parseInt(arr[0]);
            int B = Integer.parseInt(arr[1]);
            int C = Integer.parseInt(arr[2]);
            
            Solution ob = new Solution();
            out.println(ob.inSequence(A, B, C));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int inSequence(int a, int b, int c){
        if(c == 0){
            if(a == b){
                return 1;
            }
            else{
                return 0;
            }
        }
        else{
            if((b-a)/c<0){
                return 0;
            }
            else if((b-a)%c == 0){
                return 1;
            }
            else{
                return 0;
            }
        }
    }
}