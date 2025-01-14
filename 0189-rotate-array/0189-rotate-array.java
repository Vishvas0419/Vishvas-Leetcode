class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k=k%n;
        // First reverse first k elements
        reverse(nums,0,n-k-1);
        // Then reverse remaining n-k elements
        reverse(nums,n-k,n-1);
        // Then finally reverse whole array elements
        reverse(nums,0,n-1);
    }
    public static void reverse(int[] nums,int start,int end)
        {
            while(start<=end)
            {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }  
}