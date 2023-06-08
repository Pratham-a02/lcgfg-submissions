//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    int k = Integer.parseInt(br.readLine().trim());
		    
		    Solution ob= new Solution();
		    System.out.println(ob.countKdivPairs(arr, n, k));
		}
	}
}
// } Driver Code Ends

class Solution{
    public static long countKdivPairs(int arr[], int n, int k){
        HashMap<Integer,Integer> hm = new HashMap<>();
        long ans = 0;
        
        for(int i = 0;i<n;i++){
            int rem = arr[i]%k;
            
            if(rem != 0){
                if(hm.containsKey(k-rem)){
                    ans += hm.get(k-rem);
                }
            }
            else{
                if(hm.containsKey(0)) ans += hm.get(0);
            }
            
            hm.put(rem,hm.getOrDefault(rem,0)+1);
        }
        
        return ans;
    }
}