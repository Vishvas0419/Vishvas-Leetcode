class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray())
        {
            if(!st.isEmpty() && ch==st.peek())
            {
                st.pop();
            }
            else st.push(ch);
        }
        StringBuilder result = new StringBuilder();
        for(char ch : st)
        {
            result.append(ch);
        }
        return result.toString();
    }
}