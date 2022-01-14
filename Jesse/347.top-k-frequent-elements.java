/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> buffer = new HashMap<>();
        for(int num : nums){
            buffer.put(num,buffer.getOrDefault(num,0)+1);
        }
        
      
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a,b) -> buffer.get(b) - buffer.get(a)
        );
        
        for(int num: buffer.keySet()){
            heap.offer(num);
        }
        
        int[] res = new int[k];
        int idx =0;
        while(idx<k){
            res[idx] = heap.poll();
            idx++;
        }
        
        
        
        return res;
    }
}
// @lc code=end

