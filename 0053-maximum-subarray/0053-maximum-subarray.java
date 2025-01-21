class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE; // Initialize to the smallest integer
        int sum = 0; // This will hold the current subarray sum
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // Add the current element to the sum
            // Update maxSum if the current sum is greater
            if (sum > maxSum) {
                maxSum = sum;
            }
            // Reset sum to 0 if it becomes negative
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum; // Return the maximum subarray sum found
    }
}