class Solution{
    public int maxConsecutiveAnswers(String answerKey, int k){
        int n = answerKey.length();
        int max1 = Integer.MIN_VALUE;
        
        int left = 0;
        int count = 0;
        
        for(int right = 0;right<n;right++){
            char ch = answerKey.charAt(right);
            
            if(ch == 'T'){
                count++;
            }
            
            while(count > k){
                if(answerKey.charAt(left) == 'T'){
                    count--;
                }
                left++;
            }
            
            max1 = Math.max(max1,right-left+1);
        }
        
        left = 0;
        count = 0;
        int max2 = Integer.MIN_VALUE;
        for(int right = 0;right<n;right++){
            char ch = answerKey.charAt(right);
            
            if(ch == 'F'){
                count++;
            }
            
            while(count > k){
                if(answerKey.charAt(left) == 'F'){
                    count--;
                }
                left++;
            }
            
            max2 = Math.max(max2,right-left+1);
        }
        return Math.max(max1,max2);
    }
}