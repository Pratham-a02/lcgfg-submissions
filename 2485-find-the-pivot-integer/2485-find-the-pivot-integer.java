class Solution{
    public int pivotInteger(int n){
        int currSum = 0;
        
        for(int i = 1;i<=n;i++){
            currSum += i;    
            int remNumbers = (n-i+1);
            int remSum = (remNumbers*(i+n))/2;
            
            if(currSum == remSum){
                return i;
            }
        }
        
        return -1;
    }
}