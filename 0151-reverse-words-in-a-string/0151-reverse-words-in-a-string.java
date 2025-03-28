class Solution {
    public String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder word = new StringBuilder(); // Store current word
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                if(word.length()>0) st.push(word.toString()); //check only if word exist
                word.setLength(0); // Clear string word for next word       
                }
                else word.append(ch); 
        }
        if(word.length()>0) st.push(word.toString());  // Push last word
        // Construct the reversed sentence
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop()).append(" ");
        }
        return ans.toString().trim(); // Remove trailing space and return result
    }
}