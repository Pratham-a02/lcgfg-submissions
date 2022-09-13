class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i = 0;i<nums1.length;i++){
            hm.put(nums1[i],hm.getOrDefault(nums1[i],0)+1);
        }
        for(int i = 0;i<nums2.length;i++){
            if(hm.containsKey(nums2[i])){
                hs.add(nums2[i]);
            }
        }
        ArrayList<Integer> al = new ArrayList<>(hs);
        int[] arr = new int[al.size()];
        for(int i = 0;i<arr.length;i++){
            arr[i] = al.get(i);
        }
        return arr;
    }
}