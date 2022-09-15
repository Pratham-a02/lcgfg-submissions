class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // List<Integer> check = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for(int i = 0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            
            if(val == 2){
                ans.add(key);
            }
        }
        return ans;
    }
}