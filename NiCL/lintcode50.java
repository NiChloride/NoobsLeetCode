//productExcludeItself, O(N) solution

public class Solution {
    /*
     * @param nums: Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here'
        int len = nums.size(); //[1,2,3]
        List<Long> B = new ArrayList<>();
        List<Long> reverse_B = new ArrayList<>();
        B.add((long) 1); //[1]
        for(int i = 1;i<len;i++)
        {
            B.add(nums.get(i-1)*B.get(i-1)); //B[i] = B[i-1]*nums[i-1]; [1,1,2]
        }

        reverse_B.add((long) 1); //[1]
        for(int i = len-2; i>-1; i--)
        {
            reverse_B.add(nums.get(i+1)*reverse_B.get(len-2-i)); //[1,3,6]
        }

        for (int i=0;i<len;i++)
        {
            long temp = B.get(i);
            B.set(i, temp*reverse_B.get(len-1-i));
        }
        return B;

        
    }
}