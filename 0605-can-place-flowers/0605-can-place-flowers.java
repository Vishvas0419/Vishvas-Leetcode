class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) 
    {
        //edge cases
        if(n==0) return true;
        int size = flowerbed.length;
        if(size==1) return (flowerbed[0]==0 && n<=1);

        for(int i=0;i<size;i++)
        {
            if((flowerbed[i] == 0) &&
              (i==0 || flowerbed[i-1] == 0) &&
              (i==size-1 || flowerbed[i+1] == 0))
            {
                flowerbed[i] = 1;
                n--;
            }
            if(n==0) return true;
        }
        return false;
        
    }
}