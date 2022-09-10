import java.util.LinkedList;
import java.util.List;
// This code is from https://www.youtube.com/watch?v=imD5XeNaJXA by Nick White
public class OtherSolutions {
    public List<String> lettterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.isEmpty()) return ans;
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            System.out.printf("i : %d\n", i);
            while (ans.peek().length() == i) {
                String t = ans.remove();
                System.out.printf("t : %s  \n", t);
                for (char s : mapping[x].toCharArray()) {
                    System.out.printf("t+s : %s\n", t + s);
                    ans.add(t + s);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        OtherSolutions os = new OtherSolutions();
        String test1 = "23";
        String test2 = "";
        String test3 = "2";
        String test4 = "234";
        System.out.println("Expecting: [ad, ae, af, bd, be, bf, cd, ce, cf] Getting: " + os.lettterCombinations(test1));
        System.out.println("Expecting: [], Getting: " + os.lettterCombinations(test2));
        System.out.println("Expecting: [a, b, c], Getting: " + os.lettterCombinations(test3));
        System.out.println("Expecting: [\"adg\",\"adh\",\"adi\",\"aeg\",\"aeh\",\"aei\",\"afg\",\"afh\",\"afi\",\"bdg\",\"bdh\",\"bdi\",\"beg\",\"beh\",\"bei\",\"bfg\",\"bfh\",\"bfi\",\"cdg\",\"cdh\",\"cdi\",\"ceg\",\"ceh\",\"cei\",\"cfg\",\"cfh\",\"cfi\"] Getting:  " + os.lettterCombinations(test4));
    }
}
