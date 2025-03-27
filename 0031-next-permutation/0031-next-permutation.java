class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
    // 1.Find the breaking point index
        int breakIndex = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakIndex = i;
                break;
            }
        }
    // 2.swap the first elem which is greater than breaking index's elem but smaller then remaining elems
        if (breakIndex != -1) {
            for (int i = n - 1; i > breakIndex; i--) {
                if (nums[i] > nums[breakIndex]) {
                    swap(nums,i,breakIndex);
                    break;
                }
            }
        }
    // 3.Reverse the array from breakIndex + 1 to n-1
        reverse(nums,breakIndex + 1,n-1);
    }

    public void swap(int[]nums,int i,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums,int left,int right)
    {
        while(left<right)
        {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++; right--;
        }
    }
}