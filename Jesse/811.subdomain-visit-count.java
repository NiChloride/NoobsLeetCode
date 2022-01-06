/*
 * @lc app=leetcode id=811 lang=java
 *
 * [811] Subdomain Visit Count
 */

// @lc code=start
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        if(cpdomains.length == 0 || cpdomains == null){
            return new ArrayList<String>();
        }
        Map<String,Integer> count = new HashMap<>();
        
        for(String cpdomain : cpdomains){
            String[] temp = cpdomain.split(" ");
            int times = Integer.valueOf(temp[0]);
            String totalDomain = temp[1];
            count.put(totalDomain, count.getOrDefault(totalDomain,0)+times);
            String[] domains = totalDomain.split("\\.");
            int startIdx =0;
            for(String domain : domains){
                int currentIdx = startIdx + domain.length() + 1;
                if(currentIdx >= totalDomain.length()){
                    break;
                }
                String currentDomain = totalDomain.substring(currentIdx);
                count.put(currentDomain, count.getOrDefault(currentDomain,0)+times);
                startIdx = startIdx + domain.length() + 1;
            }
        }
        
        List<String> res = new ArrayList<>();
        for(String key:count.keySet()){
            String current = String.valueOf(count.get(key))+" "+key;
            res.add(current);
        }
        
        return res;
    }
}
// @lc code=end

