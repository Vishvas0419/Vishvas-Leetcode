class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] decryptedCode = new int[n];
        if(k==0) return decryptedCode;
        for(int i=0;i<n;i++)
        {
            int sum = 0;
            if(k>0)
            {
                for(int j=1;j<=k;j++)
                {
                    sum += code[(i+j)%n];
                }
            }
            else if(k<0)
            {
                for(int j=1;j<=-k;j++)
                {
                    sum += code[(i-j+n)%n];
                }
            }

            decryptedCode[i] = sum;
        }
        return decryptedCode;        
    }
}