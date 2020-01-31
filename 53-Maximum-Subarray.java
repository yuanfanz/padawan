class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            prefix[i] = nums[i] + prefix[i - 1];
        }
        int leftSumMax = Integer.MIN_VALUE;
        int leftMin = 0;
        for (int i = 0; i < prefix.length; ++i) {
            leftSumMax = Math.max(leftSumMax, prefix[i] - leftMin);
            leftMin = Math.min(leftMin, prefix[i]);
        }
        return leftSumMax;
    }
}
