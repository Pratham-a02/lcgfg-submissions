class Solution{
    public int subarrayGCD(int[] nums, int k){
        int count = 0;
        
        for(int i = 0;i<nums.length;i++){
            int currGCD = nums[i];
            for(int j = i;j<nums.length;j++){
                currGCD = gcd(nums[j],currGCD);
                if(currGCD == k){
                    count++;
                }
                else if(currGCD < k){
                    break;
                }
            }
        }
        return count;
    }
    
    public int gcd(int n1,int n2){
        while(n1%n2 != 0){
            int rem = n1%n2;
            n1 = n2;
            n2 = rem;
        }
        
        return n2;
    }
}