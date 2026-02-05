class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int i = 0 , j = 0;
        int zeroes = 0;
        int maxLen = Integer.MIN_VALUE;
        int len = 0;
        while(j<n)
        {
            if(nums[j]==0) zeroes++;
            if(zeroes>k)
            {
                if(nums[i]==0) zeroes--;
                i++;
            }
            if(zeroes<=k)
            {
                len = j-i+1;
                maxLen = Math.max(maxLen,len);
            }
            j++;
        }
        return maxLen;

        
    }
}