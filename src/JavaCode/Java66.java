package JavaCode;

public class Java66 {
    /**
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // digits 中所有的元素均为 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }


    /**
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     *
     * @param digits
     * @return
     */
    public int[] plusOne2(int[] digits) {
        int carry = 0;

        int tempVal = digits[digits.length - 1] + 1;
        digits[digits.length - 1] = tempVal;
        if (tempVal >= 10) {
            carry = tempVal / 10;
            digits[digits.length - 1] = tempVal % 10;
        }

        for (int i = digits.length - 2; i >= 0; i--) {
            digits[i] = digits[i] + carry;
            if (digits[i] > 10) {
                carry = digits[i] / 10;
                digits[i] = digits[i] % 10;
            } else {
                digits[i] = digits[i] % 10;
                carry = 0;
            }

        }

        if (carry != 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = carry;
            for (int i = 0; i < digits.length; i++) {
                newDigits[i + 1] = digits[i];
            }
            return newDigits;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        new Java66().plusOne(array);
    }
}
