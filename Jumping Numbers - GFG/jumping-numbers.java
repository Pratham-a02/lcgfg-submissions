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
            long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.jumpingNums(X));
        }
    }
}
// } Driver Code Ends

class Solution{
    static long jumpingNums(long X){
        ArrayDeque<Long> qu = new ArrayDeque<>();
        for(long i = 1;i<=9;i++){
            qu.add(i);
        }
        
        long ans = 0;
        while(qu.size()>0){
            long num = qu.remove();
            if(num>X) continue;
            ans = Math.max(ans,num);
            long last_digit = (int)num%10;
            
            if(last_digit != 9){
                qu.add(num*10 + (last_digit+1));
            }
            if(last_digit != 0){
                qu.add(num*10 + (last_digit-1));
            }
        }
        return ans;
    }
}