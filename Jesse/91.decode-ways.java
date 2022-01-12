/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    
    Map<Integer,Integer> buffer = new HashMap<>();
        
    public int numDecodings(String s) {
        
        return backTracking(s,0);
            
    }
    
    int backTracking(String s,int index){
        
        if(this.buffer.containsKey(index)){
            return buffer.get(index);
        }
        
        if(index<s.length() && s.charAt(index) == '0'){
            return 0;
        }
        
        if(index >= s.length() ){
            return 1;
        }
        
        int ans = backTracking(s,index+1);
        
        if(index+2==s.length()){
            
            int temp = Integer.valueOf(s.substring(index));
            
            if(temp>=10 && temp<=26){
               ans += backTracking(s,index+2);
            }
            
        }
        else if(index+2<s.length()){
            
            int temp = Integer.valueOf(s.substring(index,index+2));
            
            if(temp>=10 && temp<=26){
               ans += backTracking(s,index+2);
            }
            
        }
        
        
        this.buffer.put(index,ans);
            
        return ans;
       
    }
    
}
// @lc code=end

