package Jan11;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 39
class CombinationSum {
    List<List<Integer>> ans = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        dfs(candidates, target, 0);

        return ans;
    }

    public void dfs(int[] candidates, int targetSum, int startIndex) {
        if (targetSum <= 0) {
            if (targetSum == 0) {
                ans.add(new LinkedList<>(path));
            }

            return;
        }

        for (int i = startIndex; i < candidates.length && candidates[i] <= targetSum; i++) {
            path.add(candidates[i]);
            targetSum -= candidates[i];

            // 数字可重复选择，可重复读取当前数字
            dfs(candidates, targetSum, i);

            targetSum += candidates[i];
            path.pollLast();
        }
    }
}