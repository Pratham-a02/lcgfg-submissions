class Solution{
    public String reverseOnlyLetters(String s){
        char[] c = s.toCharArray();
        
        int i = 0;
        int j = s.length() - 1;
        
        while(i<=j){
            if(!isEnglishCharacter(c[i])){
                i++;
                continue;
            }
            if(!isEnglishCharacter(c[j])){
                j--;
                continue;
            }
            
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            
            i++;
            j--;
        }
           
        return new String(c);
    }
        
    public boolean isEnglishCharacter(char c){
        return (Character.isUpperCase(c) || Character.isLowerCase(c));
    }
}