//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends
class solve{
    public ArrayList<ArrayList<Integer>> buildGraph(boolean[][] Graph,int n){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0;i<Graph.length;i++){
            for(int j = 0;j<Graph[0].length;j++){
                if(Graph[i][j] == true){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        
        return graph;
    }
    
    public boolean isSafe(int node,ArrayList<ArrayList<Integer>> graph,int[] color,int col){
        for(int nbr:graph.get(node)){
            if(color[nbr] == col){
                return false;
            }
        }
        return true;
    }
    
    public boolean solve(int node,ArrayList<ArrayList<Integer>> graph,int[] color,int n,int m){
        if(node == n){
            return true;
        }
        
        for(int i = 1;i<=m;i++){
            if(isSafe(node,graph,color,i)){
                color[node] = i;
                if(solve(node+1,graph,color,n,m) == true)return true;
                color[node] = 0;
            }
        }
        return false;
    }
    
    public boolean graphColoring(boolean[][] Graph, int m, int n){
        ArrayList<ArrayList<Integer>> graph = buildGraph(Graph,n);
        
        int[] color = new int[n];
        if(solve(0,graph,color,n,m)){
            return true;
        }
        return false;
    }
    
    
}