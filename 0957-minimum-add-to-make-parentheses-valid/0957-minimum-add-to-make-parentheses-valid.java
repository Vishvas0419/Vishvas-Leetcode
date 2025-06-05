class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0; int closed = 0;
        for(char ch : s.toCharArray())
        {
            if(ch=='(') open++;
            else { //if ch == ')'
                if(open>0) open--; //we find a pair reduce open brackets count
                else closed++; //else there is no open brackets for this closing brackets , increase count of closed brackets 
            }
        }
        return open+closed;
        
    }
}