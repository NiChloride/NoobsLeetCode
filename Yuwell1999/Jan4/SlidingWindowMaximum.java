package Jan4;

import java.util.ArrayList;
import java.util.List;

// 239
public class SlidingWindowMaximum {
}

// TLE
//class Solution {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (k >= nums.length) {
//            int max = Integer.MIN_VALUE;
//            for (Integer i : nums) {
//                if (i > max) {
//                    max = i;
//                }
//            }
//            return new int[]{max};
//        }
//
//        List<Integer> list = new ArrayList<>(nums.length - k);
//        for (int i = 0; i <= nums.length - k; i++) {
//            int max = nums[i];
//            for (int j = i + 1; j < i + k; j++) {
//                if (nums[j] > max) {
//                    max = nums[j];
//                }
//            }
//            list.add(max);
//        }
//
//        int[] ans = new int[list.size()];
//        for (int i = 0; i < ans.length; i++) {
//            ans[i] = list.get(i);
//        }
//
//        return ans;
//    }
//}
