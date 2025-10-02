class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int zeroes = 0; int product = 1;
        int [] result = new int[n];
        for(int num : nums)
        {
            if(num == 0) zeroes++;
            else product *= num;
        }
        for(int i=0;i<n;i++)
        {
            if(zeroes == 1)
            {
                if(nums[i] == 0) result[i] = product;
            }
            else if(zeroes > 1) result[i] = 0;
            else result[i] = product/nums[i];
        }
        return result;
        
    }
}