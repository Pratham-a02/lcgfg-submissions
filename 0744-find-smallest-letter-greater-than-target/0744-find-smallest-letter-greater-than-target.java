class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0;
        int hi = letters.length - 1;
        
        while(lo<=hi){
            int mid = lo - (lo-hi)/2;
            
            if(letters[mid] > target){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        // if(lo == hi && letters[lo]-'a' > target) return letters[lo];
        // if(ans == ' ')return letters[0];
        return letters[lo%letters.length];
    }
}