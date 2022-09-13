class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0;i<nums1.length;i++){
            hm.put(nums1[i],hm.getOrDefault(nums1[i],0)+1);
        }
        for(int i = 0;i<nums2.length;i++){
            if(hm.containsKey(nums2[i])){
                al.add(nums2[i]);
                hm.put(nums2[i],hm.get(nums2[i])-1);
            
            if(hm.get(nums2[i]) == 0){
                hm.remove(nums2[i]);
            }
            }
        }
        int[] ans = new int[al.size()];
        for(int i = 0;i<ans.length;i++){
            ans[i] = al.get(i);
        }
        return ans;
    }
}