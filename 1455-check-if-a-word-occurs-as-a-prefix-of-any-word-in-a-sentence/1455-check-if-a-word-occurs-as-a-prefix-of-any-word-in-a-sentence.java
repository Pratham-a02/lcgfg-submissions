class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");
        int idx = 0;
        int len = searchWord.length();
        while(idx<arr.length){
            String word = arr[idx];
            if(len<=word.length()){
                if(word.substring(0,len).equals(searchWord)){
                    break;
                }
            }
            idx++;
        }
        if(idx == arr.length){
            return -1;
        }
        return idx+1;
    }
}