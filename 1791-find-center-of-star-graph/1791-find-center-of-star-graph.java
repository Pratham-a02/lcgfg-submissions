class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int[]edge:edges){
            hm.put(edge[0],hm.getOrDefault(edge[0],0)+1);
            hm.put(edge[1],hm.getOrDefault(edge[1],0)+1);
        }
        
        int ans = 0;
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(value == edges.length){
                ans = key;
            }
        }
        return ans;
    }
}