class Solution{
    public int[] deckRevealedIncreasing(int[] deck){
        Arrays.sort(deck);
        int n = deck.length;
        ArrayDeque<Integer> qu = new ArrayDeque<>();
        for(int i = 0;i<n;i++){
            qu.add(i);
        }
        
        int[] ans = new int[n];
        int idx = 0;
        
        while(qu.size()>0){
            int i = qu.remove();
            ans[i] = deck[idx++];
            if(!qu.isEmpty()){
                int val = qu.remove();
                qu.add(val);
            }
        }
        return ans;
    }
}