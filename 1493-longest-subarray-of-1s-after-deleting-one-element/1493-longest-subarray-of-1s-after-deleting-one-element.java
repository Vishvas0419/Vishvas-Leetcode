class Solution {
    public int longestSubarray(int[] nums) {
        int i=0,j=0,maxLen=Integer.MIN_VALUE,zeroes=0;
        while(j<nums.length)
        {
            if(nums[j]==0) zeroes++;
            if(zeroes>1)
            {
                while(zeroes>1)
                {
                    if(nums[i]==0) zeroes--;
                    i++;
                }
            }
            maxLen = Math.max(maxLen,j-i); //not j-i+1 because we have to delete one element and then return the maxLen
            j++;
        }
        return maxLen;
    }
}