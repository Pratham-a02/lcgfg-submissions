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
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.oddEven(S));
        }
    }
}

// } Driver Code Ends

class Solution{
    static String oddEven(String S) {
        int[] farr = new int[27];
        
        for(char ch:S.toCharArray()){
            farr[ch-'a'+1]++;
        }
        
        int x = 0;
        int y = 0;
        
        for(int i = 1;i<farr.length;i++){
            if(farr[i]>0){
                if(i%2 == 0 && farr[i]%2 == 0){
                    x++;
                }
                else if(i%2 == 1 && farr[i]%2 == 1){
                    y++;
                }
            }
        }
        
        int sum = x+y;
        if(sum%2 == 0){
            return "EVEN";
        }
        else{
            return "ODD";
        }
    }
}