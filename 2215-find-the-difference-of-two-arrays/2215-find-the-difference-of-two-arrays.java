class Solution{
    public List<List<Integer>> findDifference(int[] nums1,int[] nums2){
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int ele : nums1){
            hm.put(ele,hm.getOrDefault(ele,0)+1);
        }
        
        List<Integer> al1 = new ArrayList<>();
        
        for(int ele:nums2){
            if(hm.containsKey(ele)){
                hm.remove(ele);
            }
        }
        
        for(int key:hm.keySet()){
            al1.add(key);
        }
        
        hm.clear();
        for(int ele : nums2){
            hm.put(ele,hm.getOrDefault(ele,0)+1);
        }
        List<Integer> al2 = new ArrayList<>();
        
        for(int ele:nums1){
            if(hm.containsKey(ele)){
                hm.remove(ele);
            }
        }
        
        for(int key:hm.keySet()){
            al2.add(key);
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(al1);
        ans.add(al2);
        return ans;
    }
}