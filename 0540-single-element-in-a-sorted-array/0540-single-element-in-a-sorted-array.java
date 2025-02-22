class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        for (int i = 0; i < n; i++) {
            // Check the first element
            if (i == 0 && nums[i] != nums[i + 1]) return nums[i];
            // Check the last element
            else if (i == n - 1 && nums[i] != nums[i - 1]) return nums[i];
            // Check middle elements
            else if (i > 0 && i < n - 1) {
                if (nums[i - 1] != nums[i] && nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
