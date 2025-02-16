class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int ans = Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[low]<=nums[mid]) //if left half is sorted 
            {
                ans = Math.min(ans,nums[low]); //pick smallest element from low to mid
                low = mid + 1; //and eliminate the left half
            }
            else    //if right half is sorted 
            {
                ans = Math.min(ans,nums[mid]);
                high = mid - 1;
            }
        } 
        return ans;       
    }
}