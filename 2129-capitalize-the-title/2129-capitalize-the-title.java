class Solution {
    public String capitalizeTitle(String title) {
        StringBuilder result = new StringBuilder();
        title = title.toLowerCase();
        String[] words = title.split(" ");
        for(String word : words)
        {
            if(word.length()<=2)
            {
                result.append(word);
            }
            else
            {
                char firstChar = Character.toUpperCase(word.charAt(0));
                result.append(firstChar).append(word.substring(1));
            }
            result.append(' ');
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
}
}