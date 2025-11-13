class Solution {
    public int[] sortArray(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0;i<nums.length;i++)
        {
            result[i] = nums[i];
        }
        Arrays.sort(result);
        return result;
    }
}