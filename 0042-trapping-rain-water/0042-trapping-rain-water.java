class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int [] pge = new int[n];
        int [] nge = new int[n];

        pge[0] = height[0];
        for(int i=1;i<n;i++)
        {
            pge[i] = Math.max(height[i],pge[i-1]);
        }

        nge[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--)
        {
            nge[i] = Math.max(height[i],nge[i+1]);
        }
        
        int sum = 0;
        for(int i=0;i<n;i++)
        {
            sum += Math.min(pge[i],nge[i]) - height[i];
        }
        return sum;
    }
}