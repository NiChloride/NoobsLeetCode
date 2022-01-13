/*
 * @lc app=leetcode id=2101 lang=java
 *
 * [2101] Detonate the Maximum Bombs
 */

// @lc code=start
class Solution {
    public int maximumDetonation(int[][] bombs) {
        int res =0;
        for(int i=0;i<bombs.length;i++){
            res = Math.max(res,dfs(bombs,new boolean[bombs.length],i));
        }
        
        return 1+res;
    }
    
    int dfs(int[][] bombs, boolean[] visited,  int index){
        visited[index] = true;
        int res =0;
        for(int i=0;i<bombs.length;i++){
            if(!visited[i] && intersect(bombs,index,i)){
                res++;
                res += dfs(bombs,visited,i);
            }
        }
        return res;
    }
    
    boolean intersect(int[][] bombs, int idx1, int idx2){
        long x1 = bombs[idx1][0];
        long y1 = bombs[idx1][1];
        long x2 = bombs[idx2][0];
        long y2 = bombs[idx2][1];
        
        long r =bombs[idx1][2];
        long dx =x1-x2;
        long dy =y1-y2;
        
        return r*r >= dx*dx + dy*dy;
    }
}
// @lc code=end

