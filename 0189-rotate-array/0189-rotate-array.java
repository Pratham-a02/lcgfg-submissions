class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        int n = nums.length;
        reverse(0,n-k-1,nums);
        reverse(n-k,n-1,nums);
        reverse(0,n-1,nums);
    }
    
    public void reverse(int i,int j,int[] nums){
        while(i<=j){
            swap(i,j,nums);
            i++;
            j--;
        }
    }
    
    public void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}