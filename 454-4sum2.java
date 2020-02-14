class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = A.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int sum = A[i] + B[j];
                if (!map.containsKey(sum)) {
                    map.put(sum, 0);
                }
                map.put(sum, map.get(sum) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int sum = C[i] + D[j];
                int target = 0 - sum;
                if (map.containsKey(target)) {
                    count += map.get(target);
                }
            }
        }
        return count;
    }
}
