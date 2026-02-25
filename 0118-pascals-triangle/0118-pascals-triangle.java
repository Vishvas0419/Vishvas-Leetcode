class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<numRows;i++)
        {
            List<Integer> elems = new ArrayList<>();
            for(int j=0;j<=i;j++)
            {
                elems.add(findnCr(i,j));
            }
            result.add(elems);
        }
        return result;
    }
    private static int findnCr(int n,int r)
    {
        long res = 1;
        for(int i=0;i<r;i++)
        {
            res = res*(n-i);
            res = res/(i+1);
        }
        return (int)res;
    }
}