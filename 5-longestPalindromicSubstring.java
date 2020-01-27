class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return s.substring(1);
            }
        }
        int maxLen = 0;
        int maxStart = 0;
        int maxEnd = s.length() - 1;
        for (int i = 0; i < s.length(); ++i) {
            int start = i - 1;
            while (start >= 0 && s.charAt(start) == s.charAt(i)) start--;
            int end = i + 1;
            while (end < s.length() && s.charAt(end) == s.charAt(i)) end++;
            
            while (start >= 0 && end < s.length()) {
                if (s.charAt(start) == s.charAt(end)) {
                    start--;
                    end++;
                } else break;
            }
            
            if (end - start - 1 > maxLen) {
                maxStart = start + 1;
                maxEnd = end - 1;
                maxLen = end - start - 1;
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
}
