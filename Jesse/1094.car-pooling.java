/*
 * @lc app=leetcode id=1094 lang=java
 *
 * [1094] Car Pooling
 */

// @lc code=start
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer,Integer> count = new HashMap<>();
        
        for(int[] trip : trips){
            count.put(trip[1],count.getOrDefault(trip[1],0)+trip[0]);
            count.put(trip[2],count.getOrDefault(trip[2],0)-trip[0]);
        }
        
        ArrayList<Integer> stations = new ArrayList<Integer>(count.keySet());
        Collections.sort(stations);
        
        int passengers = 0;
        for(int station : stations){
            passengers += count.get(station);
            if(passengers>capacity){
                return false;
            }
        }
        
        return true;
    }
}
// @lc code=end

