class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        
        for(int i = 0;i<arr.length;i++){
            StringBuilder str = new StringBuilder(arr[i]);
            str = str.reverse();
            arr[i] = str.toString();
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<arr.length;i++){
            if(i == arr.length - 1){
                sb.append(arr[i]);
                continue;
            }
            else{
                sb.append(arr[i]);
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}