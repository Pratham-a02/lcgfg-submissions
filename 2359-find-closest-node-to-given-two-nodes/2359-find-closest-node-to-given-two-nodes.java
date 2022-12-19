class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] dist1 = new int[n];
        Arrays.fill(dist1,Integer.MAX_VALUE);
        dist1[node1]=0;

        int[] dist2 = new int[n];
        Arrays.fill(dist2,Integer.MAX_VALUE);
        dist2[node2]=0;

        boolean[] visited1 = new boolean[n];
    
        dfs(dist1,node1,visited1,edges,0);
        boolean[] visited2 = new boolean[n];
        dfs(dist2,node2,visited2,edges,0);

        int min=Integer.MAX_VALUE;int ans=-1;
        for(int i=0;i<n;i++){
            if(dist1[i]!=Integer.MAX_VALUE && dist2[i]!=Integer.MAX_VALUE){
                int max = Math.max(dist1[i],dist2[i]);
                if(max<min){
                    min = max;
                    ans = i;
                }
            }
        }
        return ans;
    }
    public void dfs(int[] dist,int src,boolean[] visited,int[] edges,int d){

        if(edges[src]==-1)
            return;

        visited[src]=true;

        int dst=edges[src];
        if(!visited[dst]){
            dist[dst]=d+1;
            dfs(dist,dst,visited,edges,d+1);
        }

        // visited[src]=false;
    }
}
