import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=658 lang=java
 *
 * [658] Find K Closest Elements
 */

// @lc code=start
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<Integer>();
        
        if (arr.length == k) {
            for (int i = 0; i < k; i++) {
                res.add(arr[i]);
            }
            
            return res;
        }
        
        int left = 0;
        int right = arr.length;
        
        while (left  < right) {
            int mid = left + (right - left ) / 2;
            if(arr[mid] < x) {
                left = mid+1;
            } 
            else if(arr[mid] >= x) {
                right = mid ;
            }
        }
        
        left -= 1;
        right = left+1;
        
        while(right - left -1<k){
            if(left == -1){
                right ++;
                continue;
            }
            
            if(right == arr.length || Math.abs(arr[left]-x) <= Math.abs(arr[right]-x)){
                left -- ;
            }else{
                right ++;
            }
        }

        for (int i = left+1; i < right; i++) {
            res.add(arr[i]); 
        }
        
        return res;
        
    }
}
// @lc code=end

