class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        int[] indegree = new int[n];
        for(List<Integer>edge:edges){
            indegree[edge.get(1)]++;
        }
        for(int i = 0;i<indegree.length;i++){
            if(indegree[i] == 0){
                ans.add(i);
            }
        }
        return ans;
    }
}