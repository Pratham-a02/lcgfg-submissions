class Solution{
    public boolean canThreePartsEqualSum(int[] arr){
        int total = 0;
        for(int val:arr){
            total += val;
        }
        
        if(total%3 != 0){
            return false;
        }
        
        int x = total/3;
        
        int currSum = 0;
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            currSum += arr[i];
            if(currSum == x){
                count++;
                currSum = 0;
            }
        }
        
        return (count >= 3);
    }
}