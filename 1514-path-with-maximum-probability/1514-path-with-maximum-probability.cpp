class Solution {
public:
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start, int end) {
        vector<double> dist(n, -1e9);
        priority_queue<pair<int,double>> pq;
        pq.push({start,1});
        dist[start]=1;
        vector<vector<pair<int,double>>> adj(n);
        for (int i=0; i<succProb.size(); i++){
            adj[edges[i][0]].push_back({edges[i][1], succProb[i]});
            adj[edges[i][1]].push_back({edges[i][0], succProb[i]});
        }

        while (!pq.empty()){
            int node=pq.top().first;
            double currdist=pq.top().second;
            pq.pop();

            for (auto it:adj[node]){
                if (currdist*it.second>dist[it.first]){
                dist[it.first]=currdist*it.second;
                pq.push({it.first, dist[it.first]});
            }
        }
    }
    if (dist[end]==-1e9)
    return 0;
    else return dist[end];
    }
};