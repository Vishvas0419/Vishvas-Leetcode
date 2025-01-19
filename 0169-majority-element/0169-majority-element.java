class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int n= nums.length;
        int element=0;
        for(int i=0;i<n;i++)
        {
            if(count==0)
            {
                count=1;
                element = nums[i];
            } 
            else if(element == nums[i]) count++;
            else count--;
        }
        int cnt1=0;
        for(int i=0;i<n;i++)
        {
            if(element==nums[i]) cnt1++;
        }
        if(cnt1>n/2) return element;
        return -1;

    }
}