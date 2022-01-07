public class Solution {
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        //(x+1,y) (x,y-1)
        //DP(x ,y) = DP(x-1,y) + DP(x, y-1) +y is defined as down
        //DP(0, 0) = 1
        int[][] DP = new int[m][n];
        // DP[0][0] = 1;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
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