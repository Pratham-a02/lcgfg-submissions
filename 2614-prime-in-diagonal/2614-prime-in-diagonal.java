class Solution {
    public int diagonalPrime(int[][] nums) {
        int i = 0;
        int j = 0;
        int max = 0;
        while(i<nums.length && j<nums[0].length){
            if(isPrime(nums[i][j])){
                max = Math.max(max,nums[i][j]);
            }
            i++;
            j++;
        }
        i = 0;
        j = nums[0].length-1;
        
        while(i<nums.length && j>=0){
            if(isPrime(nums[i][j])){
                max = Math.max(max,nums[i][j]);
            }
            
            i++;
            j--;
        }
        if(max == 1){
            return 0;
        }
        return max;
    }
    
    public boolean isPrime(int num){
    for(int i = 2;i*i<=num;i++){
        if((num%i) == 0)
        return false;
    }
    return true;
}
}