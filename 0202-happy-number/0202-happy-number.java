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
    public int findNext(int num)
    {
        int sum = 0;
        while(num>0)
        {
            int digit = num%10;
            sum = sum + (int)Math.pow(digit,2);
            num = num/10;        
        }
        return sum;
    }
}