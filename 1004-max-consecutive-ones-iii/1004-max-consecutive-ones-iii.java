class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0,j=0,maxLen = Integer.MIN_VALUE,zeroes = 0; 
        while(j<nums.length)
        {
            if(nums[j]==0) zeroes++;
            if(zeroes>k)
            {
                if(nums[i]==0) zeroes--;
                i++;
            }
            if(zeroes<=k)
            {
                maxLen = Math.max(maxLen,j-i+1);
            }
            j++;
        }
        return maxLen;
    }
}