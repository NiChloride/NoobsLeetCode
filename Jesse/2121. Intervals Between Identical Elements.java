class Solution {

    
    
    public long[] getDistances(int[] arr) {
       
       int n=arr.length;
       long res[]=new long[n];
       Map<Integer,List<Integer>> map=new HashMap();
       for(int i=0;i<n;i++)
       {
           map.put(arr[i], map.getOrDefault(arr[i], new ArrayList<>()));
           map.get(arr[i]).add(i);
       }
       for(Map.Entry<Integer,List<Integer>> set : map.entrySet())
       {
           List<Integer> list=set.getValue();
           long pre[]=new long[list.size()],pre1[]=new long[list.size()];
           pre[0]=list.get(0);
           pre1[list.size()-1]=list.get(list.size()-1);
           for(int i =1 ;i< list.size() ;i++){
               pre[i] = pre[i-1] + list.get(i);
           }
           for(int j = list.size()-2; j>=0;j--){
               pre1[j] = pre1[j+1]+list.get(j);
           }
           
           
           for(int k =0; k< list.size(); k++){
               if(k == 0){
                   if(k+1<list.size()){
                        res[list.get(k)] = pre1[k+1] - (long)(list.size()-1-k)*list.get(k);
                   }
               }
               else if(k == list.size()-1){
                   res[list.get(k)] =(long) k*list.get(k) - pre[k-1];
               }
               else{
                    res[list.get(k)] =(long) k*list.get(k) - pre[k-1] + pre1[k+1]- (long)(list.size()-1-k)*list.get(k);
               }
              
           }
       }
       return res;
   }
   
 
}