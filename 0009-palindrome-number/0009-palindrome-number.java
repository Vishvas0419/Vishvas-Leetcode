class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int n = x;
        int reversedNum = 0;
        while(n>0)
        {
            reversedNum = (reversedNum * 10) + n%10;
            n=n/10;
        } 
        if(reversedNum==x) return true;
        return false;
    }
}