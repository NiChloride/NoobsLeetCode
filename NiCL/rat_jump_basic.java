//rat jumps down from stairs of n steps
//can jump 1,2,4 steps down each jumps
//arr[i] = 1 means on step i there is glue

public class Solution {
    /**
     * @param arr: the steps whether have glue
     * @return: the sum of the answers
     */
    public int ratJump(int[] arr) {
        // Write your code here.
        int ways = 0;
        //DP[n] = DP[n-1] + DP[n-2] + DP[n-4]
        //DP[-3] = DP[-2] = DP[-1] = DP[0] = 1
        //base case: DP[1] = DP[0] + DP[-1] + DP[-3] = 3
        //DP[2] = DP[1] + DP[0] + DP[-2] = 3 + 1 + 1 = 5
        //DP[4] = DP[3] + DP[2] + DP[0] 
        int n = arr.length;
        int[] DP = new int[n];
        DP[0] = 1;
        for(int i=1;i<n;i++)
        {
            switch(i)
            {
                case 1:
                    if(arr[1]==1)
                    {
                        DP[1] = 0;
                    }
                    else
                    {
                        DP[1] = 3;
                    }
                    break;
                case 2:
                    if(arr[2]==1)
                    {
                        DP[2] = 0;
                    }
                    else
                    {
                        DP[2] = DP[1] + 1 + 1;
                    }
                    break;
                case 3:
                    if(arr[3]==1)
                    {
                        DP[3] = 0;
                    }
                    else
                    {
                        DP[3] = DP[2] + DP[1] + 1;
                    }
                    break;
                default:
                    if(arr[i]==1)
                    {
                        DP[i] = 0;
                    }
                    else
                    {
                        DP[i] = DP[i-1] + DP[i-2] + DP[i-4];
                    }
                    break;

            }
        }

        return DP[n-1]%1000000007;

        
        
    }
}