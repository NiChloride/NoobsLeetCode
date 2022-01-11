/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        int carrier = 0;
        StringBuilder res =new StringBuilder();
        int idxA =a.length()-1;
        int idxB =b.length()-1;
        
        while(idxA>=0 && idxB>=0){
            
            int temp = Integer.valueOf(a.charAt(idxA--)-'0') + Integer.valueOf(b.charAt(idxB--)-'0') + carrier;
            System.out.println(temp);
            carrier = temp/2;
            if(temp%2 == 1){
                res.append('1');
            }
            else{
                res.append('0');
            }
            
            
        }
        if(idxA>=0){
            while(idxA>=0){
                int temp = Integer.valueOf(a.charAt(idxA--)-'0') + carrier;
                carrier = temp/2;
                if(temp%2 == 1){
                    res.append('1');
                }
                else{
                    res.append('0');
                }
            }
        }
        else{
            while(idxB>=0){
                int temp = Integer.valueOf(b.charAt(idxB--)-'0') + carrier;
                carrier = temp/2;
                if(temp%2 == 1){
                    res.append('1');
                }
                else{
                    res.append('0');
                }
            }
        }
        
        
        if(carrier!=0){
            res.append('1');
        }
        
        res.reverse();
        return res.toString();
    }
}
// @lc code=end

