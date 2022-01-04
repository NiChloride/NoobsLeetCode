/*
 * @lc app=leetcode id=526 lang=java
 *
 * [526] Beautiful Arrangement
 */

// @lc code=start
class Solution {
    int res = 0;
    
    void backtracking(boolean[] visited, int pos,  int n){
        if(pos > n){
            this.res+=1;
        }
        
        for(int i=1;i<=n;i++){
            
            if(!visited[i] && (i%pos ==0 || pos%i == 0)){
                visited[i] = true;
                backtracking(visited,pos+1,n);
                visited[i] = false;
            }
        }
    }
    
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n+1];
        backtracking(visited,1,n);
        return this.res;
    }
}
// @lc code=end

