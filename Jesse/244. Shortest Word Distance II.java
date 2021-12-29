class WordDistance {
    Map<String,ArrayList<Integer>> wordsMap = new HashMap<>();

    public WordDistance(String[] wordsDict) {
        for(int i =0; i< wordsDict.length;i++){
            String word = wordsDict[i];
            wordsMap.put(word, wordsMap.getOrDefault(word, new ArrayList<Integer>()));
            wordsMap.get(word).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        ArrayList<Integer> idxes1 = wordsMap.get(word1);
        ArrayList<Integer> idxes2 = wordsMap.get(word2);
        int shortest = Integer.MAX_VALUE;
        int i=0,j=0;
        while(i<idxes1.size() && j<idxes2.size()){
            shortest = Math.min(shortest, Math.abs(idxes1.get(i) - idxes2.get(j)));
           if(idxes1.get(i) < idxes2.get(j)){
               i++;
           }
            else{
                j++;
            }

        }
        return shortest;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */