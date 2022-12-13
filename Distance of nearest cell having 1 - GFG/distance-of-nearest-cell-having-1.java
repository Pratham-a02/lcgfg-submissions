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
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    class Pair{
        int i;
        int j;
        int dist;
        
        Pair(int i,int j,int dist){
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }
    
    public int[][] nearest(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 1){
                    qu.add(new Pair(i,j,0));
                }
            }
        }
        while(qu.size()>0){
            Pair rem = qu.remove();
            
            if(visited[rem.i][rem.j] == true){
                continue;
            }
            visited[rem.i][rem.j] = true;
            grid[rem.i][rem.j] = rem.dist;
            if(rem.i-1>= 0 && grid[rem.i-1][rem.j] != 1){
                qu.add(new Pair(rem.i-1,rem.j,rem.dist+1));
            }
            if(rem.i+1<m && grid[rem.i+1][rem.j] != 1){
                qu.add(new Pair(rem.i+1,rem.j,rem.dist+1));
            } 
            if(rem.j-1>= 0 && grid[rem.i][rem.j-1] != 1){
                qu.add(new Pair(rem.i,rem.j-1,rem.dist+1));
            }
            if(rem.j+1<n && grid[rem.i][rem.j+1] != 1){
                qu.add(new Pair(rem.i,rem.j+1,rem.dist+1));
            }
        }
        return grid;
    }
}