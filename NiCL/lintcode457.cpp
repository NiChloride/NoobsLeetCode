class Solution {
public:
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    int findPosition(vector<int> &nums, int target) {
        // write your code here
        
        int n = nums.size();
        if(n==0)
        {
            return -1;
        }
        if (target<nums[0])
        {
            return -1;
        }
        if (target>nums[n-1])
        {
            return -1;
        }
        ;
        int start = 0;
        int end = n-1;
        
        while (start <= end)
        {
            int mid = (start+end)/2;
            if (nums[mid] == target)
            {
                return mid;
            }
            else if(nums[mid] > target)
            {
                end = mid-1;
            }
            else if (nums[mid] < target)
            {
                start = mid+1;
            }
        }
        return -1;
    }
};