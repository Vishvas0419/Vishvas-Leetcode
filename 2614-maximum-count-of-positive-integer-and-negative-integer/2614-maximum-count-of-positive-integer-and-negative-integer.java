class Solution {
    public int maximumCount(int[] nums) {
        int neg = countNegatives(nums);
        int pos = countPositives(nums);
        return Math.max(neg,pos);
    }
    public static int countNegatives(int[]nums)
    {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(nums[mid]<0)
            {
                low = mid +1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
    public static int countPositives(int[]nums)
    {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(nums[mid]>0)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return n - low;//this will give no of positives between our search space
    }
}