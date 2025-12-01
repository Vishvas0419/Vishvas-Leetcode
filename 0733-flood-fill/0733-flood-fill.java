class Solution {
    class Pair{
        int row;int col;
        Pair(int row,int col)
        {
            this.row = row;
            this.col = col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        int oldColor = image[sr][sc];
        int m = image.length; int n = image[0].length;
        if(oldColor==color) return image;
        image[sr][sc] = color;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            int r = curr.row; int c = curr.col;

            //explore 4-directionally
            for(int []d : dirs)
            {
                int nr = r + d[0];
                int nc = c + d[1];
                //check boundary and same color to recolor
                if(nr >= 0 && nr < m && nc >= 0 && nc < n &&
                    image[nr][nc] == oldColor)
                {
                    image[nr][nc] = color; //recolor
                    q.add(new Pair(nr,nc)); //push nbr
                }
            }

        }
        return image;
    }
}