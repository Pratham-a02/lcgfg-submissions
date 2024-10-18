class Solution {
    public int longestSubstring(String s, int k) {
        int max = 0; 
        
        int left = 0;
        while (left < s.length()) {
            int[] freq = new int[26];
            int right = left; 
            int validLen = 0;
            
            while (right < s.length()) {
                char ch = s.charAt(right);
                freq[ch - 'a']++;
                
                boolean isValid = true;
                for (int i = 0; i < 26; i++) {
                    if (freq[i] > 0 && freq[i] < k) {
                        isValid = false; 
                        break;
                    }
                }
                
                if (isValid) {
                    validLen = right - left + 1;
                    max = Math.max(max, validLen);
                }
                right++;
            }
            
            left++;
        }
        return max;
    }
}
