class Solution {
    static String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;
        StringBuilder str = new StringBuilder();
        backtrack(0, result, str, digits);
        return result;
    }
    private static void backtrack(int index, List<String> result, StringBuilder str, String digits)
    {
        if(index == digits.length())
        {
            result.add(str.toString());
            return;
        }
        String s = map[digits.charAt(index) - '0'];
        for(char ch : s.toCharArray())
        {
            str.append(ch);
            backtrack(index + 1, result, str, digits);
            str.deleteCharAt(str.length() - 1);
        }
    }
}