class Solution {
    public int divisorSubstrings(int num, int k) {
        String str = Integer.toString(num);
        int i=0,j=0,count=0;
        while(j<str.length())
        {
            if(j-i+1==k)
            {
                String temp = str.substring(i,j+1);
                int val = Integer.parseInt(temp);
                if(val!=0 && num%val==0) count++;
                i++;
            }
            j++;
        }
        return count;
    }
}