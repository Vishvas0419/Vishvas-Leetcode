class Solution {
    public int countKDifference(int[] nums, int k) {
        // int cnt = 0;
        // for(int i = 0; i < nums.length; i++){
        //     for(int j = i + 1 ; j < nums.length; j++){
        //         if(Math.abs(nums[i] - nums[j]) == k) cnt++;
        //     }
        // }
        // return cnt;

        int cnt = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(mpp.containsKey(k + nums[i])){
                cnt += mpp.get(k+nums[i]);
            }
            if(mpp.containsKey(nums[i] - k)){
                cnt += mpp.get(nums[i] -k);
            }
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }
        return cnt;
    }
}