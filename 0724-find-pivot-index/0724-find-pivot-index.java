class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0, leftSum = 0, rightSum;
        for(int num : nums)
        {
            totalSum += num;
        }
        for(int i=0;i<nums.length;i++)
        {
            rightSum = totalSum - leftSum - nums[i];
            if(rightSum == leftSum) return i;
            else{
                leftSum += nums[i];
            }
        }
        return -1;  
    }
}