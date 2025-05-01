class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer>set = new HashSet<>();
        while(n!=1 && !set.contains(n))
        {
            set.add(n);
            n = getNext(n);
        }
        return n==1; 
    }
    public int getNext(int n)
    {
        int sum = 0;
        while(n>0)
        {
            int digit = n%10;
            sum += digit*digit;
            n=n/10;
        }
        return sum;
    }
}