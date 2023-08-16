class Solution{
    public int[] maxSlidingWindow(int[] nums,int k){
        ArrayDeque<Integer> qu = new ArrayDeque<>();
        int idx = 0;
        int[] ans = new int[nums.length-k+1];
        for(int i = 0;i<nums.length;i++){
            while(qu.size()>0 && qu.peek()<=i-k){
                qu.poll();
            }
            
            while(qu.size()>0 && nums[qu.peekLast()] < nums[i]){
                qu.pollLast();
            }
            
            qu.offer(i);
            
            if(i >= k-1){
                ans[idx++] = nums[qu.peek()];
            }
        }
        return ans;
    }
}