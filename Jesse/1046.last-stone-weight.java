/*
 * @lc app=leetcode id=1046 lang=java
 *
 * [1046] Last Stone Weight
 */

// @lc code=start
class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int stone : stones){
            heap.add(stone);
        }
        
        int res =0;
        
        while(heap.size() > 1){
            int stone1 = heap.poll();
            int stone2 = heap.poll();
            int remain = Math.abs(stone1-stone2);
            if(remain !=0){
                heap.add(remain);
            }
        }
        if(!heap.isEmpty()){
            res = heap.peek();
        }
        return res;
    }
}
// @lc code=end

