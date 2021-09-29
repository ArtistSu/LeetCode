package Easy;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2020/12/29 9:56 上午
 * Description:
 */
public class Solution67 {

    //忽略了越界的问题
    public String addBinary(String a, String b) {
        int tempA = Solution67.convertBinary(a);
        int tempB = Solution67.convertBinary(b);
        int result = tempA + tempB;
        return Integer.toBinaryString(result);
    }

    public String addBinary2(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int i = a.length() - 1;
        int j = b.length() - 1;
        boolean tag = false;
        while (i >= 0 && j >= 0) {
            int temp = 0;
            if (tag) {
                temp = a.charAt(i--) - '0' + b.charAt(j--) - '0' + 1;
            } else {
                temp = a.charAt(i--) - '0' + b.charAt(j--) - '0';
            }

            if (temp >= 2) {
                sb.append(temp % 2);
                tag = true;
                continue;
            }
            sb.append(temp);
            tag = false;
        }
        if (tag ) {
            if(i == j) {
                sb.append("1");
            }else{
                sb.append("01");
                return sb.reverse().toString();
            }
        }
        return sb.reverse().toString();
    }

    public String addBinary4(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i>=0 || j>=0){
            int sum = carry;
            if(i>=0){
                sum += a.charAt(i--)-'0';
            }
            if(j>=0){
                sum += b.charAt(j--)-'0';
            }
            sb.insert(0,sum%2);
            carry = sum/2;
        }
        if(carry!=0){
            sb.insert(0,carry);
        }
        return sb.toString();
    }



        public static int convertBinary(String str) {
        int size = str.length() - 1;
        char[] chars = str.toCharArray();
        System.out.println(str);
        double result = 0;
        for (char c :
                chars) {
            result = result + Integer.parseInt(String.valueOf(c)) * Math.pow(2, size--);
        }
        System.out.println((int) result);
        return (int) result;
    }

    public static void main(String[] args) {
        Solution67 solution67 = new Solution67();
        System.out.println(solution67.addBinary4("0", "0"));
    }
}
