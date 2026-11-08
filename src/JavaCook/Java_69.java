package JavaCook;

/**
 * @author ArtistS
 * @tag BinarySearch
 * @prb https://leetcode.com/problems/sqrtx/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_69 {
    /**
     * Time complexity: O(log(x))
     * Space complexity: O(1)
     */
    public int mySqrt_google_l4(int x) {
        if(x == 0){
            return 0;
        }

        int left = 1, right = x, ans = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mid == x /mid){
                return mid;
            }else if(mid < x / mid){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }

    /**
     * Time complexity: O(log(x))
     * Space complexity: O(1)
     */
    public int mySqrt_google_l5(int x) {
        if(x < 2){
            return x;
        }

        long res = x;
        while(res * res > x){
            res = (res + x/res)/2;
        }

        return (int)res;
    }

}