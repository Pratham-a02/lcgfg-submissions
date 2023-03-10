//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution{
    public int[][] overlappedInterval(int[][] intervals){
        Arrays.sort(intervals,(a,b)->{
            if(a[0]<b[0]){
                return -1;
            }
            else if(a[0] == b[0]){
                return 0;
            }
            else{
                return 1;
            }
        });
        ArrayList<int[]> al = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int[] interval:intervals){
            if(interval[0]<=end){
                end = Math.max(end,interval[1]);
            }
            else{
                int[] arr = new int[]{start,end};
                al.add(arr);
                start = interval[0];
                end = interval[1];
            }
        }
        
        al.add(new int[]{start,end});
        
        // int[][] ans = new int[al.size()][2];
        return al.toArray(new int[0][]);
    }
}