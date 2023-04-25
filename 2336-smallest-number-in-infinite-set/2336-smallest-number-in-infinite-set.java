class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    HashSet<Integer> hs;
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        hs = new HashSet<>();
        
        for(int i = 1;i<=1000;i++){
            pq.add(i);
            hs.add(i);
        }
    }
    
    public int popSmallest() {
        int x = pq.remove();
        hs.remove(x);
        return x;
    }
    
    public void addBack(int num) {
        if(!hs.contains(num)){
            pq.add(num);
            hs.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */