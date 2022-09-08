import edu.princeton.cs.algs4.StdOut;

import java.net.CacheRequest;
import java.util.Arrays;
import java.util.Hashtable;

public class First {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        //num, index
        Hashtable<Integer, Integer> cache = new Hashtable<>();
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff = target - nums[i];
            if (cache.containsKey(nums[i])) {
                result[0] = cache.get(nums[i]);
                result[1] = i;
                return result;
            } else {
                cache.put(diff, i);
            }
        }
        return result;
    }

    public boolean isFamily(String a, String b) {
        // sort the arrays
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        Arrays.sort(aChars);
        Arrays.sort(bChars);
        for (Character alpha : aChars) {
            for (Character beta : bChars) {
                if (alpha.charValue() + 1 != beta.charValue()) return false;
            }
        }
        return true;
    }

    public int power(int[] input, int index) {
        int sum = 0;
        int min = input[0];
        for (int i = 0; i <= index; i++) {
            sum += input[i];
            if (min > input[i]) min = input[i];
        }
        return sum * min;
    }

    public int totalPower(int[] power) {
        int result = 0;
        for (int i = 0; i < power.length; i++) {
            for(int j=i; j<power.length; j++) {
                result += power(power, j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        First f = new First();
        int[] p = new int[]{2, 3, 2, 1};
        System.out.println("should be 69: " + f.totalPower(p));

        String[] input = new String[]{"bag", "sfe", "cbh", "red"};
        System.out.println("should be true: " + f.isFamily("bag", "cbh"));
    }
}
