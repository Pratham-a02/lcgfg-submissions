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
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int x;
    int y;
    int t;
    Pair(int x,int y,int t){
        this.x = x;
        this.y = y;
        this.t = t;
    }
}

class Solution{
    
    public int orangesRotting(int[][] grid){
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        int fresh = 0;
        int time = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    qu.add(new Pair(i,j,0));
                }else if(grid[i][j] == 1){ 
                    fresh++;
                }
            }
        }
        
        while(qu.size()>0){
            Pair rem = qu.remove();
            if(vis[rem.x][rem.y] == true){
                continue;
            }
            vis[rem.x][rem.y] = true;
            if(rem.t>time){
                time = rem.t;
            }
            if(grid[rem.x][rem.y] == 1){
                fresh--;
            }
            
            addNbr(rem.x-1,rem.y,vis,grid,qu,rem.t);
            addNbr(rem.x,rem.y+1,vis,grid,qu,rem.t);
            addNbr(rem.x+1,rem.y,vis,grid,qu,rem.t);
            addNbr(rem.x,rem.y-1,vis,grid,qu,rem.t);
            
        }
        if(fresh == 0){
            return time;
        }else{
            return -1;
        }
    }
    
    public void addNbr(int x,int y,boolean[][] vis,int[][] grid,ArrayDeque<Pair>qu,int time){
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || vis[x][y] == true || grid[x][y] == 0){
            return;
        }
        
        qu.add(new Pair(x,y,time+1));
    }
}