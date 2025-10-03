class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> hm = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        String arr[] = s.split(" ");
        if(pattern.length() != arr.length){
            return false;
        }
        for(int i=0; i<pattern.length(); i++){
            String word = arr[i];
            char ch = pattern.charAt(i);

            if(hm.containsKey(ch)){
                if(!hm.get(ch).equals(word)){
                    return false;
                }
            }else{
                if(set.contains(word)){
                    return false;
                }else{
                    hm.put(ch, word);
                    set.add(word);
                }
            }
        }
        return true;
    }
}