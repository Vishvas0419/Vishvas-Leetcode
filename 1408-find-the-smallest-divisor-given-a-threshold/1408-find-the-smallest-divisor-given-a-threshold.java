class Solution {
    public int sumOfDivisions(int[] arr, int divisor) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (int) Math.ceil((double) arr[i] / divisor);
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;

        // Find max element for 'high' ptr
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }
        int low = 1;
        int high = max;
        // int ans = -1;
        // apply binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sumOfDivisions(nums, mid) <= threshold) {
                // ans = mid; //new divisor
                high = mid - 1; // look for smaller ans so eliminate right half
            } else {
                low = mid + 1; // else if ans is too small search on right side
            }
        }
        return low;
    }
}