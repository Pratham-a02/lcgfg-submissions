class Solution{
    public String removeKdigits(String num, int k){
        int digits = num.length()-k;
        if(num.length()<=k) return "0";
        int top = -1;
        
        char[] arr = num.toCharArray();
        
        for(int i = 0;i<num.length();i++){
            while(top>=0 && arr[top]>arr[i] && k>0){
                top--;
                k--;
            }
            top++;
            arr[top] = arr[i];
        }
        
        int start = 0;
        while(arr[start] == '0' && start<=top){
            start++;
        }
        String ans = "";
        
        for(int i = start;i<digits;i++){
            ans += arr[i];
        }
        if(ans.equals(""))return "0";
        return ans;
    }
}