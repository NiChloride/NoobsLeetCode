class Solution {
public:
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    int findPeak(vector<int> &A) {
        // write your code here
        int start =0;
        int end = A.size() - 1;
        while(start+1<end)
        {
            int mid = (start+end)/2;
            if(A[mid]<A[mid+1])
            {
                start = mid;
            }
            else if (A[mid]<A[mid-1])
            {
                end = mid;
            }
            else{
                return mid;
            }
        }


    }

    
};