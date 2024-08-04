class Solution{
    public int minSwaps(int[] nums){
        int k = 0;
        for(int num:nums){
            if(num == 1){
                k++;
            }
        }
        int[] arr = new int[nums.length*2];
        for(int i = 0;i<nums.length;i++){
            arr[i] = nums[i];
        }
        for(int i = nums.length;i<arr.length;i++){
            arr[i] = nums[i-nums.length];
        }
        int max = 0;
        int cnt = 0;
        int left = 0;
        for(int right = 0;right<arr.length;right++){
            if(arr[right] == 1){
                cnt++;
            }
            
            if(right-left+1>k){
                if(arr[left] == 1){
                    cnt--;
                }
                left++;
            }
            
            max = Math.max(max,cnt);
        }
        
        return k - max;
    }
}