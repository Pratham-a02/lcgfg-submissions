/*class SmallestInfiniteSet{
    PriorityQueue<Integer> pq;
    HashSet<Integer> hs;
    public SmallestInfiniteSet(){
        pq = new PriorityQueue<>();
        hs = new HashSet<>();
        // numbers are from 1 to 1000, so add all the numbers.
        for(int i = 1;i<=1000;i++){
            pq.add(i);
            hs.add(i);
        }
    }
    
    public int popSmallest(){
        // for getting the smallest element, pq is always used;
        int x = pq.remove();
        hs.remove(x);
        return x;
    }
    
    public void addBack(int num){
        // add in priorityqueue only when it is not presented in set.c
        if(!hs.contains(num)){
            pq.add(num);
            hs.add(num);
        }
    }
}
*/
class SmallestInfiniteSet{
    TreeSet<Integer> hs;
    public SmallestInfiniteSet(){
        hs = new TreeSet<>();
        
        for(int i = 1;i<=1000;i++){
            hs.add(i);
        }
    }
    
    public int popSmallest(){
        int x = hs.pollFirst();
        return x;
    }
    
    public void addBack(int num){
        hs.add(num);
    }
}


/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */