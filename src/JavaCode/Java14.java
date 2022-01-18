package JavaCode;

public class Java14 {
    /**
     * Vertical scanning
     * Time Complexity : O(mn)
     * Space Complexity : O(1)
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null) {
            return "";
        }

        int m = strs[0].length();
        int n = strs.length;

        for (int i = 0; i < m; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * Time Complexity : O(mn)
     * Space Complexity : O(1)
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        for (String str :
                strs) {
            if (str.equals("")) {
                return "";
            }
        }

        int m = strs[0].length();
        int n = strs.length;
        StringBuffer sb = new StringBuffer();
        boolean flag = false;

        for (int i = 0; i < m; i++) {
            char currentChar = strs[0].charAt(i);

            for (int j = 0; j < n; j++) {
                if (i >= strs[j].length() || currentChar != strs[j].charAt(i)) {
                    flag = true;
                    break;
                }

                if (j == n - 1 && currentChar == strs[j].charAt(i)) {
                    sb.append(currentChar);
                }

            }
            if (flag) {
                break;
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String a = "abc";
        System.out.println(a.substring(0, 1));
    }
}
