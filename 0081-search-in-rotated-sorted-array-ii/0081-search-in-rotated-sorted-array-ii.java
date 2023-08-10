class Solution{
    public boolean search(int[] nums,int target){
        int pivot = findPivot(0,nums.length-1,nums);
        
        if(solve(0,pivot-1,nums,target) == true){
            return true;
        }
        else{
            return solve(pivot,nums.length-1,nums,target);
        }
    }
    
    public int findPivot(int l,int r,int[] nums){
        while(l<r){
            
            while(l<r && nums[l] == nums[l+1]) l++;
            
            while(l<r && nums[r] == nums[r-1]) r--;
            
            int mid = l + (r-l)/2;
            
            if(nums[mid] > nums[r]){
                l = mid+1;
            }
            else{
                r = mid;
            }
        }
        return r;
    }
    
    public boolean solve(int l,int r,int[] nums,int target){
        while(l<=r){
            int mid = l + (r-l)/2;
            
            if(nums[mid] == target) return true;
            
            if(nums[mid] < target) l = mid+1;
            
            if(nums[mid] > target) r = mid-1;
        }
        return false;
    }
}