class Solution{
    public void sortColors(int[] nums){
        int i = 0;
        int j = 0;
        int k = nums.length-1;
        
        while(i<=k){
            if(nums[i] == 1){
                i++;
            }
            else if(nums[i] == 0){
                swap(i,j,nums);
                i++;
                j++;
            }
            else{
                swap(i,k,nums);
                k--;
            }
        }
    }
    
    public void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}