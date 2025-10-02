class Solution {
    public boolean isPalindrome(int x) {
        int n = x;
        int reversedNum = 0;
        while(n>0)
        {
            int lastDigit = n%10;
            reversedNum = reversedNum * 10 + lastDigit;
            n=n/10;
        }
        if(reversedNum == x) return true;
        return false;     
    }
}