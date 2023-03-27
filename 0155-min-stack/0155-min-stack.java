class MinStack{
    Stack<Long> st= new Stack<>();
    long min;
    public MinStack(){
        min = Long.MAX_VALUE;
    }
    
    public void push(int val){
        Long value = (long)(val);
        if(st.isEmpty()){
            st.push(value);
            min = val;
        }
        else{ 
            if(val<min){
                st.push(2*value - min);
                min = value;
            }
            else{
                st.push(value);
            }
        }
    }
    
    public void pop(){
        if(st.isEmpty()){
            return;
        }
        
        long ele = st.pop();
        if(ele<min){
            min = (2*min - ele);
        }
    }
    
    public int top(){
        if(st.isEmpty()){
            return -1;
        }
        long ele = st.peek();
        if(ele<min){
            return (int)min;
        }
        else{
            return (int)ele;
        }
    }
    
    public int getMin(){
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */