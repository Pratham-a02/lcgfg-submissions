class Solution{
    public int[] mostCompetitive(int[] nums,int k){
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<nums.length;i++){
            while(st.size()> 0 && nums[i] < st.peek() && k - st.size() <= n-i-1){
                st.pop();
            }
            if(st.size()<k){
                st.push(nums[i]);    
            }   
        }
        int[] ans = new int[k];
        int idx = k-1;
        while(idx>= 0 && st.size()>0){
            int val = st.pop();
            ans[idx] = val;
            idx--;
        }
        return ans;
    }
}