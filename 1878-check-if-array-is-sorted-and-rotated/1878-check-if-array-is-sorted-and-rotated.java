class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>nums[(i+1)%n])  //ensures circular traversal, wrapping around from the last element to the first.
            {
                count++;
            }
            if(count>1)
            {
                return false;
            }
        }        
        return true; //the moment array completes its iteartion,it means that array is sorted
    }
}