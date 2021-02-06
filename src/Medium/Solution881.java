package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/14 11:37 上午
 * Description:
 */
public class Solution881 {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int i = 0, j = people.length - 1;
        int ans = 0;

        while (i <= j) {
            ans++;
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
        }

        return ans;
    }

}
