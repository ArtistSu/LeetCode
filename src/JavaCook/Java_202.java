package JavaCook;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ArtistS
 * @tag HashTable
 * @prb https://leetcode.com/problems/happy-number/description/
 * Time complexity:O(logn)
 * Space complexity: O(1)
 */
public class Java_202{
    /**
     * Time complexity:O(log(N))
     * Space complexity: O(1)
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        while(fast != 1 && slow != fast){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;
    }

    // Due to here will cost O(log(N)), even it trigger multiple times, it will still rapidly converge to a very small constant range
    public int getNext(int n){
        int sum = 0;
        while( n > 0){
            int digit = n % 10;
            n /= 10;
            sum += digit * digit;
        }
        return sum;
    }
}