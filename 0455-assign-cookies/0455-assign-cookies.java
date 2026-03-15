class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); Arrays.sort(s); int count=0;
        int child=0,cookie=0;
        while(child<g.length && cookie<s.length)
        {
            //if greed factor of child is less than or equal to the size of current cookie you can feed it to child
            if(s[cookie] >= g[child]) 
            {
                child++;
            } 
            cookie++; //always move to next cookie if you cant feed it to some child
        }
        return child; //return no of childs feed 
    }
}