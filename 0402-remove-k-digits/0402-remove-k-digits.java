class Solution {
    public String removeKdigits(String num, int k) {
        char[] arr = num.toCharArray();
        int digits = num.length()-k;
        
        int top = -1;
        int start = 0;
        
        for(int i = 0;i<arr.length;i++){
            while(top>= 0 && arr[top]>arr[i] && k>0){
                k--;
                top--;
            }
            
            top++;
            arr[top] = arr[i];
        }
        
        while(arr[start] == '0' && start<=top){
            start++;
        }
        
        String ans = "";
        
        for(int i = start;i<digits;i++){
            ans += arr[i];
        }
        
        if(ans.length() == 0) return "0";
        
        return ans;
    }
}