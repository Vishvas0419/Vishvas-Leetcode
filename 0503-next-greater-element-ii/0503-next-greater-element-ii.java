class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int [] result = new int[n];
        for(int i=0;i<n;i++)
        {
            result[i] = -1;
            for(int j=i+1;j<i+n;j++)
            {
                int index = j%n;
                if(nums[index]>nums[i])
                {
                    result[i] = nums[index];
                    break;
                }
                // else result[index] = -1;
            }
        }
        return result;
        
    }
}