class Solution {
    public int[] productExceptSelf(int[] nums) {
        // left product
        int n = nums.length;
        int result[] = new int[n];
        result[0] = 1;
        for(int i=1;i<n;i++)
        {
            result[i] = result[i-1] * nums[i-1];
        }      
        // Step 2: Calculate suffix products (right of current index)
        // We'll multiply right products into result array directly  
        int rightProduct = 1;
        for(int i = n-1;i>=0;i--)
        {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return result;        
    }
}