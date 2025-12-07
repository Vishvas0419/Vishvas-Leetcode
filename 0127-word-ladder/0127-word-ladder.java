class Solution {
    class Pair{
        String word;
        int count;
        Pair(String word,int count){
            this.word = word;
            this.count = count;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair>q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> st = new HashSet<>();
        for(int i=0;i<wordList.size();i++)
        {
            st.add(wordList.get(i));
        }
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            String word = p.word;
            int steps = p.count;
            if(word.equals(endWord)) return steps;
            char [] charArr = word.toCharArray();
            for(int i=0;i<charArr.length;i++)
            {
                char original = charArr[i];
                for(char ch='a';ch<='z';ch++)
                {
                    charArr[i] = ch;
                    String newWord = new String(charArr);
                    if(st.contains(newWord))
                    {
                        st.remove(newWord);
                        q.add(new Pair(newWord,steps+1));
                    }
                }
                charArr[i] = original;
            }
        }
        return 0;
    }
}