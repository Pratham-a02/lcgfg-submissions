class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++){
            nums[i] = nums[i] + k;
        }
        int max = 0;
        for(int i = 0;i<nums.length;i++){
            max = Math.max(max,nums[i]+k);
        }
        
        int[] arr = new int[max+2];
        
        for(int i = 0;i<nums.length;i++){
            int start = nums[i] - k;
            int end = nums[i] + k;
            
            arr[start]++;
            arr[end+1]--;
        }
        max = 0;
        int ps = 0;
        
        for(int i = 0;i<arr.length;i++){
            ps+= arr[i];
            max = Math.max(max,ps);
        }
        
        return max;
    }
}