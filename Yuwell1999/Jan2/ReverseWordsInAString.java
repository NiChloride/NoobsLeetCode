package Jan2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 151
class ReverseWordsInAString {
    public String reverseWords(String s) {
        s = s.replaceAll(" +"," ");
        s = s.trim();
        String[] words =  s.split(" ");

        List<String> ss=new ArrayList<>(words.length);
        for(String s1:words){
            ss.add(s1);
        }
        Collections.reverse(ss);

        return String.join(" ",ss);
    }
}