//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution{

    int maxIndexDiff(int arr[],int n){
        int[] lMin = new int[n];
        int[] rMax = new int[n];
        lMin[0] = arr[0];
        rMax[n-1] = arr[n-1];
        
        for(int i = 1;i<n-1;i++){
            lMin[i] = Math.min(arr[i],lMin[i-1]);
        }
        
        for(int i = n-2;i>=0;i--){
            rMax[i] = Math.max(arr[i],rMax[i+1]);
        }
        
        int max = -1;
        
        int i = 0;
        int j = 0;
        
        while(i<n && j<n){
            if(lMin[i]<=rMax[j]){
                max = Math.max(max,j-i);
                j++;
            }
            else{
                i++;
            }
        }
        return max;
    }
}