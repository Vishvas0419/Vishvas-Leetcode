class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // find given window(k) sum first 
        int leftSum = 0,rightSum = 0,maxSum = 0;
        for(int i=0;i<k;i++)
        {
            leftSum += cardPoints[i];
            maxSum = leftSum;
        }
// shrink window of leftSum from k to 0 and add elements from right to rightSum and update maxSum simultaneously 
        int rightIndex = cardPoints.length-1;
        for(int i=k-1;i>=0;i--)
        {
            leftSum -= cardPoints[i];
            rightSum += cardPoints[rightIndex];
            rightIndex--;
            maxSum= Math.max(maxSum,leftSum+rightSum);
        }
        return maxSum;
    }
}