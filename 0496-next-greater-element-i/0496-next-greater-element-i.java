class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            int index = -1;
            
            // Find index of num in nums2
            for (int j = 0; j < n; j++) {
                if (nums2[j] == nums1[i]) {
                    index = j;
                    break;
                }
            }

            // Find next greater element in nums2
            int nextGreater = -1;
            for (int j = index + 1; j < n; j++) {
                if (nums2[j] > nums1[i]) {
                    nextGreater = nums2[j];
                    break;
                }
            }

            result[i] = nextGreater;
        }

        return result;
    }
}
