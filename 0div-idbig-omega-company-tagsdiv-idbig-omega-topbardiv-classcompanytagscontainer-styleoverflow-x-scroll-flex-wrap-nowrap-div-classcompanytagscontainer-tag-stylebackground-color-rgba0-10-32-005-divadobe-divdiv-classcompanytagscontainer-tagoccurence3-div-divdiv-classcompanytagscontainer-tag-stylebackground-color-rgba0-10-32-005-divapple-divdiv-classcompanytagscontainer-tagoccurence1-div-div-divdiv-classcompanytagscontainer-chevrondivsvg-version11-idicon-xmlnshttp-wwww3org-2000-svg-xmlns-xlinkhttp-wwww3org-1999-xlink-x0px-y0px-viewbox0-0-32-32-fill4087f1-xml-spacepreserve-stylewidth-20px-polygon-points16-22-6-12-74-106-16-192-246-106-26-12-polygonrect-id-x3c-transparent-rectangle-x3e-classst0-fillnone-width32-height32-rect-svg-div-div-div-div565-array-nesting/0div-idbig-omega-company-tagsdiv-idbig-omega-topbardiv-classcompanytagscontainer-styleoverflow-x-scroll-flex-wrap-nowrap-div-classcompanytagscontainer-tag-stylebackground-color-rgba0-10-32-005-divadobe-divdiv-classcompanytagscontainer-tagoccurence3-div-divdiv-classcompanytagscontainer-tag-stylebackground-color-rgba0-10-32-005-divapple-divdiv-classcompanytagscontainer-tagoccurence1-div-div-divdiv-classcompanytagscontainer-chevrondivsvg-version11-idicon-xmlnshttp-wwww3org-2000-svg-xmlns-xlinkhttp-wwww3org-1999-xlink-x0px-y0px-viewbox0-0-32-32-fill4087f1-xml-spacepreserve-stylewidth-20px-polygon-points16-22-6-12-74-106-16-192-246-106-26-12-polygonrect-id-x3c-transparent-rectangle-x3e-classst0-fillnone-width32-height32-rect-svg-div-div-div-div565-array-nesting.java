class Solution{
    public int arrayNesting(int[] nums){
        int max = 0;
        HashMap<String,Integer> hm = new HashMap<>();
        for(int k = 0;k<nums.length;k++){
            boolean[] vis = new boolean[nums.length];
            int[] count = new int[1];
            dfs(k,nums[k],count,vis,nums,hm);
            max = Math.max(max,count[0]);
        }
        return max;
    }
    
    public int dfs(int idx,int val,int[] count,boolean[] vis,int[] nums,HashMap<String,Integer> hm){
        if(vis[val] == true){
            return 0;
        }
        String currKey = idx + "#" + val;
        if(hm.containsKey(currKey)){
            return hm.get(currKey);
        }
        
        vis[val] = true;
        count[0]++;
        int value = dfs(val,nums[val],count,vis,nums,hm);
        hm.put(currKey,value);
        return value;
    }
}