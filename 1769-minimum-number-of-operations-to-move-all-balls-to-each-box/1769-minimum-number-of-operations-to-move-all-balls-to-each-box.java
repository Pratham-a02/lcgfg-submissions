class Solution {
    public int[] minOperations(String boxes) {
        List<Integer> al = new ArrayList<>();
        int[] ans = new int[boxes.length()];
        for(int i = 0;i<boxes.length();i++){
            if(boxes.charAt(i) == '1'){
                al.add(i);
            }
        }
        
        for(int i = 0;i<boxes.length();i++){
            int sum = 0;
            for(int j = 0;j<al.size();j++){
                sum += Math.abs(al.get(j) - i);
            }
            ans[i] = sum;
        }
        return ans;
    }
}