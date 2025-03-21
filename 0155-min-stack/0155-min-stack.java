class MinStack {
    private Stack<Long>st;
    private long min;

    public MinStack() {
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        long x = val;
        if(st.isEmpty()){
            min = x;
            st.push(x);
        }
        else{
            if(x>min) st.push(x); 
            else 
            {
                st.push(2*x-min); 
                min = x;
            }
            
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        long pop_value = st.pop();
        if(pop_value < min) min = 2*min-pop_value;
        //if pop_value is less than min value than that pop_value has been modified earlier        
        if (st.isEmpty()) {
            min = Long.MAX_VALUE;  // Reset min when stack becomes empty
        }
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        long top_value = st.peek();
        if(top_value<min) return (int)min; //it hasnt modified simply return
        else return (int)top_value;         
    }
    
    public int getMin() {
        if(st.isEmpty()) return -1;
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