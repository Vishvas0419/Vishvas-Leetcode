class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[]freq = new int[26];
        for(char x:tasks)
        {
            freq[x-'A']++;
        }        
        Arrays.sort(freq);
        int N=tasks.length;
        int holes = freq[25]-1;
        int slots = holes*n;
        for(int i=24;i>=0;i--)
        {
            slots -= Math.min(holes,freq[i]); //greedy
        }
        return slots<0 ? N : N+slots;
    }
}