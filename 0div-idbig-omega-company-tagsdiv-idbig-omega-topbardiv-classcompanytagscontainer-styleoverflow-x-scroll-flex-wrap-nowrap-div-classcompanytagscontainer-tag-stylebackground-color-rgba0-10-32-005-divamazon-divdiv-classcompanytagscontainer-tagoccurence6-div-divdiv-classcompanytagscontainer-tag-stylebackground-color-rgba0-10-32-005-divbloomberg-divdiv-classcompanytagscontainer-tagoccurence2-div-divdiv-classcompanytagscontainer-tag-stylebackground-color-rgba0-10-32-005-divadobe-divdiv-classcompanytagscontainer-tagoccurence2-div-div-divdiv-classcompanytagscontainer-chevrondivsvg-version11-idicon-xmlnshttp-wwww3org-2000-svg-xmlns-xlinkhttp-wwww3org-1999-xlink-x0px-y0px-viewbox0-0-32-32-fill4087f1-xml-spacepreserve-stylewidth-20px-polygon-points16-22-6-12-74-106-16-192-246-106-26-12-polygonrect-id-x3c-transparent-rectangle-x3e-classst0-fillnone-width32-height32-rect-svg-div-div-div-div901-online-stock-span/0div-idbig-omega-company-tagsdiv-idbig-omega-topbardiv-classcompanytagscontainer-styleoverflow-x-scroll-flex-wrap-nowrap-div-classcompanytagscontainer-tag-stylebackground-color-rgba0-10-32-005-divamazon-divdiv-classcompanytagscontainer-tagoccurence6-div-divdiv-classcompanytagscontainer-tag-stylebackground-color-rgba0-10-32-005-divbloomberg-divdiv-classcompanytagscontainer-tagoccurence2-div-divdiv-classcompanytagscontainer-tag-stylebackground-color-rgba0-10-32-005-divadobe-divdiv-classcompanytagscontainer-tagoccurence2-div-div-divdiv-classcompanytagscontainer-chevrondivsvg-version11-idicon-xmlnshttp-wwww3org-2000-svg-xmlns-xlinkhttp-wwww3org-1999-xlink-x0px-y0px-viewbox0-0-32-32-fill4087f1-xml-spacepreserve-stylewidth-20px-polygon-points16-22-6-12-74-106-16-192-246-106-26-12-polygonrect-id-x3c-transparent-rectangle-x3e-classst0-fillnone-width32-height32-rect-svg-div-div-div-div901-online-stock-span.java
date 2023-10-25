class Pair{
    int span;
    int data;
    
    Pair(int span,int data){
        this.span = span;
        this.data = data;
    }
}

class StockSpanner{
    Stack<Pair> st;
    public StockSpanner(){
        st = new Stack<>();
    }
    
    public int next(int price){
        int count = 0;
        while(st.size()>0 && st.peek().data<=price){
            Pair rem = st.pop();
            count += rem.span;
        }
        count++;
        st.push(new Pair(count,price));
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */