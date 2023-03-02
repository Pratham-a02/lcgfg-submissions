class Solution{
    public void nextPermutation(int[] nums){
        int i = nums.length -2;
        for(i = nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                break;
            }
        }
        if(i>=0){
        int j = nums.length-1;
        for(j = nums.length-1;j>=0;j--){
            if(nums[j]>nums[i]){
                break;
            }
        }
        
        swap(i,j,nums);}
        reverse(i+1,nums.length-1,nums);
    }
    
    public void reverse(int i,int j,int[] nums){
        while(i<=j){
            swap(i,j,nums);
            i++;
            j--;
        }
    }
    
    public void swap(int i,int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}