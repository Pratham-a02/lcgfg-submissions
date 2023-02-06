class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<nums2.length;i++){
            while(st.size()>0 && nums2[st.peek()]<nums2[i]){
                int idx = st.pop();
                hm.put(nums2[idx],nums2[i]);
            }
            st.push(i);
        }
        
        int[] ans = new int[nums1.length];
        for(int i = 0;i<ans.length;i++){
            int x = nums1[i];
            if(!hm.containsKey(x)){
                ans[i] = -1;
            }
            else{
                ans[i] = hm.get(x);
            }
        }
        return ans;
    }
}