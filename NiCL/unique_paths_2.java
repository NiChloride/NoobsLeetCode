public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] DP = new int[m][n];
        // DP[0][0] = 1;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {

                if(obstacleGrid[i][j]==1)
                {
                    DP[i][j] = 0;
                    continue;
                }



                if (i==0 && j==0)
                {
                    DP[i][j] = 1;
                }
                else if(i==0)
                {
                    DP[i][j] = DP[i][j-1];
                }
                else if(j==0)
                {
                    DP[i][j] = DP[i-1][j];
                }
                else
                {
                    DP[i][j] = DP[i-1][j]+DP[i][j-1];
                }
            }
        }

        return DP[m-1][n-1];
    }
}