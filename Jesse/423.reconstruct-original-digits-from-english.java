/*
 * @lc app=leetcode id=423 lang=java
 *
 * [423] Reconstruct Original Digits from English
 */

// @lc code=start
class Solution {
    public String originalDigits(String s) {
        List<Integer> res = new ArrayList<>();
        Map<Character,Integer> count = new HashMap();
        
        for(char c : s.toCharArray()){
            count.put(c,count.getOrDefault(c,0)+1);
        }
        
        for(int i =0; i< count.getOrDefault('z',0);i++){
            res.add(0);
        }
        for(int i =0; i< count.getOrDefault('w',0);i++){
            res.add(2);
        }
        for(int i =0; i< count.getOrDefault('u',0);i++){
            res.add(4);
        }
        for(int i =0; i< count.getOrDefault('x',0);i++){
            res.add(6);
        }
        for(int i =0; i< count.getOrDefault('g',0);i++){
            res.add(8);
        }
        for(int i =0; i< count.getOrDefault('h',0) - count.getOrDefault('g',0);i++){
            res.add(3);
        }
        for(int i =0; i<count.getOrDefault('f',0) - count.getOrDefault('u',0);i++){
            res.add(5);
        }
        for(int i =0; i<count.getOrDefault('s',0) - count.getOrDefault('x',0);i++){
            res.add(7);
        }
        for(int i =0; i<count.getOrDefault('i',0) -(count.getOrDefault('g',0)+count.getOrDefault('f',0) - count.getOrDefault('u',0) + count.getOrDefault('x',0));i++){
            res.add(9);
        }
        for(int i =0; i<count.getOrDefault('n',0) -(2*(count.getOrDefault('i',0) -(count.getOrDefault('g',0)+count.getOrDefault('f',0) - count.getOrDefault('u',0) + count.getOrDefault('x',0)))+count.getOrDefault('s',0) - count.getOrDefault('x',0));i++){
            res.add(1);
        }
        
        Collections.sort(res);
        
        StringBuilder sb = new StringBuilder();
        for(int r : res){
            sb.append(r);
        }
        return sb.toString();
    }
}
// @lc code=end

