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
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}
// } Driver Code Ends



class Solution{
    
    public boolean is_Possible(int[][] grid){
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        int[] count = new int[1];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 1){
                    dfs(i,j,grid,n,vis,count);
                    if(count[0]!= 0){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void dfs(int currRow,int currCol,int[][] grid,int n,boolean[][] vis,int[] count){
        if(currRow<0 || currCol<0 || currRow>=n || currCol>=n || grid[currRow][currCol] == 0 || vis[currRow][currCol] == true){
            return;
        }
        vis[currRow][currCol] = true;
        
        if(grid[currRow][currCol] == 2){
            count[0]++;
        }
        
        dfs(currRow-1,currCol,grid,n,vis,count);
        dfs(currRow,currCol+1,grid,n,vis,count);
        dfs(currRow+1,currCol,grid,n,vis,count);
        dfs(currRow,currCol-1,grid,n,vis,count);
        
        return;
    }
}