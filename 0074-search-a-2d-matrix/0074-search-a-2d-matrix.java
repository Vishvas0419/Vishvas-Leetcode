class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][0]<=target && target<=matrix[i][m-1])
                {
                    return binarySearch(matrix[i],target);
                }
            }
        }
        return false;
                
    }
    public boolean binarySearch(int[] arr,int target)
    {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(arr[mid]==target) return true;
            else if(arr[mid]<=target)
            {
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
}