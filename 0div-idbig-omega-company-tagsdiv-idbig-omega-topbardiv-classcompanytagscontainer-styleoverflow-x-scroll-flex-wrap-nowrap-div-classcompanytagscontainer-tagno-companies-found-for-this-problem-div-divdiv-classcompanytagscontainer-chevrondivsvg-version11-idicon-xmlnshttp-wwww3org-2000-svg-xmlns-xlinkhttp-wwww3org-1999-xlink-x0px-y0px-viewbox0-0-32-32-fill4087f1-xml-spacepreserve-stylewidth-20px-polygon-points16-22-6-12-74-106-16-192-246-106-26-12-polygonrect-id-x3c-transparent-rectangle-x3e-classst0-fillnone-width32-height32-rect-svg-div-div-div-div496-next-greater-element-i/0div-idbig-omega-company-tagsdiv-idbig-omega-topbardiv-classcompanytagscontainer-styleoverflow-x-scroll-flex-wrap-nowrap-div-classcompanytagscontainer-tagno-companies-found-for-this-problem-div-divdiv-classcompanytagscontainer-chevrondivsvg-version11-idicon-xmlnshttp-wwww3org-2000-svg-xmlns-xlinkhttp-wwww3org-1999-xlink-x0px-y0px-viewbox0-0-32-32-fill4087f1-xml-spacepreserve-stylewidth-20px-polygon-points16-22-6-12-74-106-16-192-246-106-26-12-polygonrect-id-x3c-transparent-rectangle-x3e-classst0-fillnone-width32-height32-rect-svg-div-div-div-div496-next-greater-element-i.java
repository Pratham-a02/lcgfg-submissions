class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums2.length];
        Arrays.fill(res,-1);
        
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<nums2.length;i++){
            while(st.size()>0 && nums2[i]>nums2[st.peek()]){
                int idx = st.pop();
                res[idx] = nums2[i];
            }
            st.push(i);
        }
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<nums2.length;i++){
            hm.put(nums2[i],res[i]);
        }
        
        int[] ans = new int[nums1.length];
        for(int i = 0;i<nums1.length;i++){
            int key = nums1[i];
            int val = hm.get(key);
            ans[i] = val;
        }
        return ans;
    }
}