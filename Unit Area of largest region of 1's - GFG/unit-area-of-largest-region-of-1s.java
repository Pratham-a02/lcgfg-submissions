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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution{
    
    public int findMaxArea(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        
        int max = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 1){
                    int[] count = new int[1];
                    dfs(i,j,count,grid);
                    max = Math.max(max,count[0]);
                }
            }
        }
        return max;
    }
    
    public void dfs(int currRow,int currCol,int[] count,int[][] grid){
        if(currRow<0 || currCol<0 || currRow>=grid.length || currCol>=grid[0].length || grid[currRow][currCol] == 0){
            return;
        }
        if(grid[currRow][currCol] == 1){
             count[0]++;
        }
        grid[currRow][currCol] = 0;
        
        
        dfs(currRow-1,currCol,count,grid);
        dfs(currRow,currCol+1,count,grid);
        dfs(currRow+1,currCol,count,grid);
        dfs(currRow,currCol-1,count,grid);
        dfs(currRow+1,currCol+1,count,grid);
        dfs(currRow-1,currCol-1,count,grid);
        dfs(currRow-1,currCol+1,count,grid);
        dfs(currRow+1,currCol-1,count,grid);
        
        return;
    }
}