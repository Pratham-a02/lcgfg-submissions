class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans=0;
        int i=0;
        int n=nums.length;
        int j=0;
        
        while(i<n && j<n){
            if(nums[i]==0){
                j=i;
                while(j<n && nums[j]==0){
                    ans = ans+ (long)(j-i+1);
                    j++;
                }
                i=j;
            }else{
                i++;
            }
            
        }
        return ans;
    }
}