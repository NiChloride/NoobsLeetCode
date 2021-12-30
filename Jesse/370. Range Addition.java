    public int[] getModifiedArray(int length, int[][] updates) {
        int[] temp = new int[length];
        for(int[] update: updates){
            temp[update[0]] += update[2];
            if(update[1]< length-1){
                temp[update[1]+1] += -update[2];
            }
        }
        
        
        return sum(temp,new int[length]);
        
        
        
        
        
    }
    
    int[] sum(int[] arr1, int[] arr2){
        arr2[0] = arr1[0];
        
        for(int i =1; i< arr1.length; i++){
            arr2[i] = arr2[i-1]+arr1[i];
        }
        
        return arr2;
    }