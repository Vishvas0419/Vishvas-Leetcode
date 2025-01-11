// #define INT_MAX
class Solution {
public:
    int reverse(int x) {
        int reversedNum = 0;
        // const int INT_MAX = 2147483647; // Maximum value for a 32-bit signed integer
        // const int INT_MIN = -2147483648; // Minimum value for a 32-bit signed integer

        while (x != 0) {
            int remainder = x % 10;
            x /= 10;

            // Check for potential overflow before updating reversedNum
            if (reversedNum > INT_MAX / 10 || (reversedNum == INT_MAX / 10 && remainder > 7)) {
                return 0; // Overflow on the positive side
            }
            if (reversedNum < INT_MIN / 10 || (reversedNum == INT_MIN / 10 && remainder < -8)) {
                return 0; // Overflow on the negative side
            }
            
            reversedNum = reversedNum * 10 + remainder;
        }

        return reversedNum;
    }
};