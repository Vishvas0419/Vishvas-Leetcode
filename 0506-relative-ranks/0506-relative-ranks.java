class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        // Max-heap storing [score, index]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // Add all scores with their indices
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{score[i], i});
        }

        int rank = 1;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int idx = curr[1];

            if (rank == 1) result[idx] = "Gold Medal";
            else if (rank == 2) result[idx] = "Silver Medal";
            else if (rank == 3) result[idx] = "Bronze Medal";
            else result[idx] = String.valueOf(rank);

            rank++;
        }

        return result;
    }
}