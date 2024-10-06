class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.equals(sentence2)) return true;
        
        if(sentence1.length()<sentence2.length()){
            String temp = sentence1;
            sentence1 = sentence2;
            sentence2 = temp;
        }
        
        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");
        
        int i = 0;
        int j = arr1.length-1;
        int k = 0;
        int l = arr2.length-1;
        
        while(k<arr2.length && i<arr1.length && arr1[i].equals(arr2[k])){
            i++;
            k++;
        }
        while(l>=k && arr1[j].equals(arr2[l])){
            j--;
            l--;
        }
        
        return l<k;
    }
}