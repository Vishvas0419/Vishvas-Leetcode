class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        //apply moore's voting algorithm
        int count = 0;
        int elem = 0;
        for(int i=0;i<n;i++)
        {
            if(count==0) elem = nums[i];
            if(elem==nums[i]) count++;
            else count--;
        }   
        // verify that current elem is our majority element by checking if count>n/2
        count=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==elem) count++;
        }
        if(count > n/2) return elem;
        return -1;
    }
}