class Solution {
    public int minimumRecolors(String blocks, int k) {
        int i=0,j=0,count=0,minCount = Integer.MAX_VALUE;
        while(j<blocks.length())
        {
            if(blocks.charAt(j)=='W') count++;
            if(j-i+1==k)
            {
                minCount = Math.min(minCount,count);
                if(blocks.charAt(i)=='W') count--;
                i++;
            }
            j++;
        }
        return minCount;
    }
}