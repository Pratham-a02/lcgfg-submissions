class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<arr.length;i++){
            StringBuilder curr = new StringBuilder(arr[i]).reverse();
            sb.append(curr);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}