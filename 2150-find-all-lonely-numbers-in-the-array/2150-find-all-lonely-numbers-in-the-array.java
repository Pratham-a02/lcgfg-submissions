class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> al = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            
            if(val == 1 && !hm.containsKey(key+1) && !hm.containsKey(key-1)){
                al.add(key);
            }
        }
        return al;
    }
}