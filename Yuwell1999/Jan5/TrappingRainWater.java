package Jan5;

// 42
class TrappingRainWater {
    public int trap(int[] height) {
        int[] leftBin = new int[height.length];
        int[] rightBin = new int[height.length];

        leftBin[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftBin[i] = Math.max(height[i], leftBin[i - 1]);
        }

        rightBin[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightBin[i] = Math.max(height[i], rightBin[i + 1]);
        }

        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(leftBin[i], rightBin[i]) - height[i];
        }

        return ans;
    }
}