class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^A-Za-z0-9]","");
        return s.equals(new StringBuilder(s).reverse().toString());
        
    }
}