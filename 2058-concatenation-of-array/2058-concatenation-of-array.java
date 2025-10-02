class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int [] arr = new int[n*2];
        int j = 0;
        for(int i=0;i<n;i++)
        {
            arr[j++] = nums[i];
        }
        for(int i=0;i<n;i++)
        {
            arr[j++] = nums[i];
        }  
        return arr;
        
    }
}