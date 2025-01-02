class Solution {
public:
    vector<int> runningSum(vector<int>& nums) {
        int sum = 0;
        vector<int>runningSum;
        for(int i=0;i<nums.size();i++)
        {
            int currentSum = sum + nums[i];
            runningSum.push_back(currentSum);
            sum = currentSum;
        }
        return runningSum;
        
    }
};