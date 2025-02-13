class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int lb = lowerBound(nums,n,target);
        int ub = upperBound(nums,n,target);
        if(lb == n || nums[lb] != target) return new int[]{-1,-1};
        return new int[]{lb,ub-1};
    }
    public int upperBound(int[] nums,int n,int target)
    {
        int low = 0;
        int high = n-1;
        int ans = n;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]>target)
            {
                ans = mid;
                high = mid-1; //look for index in left side
            }
            else{
                low = mid + 1; //look for the right side
            }
        }
        return ans;
    }
    public int lowerBound(int[] nums,int n,int target)
    {
        int low = 0;
        int high = n-1;
        int ans = n;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]>=target)
            {
                ans = mid;
                high = mid-1; //look for index in left side
            }
            else{
                low = mid + 1;//else look for right side 
            }
        }
        return ans;
    }


}