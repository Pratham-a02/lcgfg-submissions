class Pair implements Comparable<Pair>{
    int freq;
    char c;
    
    Pair(int freq,char c){
        this.freq = freq;
        this.c = c;
    }
    
    public int compareTo(Pair o){
        return o.freq - this.freq;
    }
}
class Solution {
    public String frequencySort(String s) {
        //hashmap for counting the frequency of each character in string s
        HashMap<Character , Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(hm.containsKey(s.charAt(i))){
                int old = hm.get(s.charAt(i));
                hm.put(s.charAt(i) , old+1);
            }
            else{
                hm.put(s.charAt(i) , 1);
            }
        }
        
        // creating a priority queue with max heap which will store the elements in decreasing order of frequency
        PriorityQueue<Pair> pq =  new PriorityQueue<>();
        for(Map.Entry<Character , Integer> map : hm.entrySet()){
            char key = map.getKey();
            int val = map.getValue();
            pq.add(new Pair(val , key));
        }
        
        //now we will simply get the resultant string get done by 
        //removing the top most value from queue and adding it into the res for its frequency times
        String res = "";
        while(pq.size() > 0){
            // int val = pq.peek().getKey();
            // char key = pq.peek().getValue();
            Pair p = pq.remove();
            int val = p.freq;
            char key = p.c;
            while(val > 0){
                res += key;
                val--;
            }
            // pq.remove();
        }
        return res;
    }
}