class Solution {
    public int maximumCount(int[] nums) {
        int countP = pos(nums,0,nums.length-1);
        int countN = neg(nums,0,nums.length-1);
        return Math.max(countP,countN);
        
    }
    public int neg(int[]nums,int low,int high)
    {
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]<0)
            {
                low = mid+1; //then check right side for any negatives
            }
            else high = mid-1;
        }
        return low;
    }
    public int pos(int[]nums,int low,int high)
    {
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]>0)
            {
                high = mid-1;//then check right side for any positives
            }
            else low = mid+1; 
        }
        return nums.length - low;
    }
}