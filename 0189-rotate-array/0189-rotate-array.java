class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n==1) return;
        k=k%n;
        if(k>n) return;
        //reverse first k numbers
        reverse(nums,0,n-k-1);
        //reverse last n-k numbers
        reverse(nums,n-k,n-1);
        //finally reverse whole array
        reverse(nums,0,n-1);
    }
    public void reverse(int[] nums,int left,int right)
    {
        while(left<=right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp; 
            left++;
            right--;
        }
    }
}