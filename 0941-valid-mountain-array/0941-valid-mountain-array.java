class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length; int peak = 0;
        if (n < 3) return false;
        // find peak
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i-1]) peak = i;
            else break;
        }
        // peak can't be first or last
        if (peak == 0 || peak == n-1) return false;
        // check decreasing part
        for (int i = peak + 1; i < n; i++) {
            if (arr[i] >= arr[i-1])
                return false;
        }
        return true;
    }
}
