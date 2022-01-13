package Jan9;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 216
class CombinationSumIII {
    List<List<Integer>> ans = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int targetSum) {
        dfs(k, targetSum, 1);
        return ans;
    }

    public void dfs(int k, int targetSum, int startIndex) {
        // 剪枝
        if (targetSum < 0) {
            return;
        }

        if (path.size() == k) {
            if (targetSum == 0) {
                ans.add(new LinkedList<>(path));
            }
            return;
        }

        // for循环剪枝优化
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            targetSum -= i;

            dfs(k, targetSum, i + 1);

            targetSum += i;
            path.pollLast();
        }
    }
}