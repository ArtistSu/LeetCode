package Easy;

/**
 * @author SuJiexi
 * @version V1.0
 * @Package Easy
 * @date 2019-05-09 11:11
 */
public class Solution9 {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        String digital = String.valueOf(x);
        int digitalLength = digital.length() ;
        for (int i = 0; i <digitalLength ; i++) {
            if (digital.charAt(i) == digital.charAt(digitalLength-1-i)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
    public boolean IsPalindromeSoluition(int x) {

        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber/10;
    }
}
