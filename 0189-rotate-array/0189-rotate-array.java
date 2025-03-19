class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n==0) return;
        k = k%n; //to rotate only remainder of k/n
        if(k>n) return;
        // 1. reverse first n-k elements 
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
    }
    void reverse(int[] nums,int left,int right)
    {
        while(left<=right)
        {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++; right--;
        }
    }
}