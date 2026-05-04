class Solution {
    public int maxArea(int[] height) {
        //area of rectangle  = length * breadth
        //here width = diff btw indices , length = min(height[left],height[right])
        int maxArea = Integer.MIN_VALUE; int area = 1;
        int left = 0; int right = height.length-1;
        while(left<right)
        {
            int length = Math.min(height[left],height[right]);
            int width = right-left;
            area = length * width;
            maxArea = Math.max(maxArea,area);
             // Move the smaller height pointer
             if(height[left]<height[right]) left++;
             else right--;
        }
        return maxArea;
    }
}