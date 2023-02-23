class Solution {
    public int compress(char[] chars) {
        int ansIdx = 0;
        int n = chars.length;
        int i = 0;
        while(i<n){
            int j = i+1;
            while(j<n && chars[j] == chars[i]){
                j++;
            }
            
            chars[ansIdx++] = chars[i];
            int count = j-i;
            if(count>1){
              String cnt = Integer.toString(count);
              for(char ch:cnt.toCharArray()){
                  chars[ansIdx++] = ch;
              }
            }
            
            i=j;
        }
        
        return ansIdx;
    }
}