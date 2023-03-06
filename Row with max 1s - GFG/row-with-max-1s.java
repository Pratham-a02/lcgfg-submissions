//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends
class Solution{
    public int rowWithMax1s(int nums[][], int n, int m){
        int max = Integer.MIN_VALUE;
        int ans = -1;
        for(int k = 0;k<nums.length;k++){
            int[] num = nums[k];
            // Arrays.sort(num);
            if(num[num.length-1] == 0){
                continue;
            }
            if(num[0] == 1){
                return k;
            }
            int fi = -1;
            int i = 0;
            int j = num.length-1;
            while(i<=j){
                int mid = (i+j)/2;
                
                if(num[mid] == 1){
                    fi = mid;
                    j = mid-1;
                }
                else if(num[mid]<1){
                    i = mid+1;
                }
            }
            if(fi!= -1){
                int size = nums.length - fi;
                if(size>max){
                    max = size;
                    ans = k;
                }
            }
        }
        return ans;
    }
}