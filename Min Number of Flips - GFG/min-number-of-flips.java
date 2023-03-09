//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution ob = new Solution();
            
            System.out.println(ob.minFlips(S));
                        
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    public int minFlips(String s) {
        int n = s.length();
        // String s1 ="";
        // String s2 ="";
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 0;i<s.length();i++){
            if(i%2 == 0){
                if(s.charAt(i) == '1'){
                    cnt1++;
                }
            }
            else{
                if(s.charAt(i) == '0'){
                    cnt1++;
                }
            }
        }
        
        for(int i = 0;i<s.length();i++){
            if(i%2 == 0){
                if(s.charAt(i) == '0'){
                    cnt2++;
                }
            }
            else{
                if(s.charAt(i) == '1'){
                    cnt2++;
                }
            }
        }
        return Math.min(cnt1,cnt2);
    }
}