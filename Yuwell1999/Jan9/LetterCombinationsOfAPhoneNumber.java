package Jan9;

import java.util.LinkedList;
import java.util.List;

// 17
class LetterCombinationsOfAPhoneNumber {
    String[] dial = new String[]{
            "", // 0
            "", // 1
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    List<String> ans = new LinkedList<>();
    StringBuilder sequence = new StringBuilder();

    List<String> letterCombinations1(String digits) {
        if (digits.length() == 0) {
            return ans;
        }

        dfs(digits, 0);

        return ans;
    }

    public void dfs(String digits, int start) {
        if (digits.length() == start) {
            ans.add(sequence.toString());
            return;
        }

        String buttonLetters = dial[digits.charAt(start) - '0'];

        for (int i = 0; i < buttonLetters.length(); i++) {
            sequence.append(buttonLetters.charAt(i));

            dfs(digits, start + 1);

            sequence.deleteCharAt(sequence.length() - 1);
        }
    }
}