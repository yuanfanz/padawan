class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        while (true) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
            if (n == 0) {
                if (sum == 1) return true;
                if (set.contains(sum)) {
                    return false;
                }
                set.add(sum);
                n = sum;
                sum = 0;
            }
        }
    }
}
