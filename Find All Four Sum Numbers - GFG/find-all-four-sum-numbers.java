//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends
class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        int n = arr.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int target = k - (arr[i] + arr[j]);
                
                int lo = j+1;
                int hi = n-1;
                while(lo<hi){
                    ArrayList<Integer> curr = new ArrayList<>();
                    if(arr[lo] + arr[hi]<target){
                        lo++;
                    }
                    else if(arr[lo] + arr[hi]>target){
                        hi--;
                    }
                    else{
                        curr.add(arr[i]);
                        curr.add(arr[j]);
                        curr.add(arr[lo]);
                        curr.add(arr[hi]);
                        ans.add(curr);
                        while(lo<hi && arr[lo] == arr[lo+1]){
                            lo++;
                        }
                        while(lo<hi && arr[hi] == arr[hi-1]){
                            hi--;
                        }
                        lo++;
                        hi--;
                    }
                }
                while(j+1<n && arr[j] == arr[j+1]){
                    j++;
                }
            }
            while(i+1<n && arr[i] == arr[i+1]){
                    i++;
            }
        }
        return ans;
    }
}