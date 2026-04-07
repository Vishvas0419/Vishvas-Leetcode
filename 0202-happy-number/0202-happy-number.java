class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n))
        {
            set.add(n);
            n = findNext(n);
        }
        return n==1;
    }   
    private static int findNext(int n)
    {
        int sum = 0;
        while(n>0)
        {
            int digit = n%10;
            sum += (int)Math.pow(digit,2);
            n = n/10;
        }
        return sum;
    }
}