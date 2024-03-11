class Solution{
    public int largestPerimeter(int[] nums){
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        for(int i = nums.length-1;i>=2;i--){
            int a = nums[i];
            int b = nums[i-1];
            int c = nums[i-2];
            
            if(a+b>c && b+c>a && a+c>b){
                max = Math.max(max,(a+b+c));
            }
        }
        return (max == Integer.MIN_VALUE)?0:max;
    }
}