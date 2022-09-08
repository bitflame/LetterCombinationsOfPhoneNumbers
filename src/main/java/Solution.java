import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    HashMap<Integer, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        int resultLength = digits.length() * digits.length() * digits.length();
        String[] answer = new String[resultLength];
        if (digits.length() == 0) return result;
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        if (digits.length() == 1) {
            int i = Character.getNumericValue(digits.charAt(0));
            for (Character c : map.get(i).toCharArray()) {
                result.add(c.toString());
            }
            return result;
        }
        String[] input = new String[digits.length()];
        int count = 0;
        for (Character c : digits.toCharArray()) {
            input[count] = map.get(Character.getNumericValue(c));
            count++;
        }
        count = 0;
        StringBuilder sb = new StringBuilder();

        answer[count] = input[count];
        for (int i = 0; i < input.length - 1; i++) {
            answer = connect(answer[count], input[i + 1]);
        }
        for (String s : answer) result.add(s);
        return result;
    }

    // take in two string arrays, concatenate the strings into a larger array and return it
    /*private String[] connect(String[] sa1, String[] sa2) {
        StringBuilder sb = new StringBuilder();
        String[] result = new String[sa1.length * sa2.length];
        int count = 0;
        for (String s1 : sa1)
            for (String s2 : sa2) {
                sb.append(s1);
                sb.append(s2);
                result[count] = sb.toString();
            }
        return result;
    }*/

    private String[] connect(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        String[] result = new String[s1.length() * s2.length()];
        int count = 0;
        for (Character c1 : s1.toCharArray())
            for (Character c2 : s2.toCharArray()) {
                sb.append(c1);
                sb.append(c2);
                result[count] = sb.toString();
                count++;
                sb = new StringBuilder();
            }
        return result;
    }

    public static void main(String[] args) {
        String test1 = "23";
        String test2 = "";
        String test3 = "2";
        String test4 = "234";
        Solution s = new Solution();
        System.out.println(s.letterCombinations(test1));
        System.out.println(s.letterCombinations(test2));
        System.out.println(s.letterCombinations(test3));
        // expecting ["adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"]
        System.out.println(s.letterCombinations(test4));
    }
}
