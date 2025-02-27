class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long val = (long) m * k;
        if (n < val) return -1; // Not enough flowers to make bouquets

        int low = minElem(bloomDay);
        int high = maxElem(bloomDay);
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMakeBouquets(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canMakeBouquets(int[] nums, int day, int m, int k) {
        int count = 0;
        int noOfBouquets = 0;

        for (int num : nums) {
            if (num <= day) {
                count++; // Count consecutive blooming flowers
                if (count == k) { // If we form a bouquet
                    noOfBouquets++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }
        return noOfBouquets >= m;
    }

    private int minElem(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            min = Math.min(min, num);
        }
        return min;
    }

    private int maxElem(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }
}
