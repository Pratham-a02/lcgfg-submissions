class Solution{
    public int[] sumEvenAfterQueries(int[] nums,int[][] queries){
        int sumEven = 0;
        for(int num:nums){
            if(num%2 == 0){
                sumEven += num;   
            }
        }
        int i = 0;
        int[] ans = new int[nums.length];
        
        for(int[] query:queries){
            int val = query[0];
            int idx = query[1];
            
            if(nums[idx]%2 == 0){
                sumEven -= nums[idx];
            }
            
            nums[idx] += val;
            if(nums[idx]%2 == 0){
                sumEven += nums[idx];
            }
            ans[i++] = sumEven;
        }
        return ans;
    }
}