package JavaCode;

public class Java29 {
    /**
     * Time Complexity: O((logC)^2) {@code C} represent the range of 32 bits integer
     * Space Complexity: O(1)
     * @method Binary Search
     * @topic Divide Two Integers
     * @author ArtistS
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE){
            if(divisor == 1){
                return Integer.MIN_VALUE;
            }
            if(divisor == -1){
                return Integer.MAX_VALUE;
            }
        }

        if(divisor == Integer.MIN_VALUE){
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        if(dividend == 0){
            return 0;
        }

        boolean flag = false;
        if(dividend > 0){
            dividend = -dividend;
            flag = !flag;
        }

        if(divisor > 0){
            divisor = -divisor;
            flag = !flag;
        }

        int left = 1, right = Integer.MAX_VALUE, res = 0;
        while(left <= right){
            int mid = left + ((right - left)>>1);
            boolean check = quickPlus(divisor, mid, dividend);
            if(check){
                res = mid;
                if(mid == Integer.MAX_VALUE){
                    break;
                }
                left = mid + 1;
            }else{
                right = mid -1;
            }

        }
        return flag == false ?  res : -res;

    }

    public boolean quickPlus(int divisor, int mid, int dividend){
        int res = 0, currFactor = divisor;
        while(mid != 0){
            if((mid&1) != 0){
                if(res < dividend - currFactor){
                    return false;
                }
                res += currFactor;
            }
            if(mid != 1){
                if(currFactor < dividend - currFactor){
                    return false;
                }
                currFactor += currFactor;
            }
            mid >>= 1;
        }
        return true;
    }
}
