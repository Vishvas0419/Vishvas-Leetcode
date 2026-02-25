class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer>ans = new ArrayList<>();
        for(int i=0;i<=rowIndex;i++)
        {
            ans.add(findnCr(rowIndex,i));
        }
        return ans;
    }
    private static int findnCr(int n,int c)
    {
        long res = 1;
        for(int i=0;i<c;i++)
        {
            res = res*(n-i);
            res = res/(i+1);
        }
        return (int)res;
    }
}