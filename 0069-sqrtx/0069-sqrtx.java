class Solution {
    public int mySqrt(int x) {
        long low  = 1;
        long high = x;
        long ans = 1;
        while(low<=high)
        {
            long mid = low + (high-low)/2;
            if(mid*mid<=x)
            {
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return (int)high;
    }
}