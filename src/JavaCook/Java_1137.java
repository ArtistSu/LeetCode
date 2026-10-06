package JavaCook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_1137{
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;

        int currIdx = 3;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(1);

        while(currIdx <= n){
            int res = 0;
            for(int ele : list){
                res+=ele;
            }
            list.add(res);
            list.remove(0);
            currIdx++;
        }

        return list.get(2);
    }

    /**
     * @TimeComplexity O(N)
     * @SpaceComplexity O(1)
     */
    public int tribonacci_google_l4(int n) {
        if(n == 0) return 0;
        if(n <= 2) return 1;

        int a = 0, b = 1, c = 1;
        for(int i = 3; i <= n; i++){
            int next = a + b + c;
            a = b; b = c; c = next;
        }
        return c;
    }
}