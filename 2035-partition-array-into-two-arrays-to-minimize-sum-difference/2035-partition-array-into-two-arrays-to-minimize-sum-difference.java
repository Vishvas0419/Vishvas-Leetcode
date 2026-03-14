class Solution {

    public int minimumDifference(int[] nums) {

        int n = nums.length / 2;

        int total = 0;
        for (int num : nums)
            total += num;

        List<Integer>[] left = generateSubsets(nums, 0, n);
        List<Integer>[] right = generateSubsets(nums, n, 2 * n);

        for (int i = 0; i <= n; i++)
            Collections.sort(right[i]);

        int ans = Integer.MAX_VALUE;

        for (int k = 0; k <= n; k++) {

            for (int lsum : left[k]) {

                int target = total / 2 - lsum;

                List<Integer> list = right[n - k];

                int idx = Collections.binarySearch(list, target);

                if (idx < 0)
                    idx = -idx - 1;

                if (idx < list.size()) {
                    int sum = lsum + list.get(idx);
                    ans = Math.min(ans, Math.abs(total - 2 * sum));
                }

                if (idx > 0) {
                    int sum = lsum + list.get(idx - 1);
                    ans = Math.min(ans, Math.abs(total - 2 * sum));
                }
            }
        }

        return ans;
    }


    private List<Integer>[] generateSubsets(int[] nums, int start, int end) {

        int n = end - start;

        List<Integer>[] result = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++)
            result[i] = new ArrayList<>();

        int limit = 1 << n;

        for (int mask = 0; mask < limit; mask++) {

            int sum = 0;
            int count = 0;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {
                    sum += nums[start + i];
                    count++;
                }
            }

            result[count].add(sum);
        }

        return result;
    }
}