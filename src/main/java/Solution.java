import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    HashMap<Integer, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        return func2(result, digits, 0);
    }

    public List<String> func2(List<String> latestList, String s, int currentIndex) {
        if (currentIndex >= s.length()) return latestList;
        int currentInteger = Character.getNumericValue(s.charAt(currentIndex));
        currentIndex++;
        String currentString = map.get(currentInteger);
        if (s.length() == 1) {
            for (Character c : currentString.toCharArray()) {
                latestList.add("" + c);
            }
        } else if (latestList.size() >= 1) {
            List<String> newList = new ArrayList<String>();
            for (String newString : latestList) {
                // latestList.add(currentString.concat(newString));
                for (Character c : currentString.toCharArray()) {
                    newList.add(newString.concat("" + c));
                }
            }
            latestList = newList;
        } else {
            for (Character c : currentString.toCharArray()) {
                latestList.add("" + c);
            }
        }
        return func2(latestList, s, currentIndex);
    }

    public static void main(String[] args) {
        String test1 = "23";
        String test2 = "";
        String test3 = "2";
        String test4 = "234";
        Solution s = new Solution();
        System.out.println(s.letterCombinations(test1));
        System.out.println(s.letterCombinations(test2));
        // expecting ["adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"]
        System.out.println(s.letterCombinations(test3));
        System.out.println("Expecting: expecting [\"adg\",\"adh\",\"adi\",\"aeg\",\"aeh\",\"aei\",\"afg\",\"afh\",\"afi\",\"bdg\",\"bdh\",\"bdi\",\"beg\",\"beh\",\"bei\",\"bfg\",\"bfh\",\"bfi\",\"cdg\",\"cdh\",\"cdi\",\"ceg\",\"ceh\",\"cei\",\"cfg\",\"cfh\",\"cfi\"] " +
                "\n getting: " + s.letterCombinations(test4));
    }
}
