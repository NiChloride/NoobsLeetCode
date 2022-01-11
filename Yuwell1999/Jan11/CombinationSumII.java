package Jan11;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 40
class CombinationSumII {
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
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }

            targetSum -= candidates[i];
            path.add(candidates[i]);

            dfs(candidates, targetSum, i + 1);

            targetSum += candidates[i];
            path.pollLast();
        }
    }
}