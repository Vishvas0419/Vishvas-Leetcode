class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroes = 0;
        int product  = 1;
        int result[] = new int [nums.length];
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] ==0) zeroes++;
            else product *= nums[i];
        }
        for(int i=0;i<nums.length;i++)
        {
            if(zeroes==1)
            {
                if(nums[i]==0) result[i] = product;
            }
            else if(zeroes>1) result[i] = 0;
            else result[i] = product/nums[i];
        }
        return result;
    }
}