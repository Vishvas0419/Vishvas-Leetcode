class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        if(target<nums[0])
        return 0;
        for(int i=0;i<nums.size();i++)
        {
            if(nums[i]==target)   return i;
            if(i<nums.size()-1 && nums[i] < target && target < nums[i+1])
            return i+1;  
        }
        return nums.size();      
    }
   // The condition i < nums.size() - 1 in your code ensures that you don't access an element out of bounds when trying to evaluate nums[i+1]., avoiding the heap-buffer-overflow.
};