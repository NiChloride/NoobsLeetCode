/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        double[] distance = new double[points.length];
        double left =Integer.MAX_VALUE, right = 0;
        List<Integer> remaining = new ArrayList<>();
        
        for(int i =0; i< points.length; i++){
            distance[i] = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            right = Math.max(distance[i],right);
            left = Math.min(distance[i],left);
            remaining.add(i);
        }
        
        List<Integer> closest = new ArrayList<>();
        while(k>0){
            double mid = left + (right-left)/2;
            List<List<Integer>> split = splitDistance(distance,remaining,mid);
            List<Integer> closer = split.get(0);
            List<Integer> farther = split.get(1);
            if(closer.size()>k){
                remaining = closer;
                right = mid;
            }
            else{
                closest.addAll(closer);
                k -= closer.size();
                left = mid;
                remaining = farther;
            }
        }
        
        int[][] res= new int[closest.size()][];
        
        for(int i =0; i< closest.size(); i++){
            res[i] = points[closest.get(i)];
        }
        
        return res;
        
    }
    
    List<List<Integer>> splitDistance(double[] distance, List<Integer> remaining, double mid){
        List<List<Integer>> split  = new ArrayList<>();
        List<Integer> closer = new ArrayList<>();
        List<Integer> farther = new ArrayList<>();
        
        split.add(closer);
        split.add(farther);
        
        for(int index : remaining){
            if(distance[index] > mid){
                farther.add(index);
            }
            else{
                closer.add(index);
            }
        }
        
        return split;
    }
}
// @lc code=end

