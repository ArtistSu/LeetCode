package JavaCode;

public class Java567 {
    /**
     * Sliding window
     * Time Complexuty :
     * Space Complexity :
     * @param s1
     * @param s2
     * @return
     * @author: Allen Su
     */
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 > n2){
            return false;
        }

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < n1; i++) {
            ++arr1[s1.charAt(i)-'a'];
            ++arr2[s2.charAt(i)-'a'];
        }
        return true;
    }
}
