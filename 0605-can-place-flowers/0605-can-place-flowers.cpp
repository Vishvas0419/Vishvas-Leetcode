class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
        // Edge case: If no flowers need to be planted
        if (n == 0) return true;
        
        int size = flowerbed.size();
        
        // Edge case: Single-element flowerbed
        if (size == 1) {
            return flowerbed[0] == 0 && n <= 1;
        }
        
        // Traverse the flowerbed
        for (int i = 0; i < size; ++i) {
            if (flowerbed[i] == 0 &&
                (i == 0 || flowerbed[i - 1] == 0) &&
                (i == size - 1 || flowerbed[i + 1] == 0)) {
                // Plant a flower here
                flowerbed[i] = 1;
                --n; // Decrement the required flowers count
                if (n == 0) {
                    return true; // Successfully planted all required flowers
                }
            }
        }
        
        // If we finish the traversal and still have flowers to plant
        return false;
    }
};
