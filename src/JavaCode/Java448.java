package JavaCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Java448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        // Put distinct items into set
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }

        // Find the lost numbers
        for (int digit :
                nums) {
            if (set.contains(digit)) {
                set.remove(digit);
            }
        }

        List list = Arrays.asList( set.toArray());
        return list;

    }
}
