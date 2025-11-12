class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++) map.put(score[i],i);
        Arrays.sort(score);
        for(int i=n-1;i>=0;i--)
        {  
            int originalIndex = map.get(score[i]);
            int rank = n-i;
            if(rank==1) result[originalIndex] = "Gold Medal";
            else if(rank==2) result[originalIndex] = "Silver Medal";       
            else if(rank==3) result[originalIndex] = "Bronze Medal";
            else result[originalIndex] = String.valueOf(rank);       
        }
        return result;
    }
}