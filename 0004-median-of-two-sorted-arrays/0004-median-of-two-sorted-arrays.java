class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length+nums2.length];
        int i=0;
        while(i<nums1.length)
        {
            mergedArray[i] = nums1[i];
            i++;
        }
        int j=0;
        while(j<nums2.length)
        {
            mergedArray[nums1.length+j] = nums2[j];
            j++;
        }
        int n = mergedArray.length;
        Arrays.sort(mergedArray);
        if(n%2!=0) return (double)mergedArray[n/2];
        else{
            return (double)(mergedArray[n/2-1] + mergedArray[n/2])/2;
        }
    }
}