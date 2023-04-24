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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class Pair{
    int x;
    int y;
    int dist;
    
    Pair(int x,int y,int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class Solution{
    int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N){
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        boolean[][] vis = new boolean[N][N];
        qu.add(new Pair(KnightPos[0]-1,KnightPos[1]-1,0));
        
        while(qu.size()>0){
            Pair rem = qu.remove();
            
            if(rem.x == TargetPos[0]-1 && rem.y == TargetPos[1]-1){
                return rem.dist;
            }
            
            if(vis[rem.x][rem.y] == true){
                continue;
            }
            
            vis[rem.x][rem.y] = true;
            
            for(int d = 0;d<8;d++){
                int x1 = rem.x + xMove[d];
                int y1 = rem.y + yMove[d];
                
                if(x1<0 || y1<0 || x1>=vis.length || y1>=vis.length || vis[x1][y1] == true){
                    continue;
                }
                
                qu.add(new Pair(x1,y1,rem.dist+1));
            }
        }
        return -1;
    }
}