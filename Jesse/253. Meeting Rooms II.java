class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];
        
        for(int i =0; i< intervals.length;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start,(a,b) -> Integer.compare(a,b));
        Arrays.sort(end,(a,b) -> Integer.compare(a,b));
        
        int p1 =0, p2 =0;
        int count =0;
        
        while(p1<start.length){
            if(start[p1]>= end[p2]){
                count --;
                p2++;
            }
            
            count++;
            p1++;
            
        }
        return count;
    }
}