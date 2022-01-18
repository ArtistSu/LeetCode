package JavaCode;

public class Java28 {
    /**
     * Time Conplexity : O(m - n)
     * Space Complexity : O(m + n)
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr3(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();

        for (int i = 0; i <= m - n; i++) {
            int haystackIndex = i;
            int needleIndex = 0;
            while(needleIndex < n && haystackArr[haystackIndex] == needleArr[needleIndex]){
                haystackIndex++;
                needleIndex++;
            }
            if (needleIndex == n){
                return i;
            }
        }
        return -1;
    }
        /**
         * Time Complexity : O(mn)
         * Space Complexity : O(1)
         * @param haystack
         * @param needle
         * @return
         */
    public int strStr2(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        for (int i = 0; i + n < m; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if(needle.charAt(j) != haystack.charAt(i+j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }


        /**
         * Time Complexity : O(mn)
         * Space Complexity : O(1)
         * @param haystack
         * @param needle
         * @return
         */
    public int strStr1(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if(m == 1 && n == 1 || needle.equals("") || (needle.equals("") && haystack.equals("")) ){
            return 0;
        }

        if(m >= n){
            for (int i = 0; i < m; i++) {
                if(haystack.charAt(i) == needle.charAt(0)){
                    if(i + n <= m && haystack.substring(i,i+n).equals(needle)){
                        return i;
                    }
                }
            }
        }
        return -1;
    }


}
