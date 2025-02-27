class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long val = (long) m * k;
        if(n<val) return -1;
        
        int low = minElem(bloomDay);
        int high = maxElem(bloomDay);
        int ans = high;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(possible(bloomDay,mid,m,k))
            {
                high = mid-1; 
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    public boolean possible(int[]nums,int day,int m,int k)
    {
        int count = 0;
        int no_of_Bouques = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] <= day) //blooming is possible
            {
                count++; //count consecutive possible blooming Days
            }
            else{
                no_of_Bouques += count/k;
                count = 0;
            }
        }
        no_of_Bouques += count/k;
        if(no_of_Bouques >= m) return true;
        else return false;

    }
    public int minElem(int[]arr)
    {
        int min = Integer.MAX_VALUE;
        int n = arr.length;
        for(int i=0;i<n;i++)
        {
            min = Math.min(min,arr[i]);
        }
        return min;
    }
    public int maxElem(int[]arr)
    {
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        for(int i=0;i<n;i++)
        {
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}