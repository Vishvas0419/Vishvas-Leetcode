class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i=0;i<n;i++)
        {
            if(nums[i] == 0)
            {
                result[i]=0;
            }
            else if(nums[i]>0)
            {
                int newIndex = (i+nums[i] ) % n;
                result[i] = nums[newIndex];
            }
            else
            {
                int steps = Math.abs(nums[i]);
                int newIndex = (i - steps%n + n) % n; 
                result[i] = nums[newIndex];
            }
        }
        return result;
    }
}