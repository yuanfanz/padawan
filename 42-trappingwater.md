class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Map<Integer, int[]> map = getMax(height);
        // get MIN of left and right MAX
        Map<Integer, Integer> minMap = new HashMap<>();
        Iterator entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            int index = (int) entry.getKey();
            int[] maxArr = (int[]) entry.getValue();
            if (maxArr[0] > maxArr[1]) {
                minMap.put(index, maxArr[1]);
            } else {
                minMap.put(index, maxArr[0]);
            }
        }
        int result = 0;
        for (int i = 0; i < height.length; ++i) {
            int bar = minMap.get(i) - height[i];
            if (bar > 0) {
                result += bar;
            }
        }
        return result;
    }
    private Map<Integer, int[]> getMax(int[] nums) {
        Map<Integer, int[]> result = new HashMap<>();
        
        for (int i = 0; i < nums.length; ++i) {
            int[] maxArr = new int[]{0,0};
            int leftMax = 0;
            if (i == 0) {
                leftMax = 0;
            } else if (i == 1) {
                leftMax = nums[0];
            } else {
                int left = i - 1;
                while (left >= 0) {
                    if (nums[left] > leftMax) {
                        leftMax = nums[left];
                    }
                    left--;
                }
            }
            maxArr[0] = leftMax;
            result.put(i, maxArr);
        }
        for (int i = 0; i < nums.length; ++i) {
            int rightMax = 0;
            if (i == nums.length - 1) {
                rightMax = 0;
            } else if (i == nums.length - 2) {
                rightMax = nums[nums.length - 1];
            } else {
                int right = i + 1;
                while (right <= nums.length - 1) {
                    if (nums[right] > rightMax) {
                        rightMax = nums[right];
                    }
                    right++;
                }
            }
            int[] maxArr = result.get(i);
            maxArr[1] = rightMax;
            result.put(i, maxArr);
        }
        return result;
    }
}
