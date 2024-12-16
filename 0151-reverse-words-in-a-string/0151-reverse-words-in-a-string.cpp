class Solution {
public:
    string reverseWords(string s) {
        vector<string> words; // To store individual words
        string currentWord;   // To build the current word
        string result;        // To store the final result

        // Step 1: Parse the string to extract words
        for (char ch : s) {
            if (ch == ' ') {
                if (!currentWord
                         .empty()) { // If a word is formed, add it to the list
                    words.push_back(currentWord);
                    currentWord.clear(); // Reset for the next word
                }
            } else {
                currentWord += ch; // Add non-space characters to current word
            }
        }
        if (!currentWord.empty()) { // Add the last word if present
            words.push_back(currentWord);
        }

        // Step 2: Reverse the list of words and construct the result
        for (int i = words.size() - 1; i >= 0; --i) {
            result += words[i];
            if (i != 0)
                result += " "; // Add a single space between words
        }

        return result;
    }
};
