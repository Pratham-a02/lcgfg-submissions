class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num:nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        
        int ans = 0;
        for(int val : hm.values()){
            ans += (val*(val-1))/2;
        }
        return ans;
    }
}