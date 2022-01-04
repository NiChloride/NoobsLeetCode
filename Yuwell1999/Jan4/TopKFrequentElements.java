package Jan4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// 347
class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        // Map统计
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // 小顶堆大小为k
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 小顶堆比较频率
                return o1[1] - o2[1];
            }
        });

        for (Integer key : map.keySet()) {
            int count = map.get(key);
            if (pq.size() < k) {
                pq.offer(new int[]{key, count});
            } else {
                if (pq.peek()[1] < count) {
                    pq.poll();
                    pq.offer(new int[]{key, count});
                }
            }
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }

        return ans;
    }
}