class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if(nums.length == 1){
            return nums;
        }
        int i = 0;
        int j = 0;
        while(i<nums.length){
            if(nums[i]%2 != 0){
                i++;
            }
            else if(nums[i]%2 == 0){
                swap(i,j,nums);
                i++;
                j++;
            }
        }
        return nums;
    }
    public void swap(int i,int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}