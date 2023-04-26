class Solution {
    public int addDigits(int num) {
        String str = Integer.toString(num);
        
        boolean flag = false;
        String s = "";
        while(s.length() != 1){
            int sum = 0;
            
            if(flag == false){
                char[] arr = str.toCharArray();
                for(int i = 0;i<arr.length;i++){
                    sum += (arr[i]-'0');
                }
                s = String.valueOf(sum);
                flag = true;
            }
            else{
                char[] arr = s.toCharArray();
                for(int i = 0;i<arr.length;i++){
                    sum += (arr[i]-'0');
                }
                s = String.valueOf(sum);
            }
        }
        
        return Integer.parseInt(s);
    }
}