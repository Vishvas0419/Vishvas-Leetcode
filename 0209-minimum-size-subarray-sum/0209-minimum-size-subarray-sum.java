class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0, minLen = Integer.MAX_VALUE;
        while(right<n)
        {
            sum+=nums[right];
            while(sum>=target){
            minLen = Math.min(minLen,right-left+1);
            //shrink sum from left to check smallest size having sum>=target
            sum -= nums[left];
            left++; //reduce the window size
            }
            right++;
        }
    return (minLen==Integer.MAX_VALUE) ? 0 : minLen;
    }
}