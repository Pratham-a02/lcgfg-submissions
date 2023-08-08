class Solution{
    public int search(int[] nums, int target){
        int n = nums.length;
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo<hi){
            int mid = lo-(lo-hi)/2;
            
            if(nums[mid] > nums[hi]){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }
        
        int la = solve(0,lo-1,nums,target);
        int ra = solve(lo,n-1,nums,target);
        
        if(la == -1){
            return ra;
        }
        else{
            return la;
        }
    }
    
    public int solve(int lo,int hi,int[] nums,int target){
        while(lo<=hi){
            int mid = lo-(lo-hi)/2;
            
            if(nums[mid] == target){
                return mid;
            }
            
            if(nums[mid] > target){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return -1;
    }
}