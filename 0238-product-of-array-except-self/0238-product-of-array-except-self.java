class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Calculate prefix products (left of current index)
        // result[i] will store the product of all elements to the left of index i
        result[0] = 1; // First element has no elements to its left
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
            // result[i] = product of nums[0] to nums[i - 1]
        }

        // Step 2: Calculate suffix products (right of current index)
        // We'll multiply right products into result array directly
        int rightProduct = 1; // Initially 1 (nothing on the right of last element)
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
            // At each step, rightProduct = product of nums[i+1] to nums[n-1]
        }

        return result;
    }
}
