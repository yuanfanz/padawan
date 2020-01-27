class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<String, Integer> map = new HashMap<>();
        String[] strs = s.split("");
        for (String str : strs) {
            if (!map.containsKey(str)) {
                map.put(str, 0);
            }
            map.put(str, map.get(str) + 1);
        }
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value % 2 == 1) {
                count++;
            }
        }
        if (count > 1) {
            return false;
        } else return true;
    }
}
