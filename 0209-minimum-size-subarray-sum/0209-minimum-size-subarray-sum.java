    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int i=0,j=0,minLen = Integer.MAX_VALUE,sum=0;
            while(j<nums.length)
            {
                sum += nums[j];
                if(sum>=target) //if window becomes invalid make it valid while it is invalid(sum>=target)
                {
                while(sum>=target)
                {
                    minLen = Math.min(minLen,j-i+1);
                    sum = sum-nums[i];
                    i++;
                }
                }
                j++;
            }
            return minLen==Integer.MAX_VALUE ? 0 : minLen;

        }
    }