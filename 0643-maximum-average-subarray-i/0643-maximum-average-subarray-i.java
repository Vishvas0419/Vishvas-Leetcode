class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i=0,j=0;
        double sum=0,maxSum = -Double.MAX_VALUE;
        while(j<nums.length)
        {
            sum += nums[j];
            if(j-i+1 < k) j++; //expand the window
            else if(j-i+1 == k)
            {
                if(sum>maxSum) maxSum = sum;
                sum -= nums[i]; //update the sum
                i++; j++;
            }
        }
        return maxSum/k;
    }
}