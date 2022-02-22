package JavaCode;

public class Java258 {
    /**
     * Recursion
     * Time Complexity :
     * Space Complexity : O(1)
     * @param num
     * @return
     */
    public int addDigits(int num) {
        int result = 0;
        while(num != 0){
            result = num % 10 + result;
            num = num / 10;
        }

        if(result >= 10){
            result = addDigits(result);
        }
        return result;
    }

    /**
     * Math method
     * Time Complexity : O(1)
     * Space Complexity: O(1)
     * @param num
     * @return
     */
    public int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }

}
