//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends

class Solution{
    static int[] topoSort(int V,ArrayList<ArrayList<Integer>> adj){
        int[] indegree = new int[V];
        
        for(int i = 0;i<adj.size();i++){
            for(int nbr:adj.get(i)){
                indegree[nbr]++;
            }
        }
        
        ArrayDeque<Integer> qu = new ArrayDeque<>();
        for(int i = 0;i<indegree.length;i++){
            if(indegree[i] == 0){
                qu.add(i);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(qu.size()>0){
            int val = qu.remove();
            
            ans.add(val);
            
            for(int nbr:adj.get(val)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    qu.add(nbr);
                }
            }
        }
        
        int[] res = new int[ans.size()];
        for(int i = 0;i<res.length;i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}
