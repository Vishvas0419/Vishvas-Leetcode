class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
    Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
      int count = 0;
      int lastEnd = Integer.MIN_VALUE;
      for(int i=0;i<n;i++)
      {
          int s = intervals[i][0];
          int e = intervals[i][1];
          if(s>=lastEnd) // choose interval only if it doesn't overlap
          {
              count++;
              lastEnd = e;
          }
      }
      return n-count;
    }
}