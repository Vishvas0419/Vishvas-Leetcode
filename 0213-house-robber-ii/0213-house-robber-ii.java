class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int temp1 = helper(nums,0,n-2);
        int temp2 = helper(nums,1,n-1);
        return Math.max(temp1,temp2);
    }
    public int helper(int []nums,int start,int end)
    {
        if(start==end) return nums[start];
       int prev2 = nums[start]; 
        int prev = Math.max(nums[start],nums[start+1]);
        for(int i=start+2;i<=end;i++)
        {
            int pick = nums[i] + prev2;
            int notPick = 0 + prev;
            int curr = Math.max(pick,notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}