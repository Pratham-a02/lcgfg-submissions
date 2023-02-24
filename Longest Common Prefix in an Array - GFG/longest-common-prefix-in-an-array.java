//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public String longestCommonPrefix(String arr[], int n){
        String S = "abc";
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            String word = arr[i];
            if(word.length()<min){
                min = word.length();
                S = word;
            }
        }
        boolean flag = true;
        int count = 0;
        for(int i = 0;i<min;i++){
            for(int j = 0;j<n;j++){
                String word = arr[j];
                if(word.charAt(i) != S.charAt(i)){
                    flag = false;
                    break;
                }
            }
            if(flag == false){
                    break;
                }
            else{
                count++;
            }
        }
        if(count == 0){
            return "-1";
        }
        else{
            return S.substring(0,count);
        }
    }
}