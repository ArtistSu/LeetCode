package JavaCode;

import java.util.Arrays;

public class Java455 {
    /**
     * Time Complexity: O(nlogn + mlogm) {@param n} is the length of {@param g}, {@param m} is the length of {@param s}
     * Space Coplexity: O(logn + mlogm)
     * @topic Assign Cookies
     * @author ArtistS
     * @method Sort + Greedy
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ptrA = 0, ptrB = 0, res = 0;
        while((ptrA <= g.length - 1)&&(ptrB <= s.length - 1)){
            int child = g[ptrA];
            int cookie = s[ptrB];
            if(child - cookie <=0){
                ptrA++;
                res+=1;
            }
            cookie++;
            ptrB++;
        }
        return res;
    }
}
