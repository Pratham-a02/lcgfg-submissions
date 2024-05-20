class Solution {
    public String reverseStr(String s, int k) {
        int i = 0;
        String ans = "";
        char[] arr = s.toCharArray();
        int n = arr.length;
        while(i<arr.length-1){
            int j = Math.min(n-1,i+k-1);
            reverse(i,j,arr);
            i += (2*k);
        }
        return String.valueOf(arr);
    }
    
    public void reverse(int i,int j,char[] arr){
        while(i<=j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}