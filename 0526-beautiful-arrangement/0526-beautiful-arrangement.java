class Solution{
    int ans = 0;
    public int countArrangement(int n){
        int[] nums = new int[n];
        for(int i = 0;i<n;i++){
            nums[i] = i+1;
        }
        ans = 0;
        solve(0,nums);
        return ans;
    }
    
    public void solve(int j,int[] nums){
        if(j>=nums.length){
            ans++;
        }
        
        
        int count = 0;
        for(int idx = j;idx<nums.length;idx++){
            swap(idx,j,nums);
            if((j+1)%nums[j] == 0 || nums[j]%(j+1) == 0){
                solve(j+1,nums);
            }
            swap(idx,j,nums);
        }
    }
    
    public void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    
}