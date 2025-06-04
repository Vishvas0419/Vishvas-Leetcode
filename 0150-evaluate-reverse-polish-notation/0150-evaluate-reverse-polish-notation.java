class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token : tokens)
        {
            if(token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/"))
            {
                int t1 = st.pop(); int t2 = st.pop();
                if(token.equals("+")) st.push(t1+t2);
                else if(token.equals("-")) st.push(t2-t1);
                else if(token.equals("*")) st.push(t1*t2);
                else st.push(t2/t1);
            }
            else st.push(Integer.parseInt(token));
        }
        return st.pop();
    }
}