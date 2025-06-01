class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0 , right = 0;
        int zeroes = 0;
        int maxLen = Integer.MIN_VALUE;
        int len = 0;
        while(right<n)
        {
            if(nums[right]==0) zeroes++;
            if(zeroes>k)
            {
                if(nums[left]==0) zeroes--;
                left++;
            }
            if(zeroes<=k)
            {
                len = right-left+1;
                maxLen = Math.max(maxLen,len);
            }
            right++;
        }
        return maxLen;

        
    }
}