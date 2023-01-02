class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] farr = new int[26];
        Arrays.fill(farr,-1);
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            farr[ch - 'a'] = i;
        }
        int st = 0;
        int e = 0;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            e = Math.max(e,farr[ch-'a']);
             if(i == e){
                 ans.add(e-st+1);
                 
                 e++;
                 st = e;
             }
        }
        return ans;
    }
}