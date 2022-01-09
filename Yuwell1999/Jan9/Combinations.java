package Jan9;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 77
class Combinations {
    List<List<Integer>> ans = new LinkedList<>();
    Deque<Integer> layer = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return ans;
    }

    public void dfs(int n, int k, int start) {
        if (layer.size() == k) {
            ans.add(new LinkedList<>(layer));
            return;
        }

        // n=4, k=2
        // 已选layer.size(), 还需要选k-layer.size()个
        // 数组下标从n-(k-layer.size())+1开始选起
        for (int i = start; i <= n - (k - layer.size()) + 1; i++) {
            layer.add(i);
            dfs(n, k, i + 1);
            layer.pollLast();
        }
    }
}