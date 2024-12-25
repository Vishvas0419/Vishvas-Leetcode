class Solution {
public:
    int valueOfRoman(char c)
    {
        if(c=='I') return 1;
        else if(c=='V') return 5;
        else if(c=='X') return 10;
        else if(c=='L') return 50;
        else if(c=='C') return 100;
        else if(c=='D') return 500;
        else if(c=='M') return 1000;
        else return 0;
    }
    int romanToInt(string s) {
        int n = s.length();
        vector<int>values(n);
// Convert each Roman numeral in the string to its respective value
        for(int i=0;i<n;i++)
        {
            values[i] = valueOfRoman(s[i]);
        }

        int result = 0;
// Traverse through the vector
        for(int i=0;i<n;i++)
        {
// If the current value is less than the next one, subtract it
            if(i<n-1 && values[i] < values[i+1])
            {
                result = result - values[i];
            }
            else   //else add it
            {
                result = result + values[i];
            }
        }   
        return result;  
    }
};