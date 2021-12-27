/*
 * @lc app=leetcode id=476 lang=java
 *
 * [476] Number Complement
 */

// @lc code=start
class Solution {
    public int findComplement(int num) {
        int bitmask = num;
        bitmask |= (bitmask >> 1);
        bitmask |= (bitmask >> 2);
        bitmask |= (bitmask >> 4);
        bitmask |= (bitmask >> 8);
        bitmask |= (bitmask >> 16);
        return bitmask ^ num;
    }
}
// @lc code=end

