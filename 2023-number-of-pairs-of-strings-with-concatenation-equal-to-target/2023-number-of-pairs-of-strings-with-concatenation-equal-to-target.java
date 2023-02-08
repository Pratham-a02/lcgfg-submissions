class Solution {
    public int numOfPairs(String[] nums, String target) {
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        
        String a = "";
        String b = "";
        int ans = 0;
        
        for(int i = 1;i<target.length();i++){
            a = target.substring(0,i);
            b = target.substring(i,target.length());
            
            if(hm.containsKey(a) && hm.containsKey(b)){
                if(a.equals(b)){
                    ans += (hm.get(a)*(hm.get(a) - 1));
                }
                else{
                    ans += hm.get(a)*hm.get(b);
                }
            }
        }
        return ans;
    }
}