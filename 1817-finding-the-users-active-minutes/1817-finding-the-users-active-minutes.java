class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k){
        int[] ans = new int[k];
        // HashSet<Integer> hs = new HashSet<>();
        HashMap<Integer,HashSet<Integer>> hm = new HashMap<>();
        for(int i = 0;i<logs.length;i++){
            if(!hm.containsKey(logs[i][0])){
                hm.put(logs[i][0],new HashSet<>());
            }
            hm.get(logs[i][0]).add(logs[i][1]);
        }
        for(int i:hm.keySet()){
            ans[hm.get(i).size()-1]++;
        }
        return ans;
    }
}