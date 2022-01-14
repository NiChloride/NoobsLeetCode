/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    
    List<Integer> numbers;
    Map<Integer,Integer> buffer;
    
    void swap(int idx1, int idx2){
        int temp = numbers.get(idx2);
        numbers.set(idx2,numbers.get(idx1));
        numbers.set(idx1,temp);
    }
    
    int partition(int left, int right, int pivot_idx){
        
        int pivot_freq = buffer.get(numbers.get(pivot_idx));
        swap(right,pivot_idx);
        int index = left;
        for(int i = left; i<=right;i++){
            if(buffer.get(numbers.get(i))>=pivot_freq){
                swap(index,i);
                index ++;
            }
        }
        
        if(index<right){
            swap(index, right);
        }
        return index;
        
        
        
    }
    
    void quickselect(int left, int right, int k){
        
        
        if(left == right){
            return;
        }
        
        Random random_num = new Random();
        
        
        int pivot_idx = left + random_num.nextInt(right-left);
        
        pivot_idx = partition(left,right,pivot_idx);
        
        if(k == pivot_idx){
            return;
        }
        else if(k > pivot_idx){
            quickselect(pivot_idx, right, k);
        }
        else{
            quickselect(left, pivot_idx-1, k);
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        
        buffer = new HashMap<>();
        for(int num : nums){
            buffer.put(num,buffer.getOrDefault(num,0)+1);
        }
      
        numbers = new ArrayList<>(buffer.keySet());
        
        quickselect(0,numbers.size()-1,k);
        
        int[] res = new int[k];
        
        for(int i=0;i<res.length;i++){
            res[i] = numbers.get(i);
        }
        
        
        
        return res;
    }
}
// @lc code=end

