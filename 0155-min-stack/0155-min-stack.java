import java.util.Stack;

class MinStack {
    private Stack<Long> st;  // Use Long to prevent overflow
    private long min;

    public MinStack() {
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        long x = val;
        if (st.isEmpty()) {
            min = x;
            st.push(x);
        } else {
            if (x >= min) {
                st.push(x);
            } else {
                st.push(2 * x - min);  // Store encoded value
                min = x;
            }
        }
    }
    
    public void pop() {
        if (st.isEmpty()) return;

        long pop_value = st.pop();
        
        if (pop_value < min) {
            min = 2 * min - pop_value;  // Restore previous min
        }

        if (st.isEmpty()) {
            min = Long.MAX_VALUE;  // Reset min when stack becomes empty
        }
    }
    
    public int top() {
        if (st.isEmpty()) return -1;
        
        long top_value = st.peek();
        return (top_value < min) ? (int) min : (int) top_value;
    }
    
    public int getMin() {
        return st.isEmpty() ? -1 : (int) min;
    }
}
