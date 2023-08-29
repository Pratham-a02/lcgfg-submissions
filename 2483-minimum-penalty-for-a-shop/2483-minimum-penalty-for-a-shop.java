class Solution{
    public int bestClosingTime(String customers){
        int count = 0;
        int max = 0;
        int ans = 0;
        
        for(int i = 0;i<customers.length();i++){
            char ch = customers.charAt(i);
            if(ch == 'Y'){
                count++;
            }
            if(ch == 'N'){
                count--;
            }
            
            if(count>max){
                max = count;
                ans = i+1;
            }
        }
        
        return ans;
    }
}