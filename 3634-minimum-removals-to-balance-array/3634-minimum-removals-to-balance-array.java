class Solution {
    public int minRemoval(int[] nums, int k) {
        int j=0,maxKeep = 1;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++)
        {
            while(j<n && (long)nums[j]<=(long)nums[i]*k)
            {
                j++;
            }
            //the curr segment between i....j-1 is valid
            maxKeep = Math.max(maxKeep,j-i);
        }
        return n-maxKeep;
    }
}