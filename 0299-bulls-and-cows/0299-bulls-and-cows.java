class Solution {
    public String getHint(String secret, String guess) {
        int cb = 0;
        int idx = 0;
        while(idx<secret.length()){
            if(secret.charAt(idx) == guess.charAt(idx)){
                cb++;
                secret = secret.substring(0,idx) + secret.substring(idx+1);
                guess = guess.substring(0,idx) + guess.substring(idx+1);
            }
            else{
                idx++;
            }
        }
        HashMap<Character,Integer> hm1 = new HashMap<>();
        HashMap<Character,Integer> hm2 = new HashMap<>();
        
        for(int i = 0;i<secret.length();i++){
            hm1.put(secret.charAt(i),hm1.getOrDefault(secret.charAt(i),0)+1);
        }
        
        for(int i = 0;i<guess.length();i++){
            hm2.put(guess.charAt(i),hm2.getOrDefault(guess.charAt(i),0)+1);
        }
        int cc = 0;
        for(int i = 0;i<secret.length();i++){
            if(hm1.containsKey(secret.charAt(i)) && hm2.containsKey(secret.charAt(i))){
                cc++;
                hm1.put(secret.charAt(i),hm1.get(secret.charAt(i))-1);
                hm2.put(secret.charAt(i),hm2.get(secret.charAt(i))-1);
                if(hm1.get(secret.charAt(i)) == 0){
                    hm1.remove(secret.charAt(i));
                }
                if(hm2.get(secret.charAt(i)) == 0){
                    hm2.remove(secret.charAt(i));
                }
            }
        }
        
        String ans = cb + "A" + cc + "B";
        return ans;
    }
}