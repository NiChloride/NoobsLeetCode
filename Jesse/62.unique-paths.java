/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i =0 ;i<m;i++){
            for(int j =0; j<n ;j++){
                if(j==0 && i == 0){
                    continue;
                }
                else if(i ==0 && j != 0){
                    dp[i][j] = dp[i][j-1];
                }
                else if(j==0 && i!=0){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m-1][n-1];
    }
}
// @lc code=end

