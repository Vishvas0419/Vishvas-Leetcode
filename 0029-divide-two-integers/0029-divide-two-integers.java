class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // handle the special case of dividing the minimum integer by -1
        }
        int result = dividend / divisor;
        return result; 
    }
}