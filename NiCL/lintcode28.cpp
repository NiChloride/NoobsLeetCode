class Solution {
public:
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    bool searchMatrix(vector<vector<int>> &matrix, int target) {
        // write your code here
        int n = matrix.size(); //number of rows
        if (n==0)
        {
            return false;
        }
        int m = matrix[0].size(); //number of columns aka number of elements in each row
        if (m==0)
        {
            return false;
        }
        int start = 0;
        int end = n*m-1;
        while (start<=end)
        {
            int mid = (start+end)/2;

            int row_num = mid/m;
 
            int col_num = mid%m;
          
            if(matrix[row_num][col_num]==target)
            {
                return true;
            }
            else if (matrix[row_num][col_num]>target)
            {
                end = mid -1;
            }
            else
            {
                start = mid+1;
            }
        }
        return false;

    }
};