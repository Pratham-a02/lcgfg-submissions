class Solution {
    public String convert(String s, int numRows) {
        // if(s.length() <= numRows){
        //     return s;
        // }
        char[][] mat = new char[numRows][s.length()/2+1000];
        for (int x = 0; x < mat.length; x++) {
            for (int y = 0; y < mat[0].length; y++){
                mat[x][y] = '/';
            }
        }
        
        int i = 0;
        int col = 0;
        int j = numRows-2;
        int ptr = 0;
        while(ptr<s.length()){
            while(i!=numRows && ptr<s.length()){
                mat[i][col] = s.charAt(ptr);
                i++;
                ptr++;
            }
            
            col++;
            while(j>0 && ptr<s.length()){
                mat[j][col] = s.charAt(ptr);
                col++;
                j--;
                ptr++;
            }
            
            i = 0;
            j = numRows-2;
        }
        
        String ans = "";
        for(int k = 0;k<mat.length;k++){
            for(int l = 0;l<mat[0].length;l++){
                if(mat[k][l] != '/'){
                    ans += mat[k][l];
                }
            }
        }
        return ans;
    }
}