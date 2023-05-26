//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] nums = IntArray.input(br, n);
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.longestOnes(n, nums, k);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution{
    public static int longestOnes(int n,int[] nums,int k){
        int ans = 0;
        int left = 0;
        int currLen = 0;
        int count = 0;
        for(int right = 0;right<n;right++){
            if(nums[right] == 0){
                count++;
            }
            
            if(count <= k){
                currLen = Math.max(currLen,right-left+1);
            }
            
            while(count > k){
                if(nums[left] == 0){
                    count--;
                }
                left++;
            }
            
            ans = Math.max(currLen,ans);
        }
        return ans;
    }
}
        
