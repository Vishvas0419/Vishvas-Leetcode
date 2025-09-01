class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] altitudes = new int[n+1];
        int maxAltitude =0;
        altitudes[0] = 0;
        for(int i=0;i<gain.length;i++)
        {
            altitudes[i+1] = altitudes[i]+gain[i];
            maxAltitude = Math.max(altitudes[i+1],maxAltitude);
        }
        return maxAltitude;
    }
}