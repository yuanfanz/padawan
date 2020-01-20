class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        
        int leftMax = 0;
        int rightMax = 0;
        left[0] = 0;
        right[height.length - 1] = 0;
        for (int i = 1; i < height.length; ++i) {
            if (height[i - 1] > leftMax) {
                leftMax = height[i - 1];
            }
            left[i] = leftMax;
        }
        for (int i = height.length - 2; i >= 0; --i) {
            if (height[i + 1] > rightMax) {
                rightMax = height[i + 1];
            }
            right[i] = rightMax;
        }
        int result = 0;
        for (int i = 0; i < height.length; ++i) {
            int water = 0;
            if (left[i] > right[i]) {
                water = right[i];
            } else {
                water = left[i];
            }
            int bar = water - height[i];
            if (bar > 0) {
                result += bar;
            }
        }
        return result;
    }
}
