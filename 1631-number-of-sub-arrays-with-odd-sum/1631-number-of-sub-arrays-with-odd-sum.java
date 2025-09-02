class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1_000_000_007;
        long count = 0;
        long sum = 0;
        long even = 1; long odd = 0;
        for(int num : arr)
        {
            sum += num;
            if(sum % 2 ==0)
            {
                count = (count + odd) % mod;
                even++;
            }
            else{
                count = (count + even) % mod;
                odd++;
            }
        }
        return (int) count;
    }
}