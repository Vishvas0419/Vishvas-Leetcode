public class Solution {
    public static int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int result = -1;

        for (int num : nums) {
            if (num % 2 == 0) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
                int freq = freqMap.get(num);

                if (freq > maxFreq || (freq == maxFreq && num < result)) {
                    maxFreq = freq;
                    result = num;
                }
            }
        }

        return result;
    }
}
